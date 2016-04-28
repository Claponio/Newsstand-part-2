
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
/**
 *
 * @author Vegard
 */
public class MainWindow extends javafx.application.Application
{
    
    
    /**
     * Register containing the Literature. This reg is non-JavaFX-specific.
     */
    private Register litReg;

    /**
     * An ObservableList used to "wrap" the real register to enable the link
     * between the TableView and the LiteratureRegister.
     */
    private ObservableList<Literature> literatures;
    
    
    @Override
    public void init()
    {
        litReg = new Register();
        this.fillRegisterWithDummyData();
    }
    
    /**
     * The start-method is called by the JavaFX platform upon starting the
     * JavaFX-platform. The method is abstract and must be overridden by any
     * subclass of Application. The main window is setup in this method,
     * including menus, toolboxes etc.
     *
     * @param primaryStage The main stage making up the main window.
     */
    @Override
     public void start(Stage primaryStage)
    {

        BorderPane root = new BorderPane(); // Create the root node. The Menu will be placed at the top
        //centre content
        root.setCenter(this.centreContent());
        root.setTop(this.searchBar());
        
        
        // Create the scene, adding the rootNode and setting the size
        Scene scene = new Scene(root, 600, 500);
        // Set title of the stage (window) and add the scene
        primaryStage.setTitle("Newsstand");
        primaryStage.setScene(scene);
        // Finally, make the stage (window) visible
        primaryStage.show();
    }
     
    private Node centreContent()
    {
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(5, 5, 5, 5));
        TableView tableView;

        
        // Making the table
        // The Title-column
        TableColumn<Literature, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setMinWidth(200);
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        // The Publisher-column
        TableColumn<Literature, String> publisherColumn = new TableColumn<>("Publisher");
        publisherColumn.setMinWidth(200);
        publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        
        //The Price-column
        TableColumn<Literature, String> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(200);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        tableView = new TableView();
        tableView.setItems(this.getLiteratureList());
        tableView.getColumns().addAll(titleColumn, publisherColumn, priceColumn);
        
        //Message for when table is empty
        tableView.setPlaceholder(new Label("No literature found"));

        
        // buttons for adding literature
        // they open new dialogs
        
        
        HBox hboxBottom = new HBox();
        hboxBottom.setSpacing(5);
        hboxBottom.setPadding(new Insets(5, 5, 5, 5));
        hboxBottom.setAlignment(Pos.CENTER);
        
        
        Button newsPaperButton = new Button("Add Newspaper");
        newsPaperButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                doAddNewspaper();
            }
        });
        Button bookButton = new Button("Add Book");
        bookButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                doAddBook();
            }
        });
        
        
        //Delete selected item
        
        HBox hboxTop = new HBox();
        hboxTop.setSpacing(5);
        hboxTop.setPadding(new Insets(5, 5, 5, 5));
        hboxTop.setAlignment(Pos.CENTER);
        
        
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                removeLiterature((Literature)tableView.getSelectionModel().getSelectedItem());
            }
        });
        
        //putting together the center content
        hboxTop.getChildren().add(deleteButton);
        hboxBottom.getChildren().add(newsPaperButton);
        hboxBottom.getChildren().add(bookButton);
        vbox.getChildren().add(tableView);
        vbox.getChildren().add(hboxTop);
        vbox.getChildren().add(hboxBottom);
        
        //return center content node
        return vbox;
    }
    
    
    
    private Node searchBar()
    {   
        VBox vbox = new VBox();
        HBox hboxTop = new HBox();
        HBox hboxBottom = new HBox();
        
        //set alignment and padding
        hboxTop.setPadding(new Insets(10, 5, 5, 5));
        hboxTop.setAlignment(Pos.CENTER);
        hboxBottom.setPadding(new Insets(5, 5, 10, 5));
        hboxBottom.setAlignment(Pos.CENTER);
        
        //searchfield
        TextField searchfield = new TextField();
        searchfield.setPromptText("What are you looking for");
        
        //search checkboxes
        CheckBox box1 = new CheckBox("Title");
        CheckBox box2 = new CheckBox("Publisher");
        
        //add checkboxes to bottom hboxBottom
        hboxBottom.getChildren().add(box1);
        hboxBottom.getChildren().add(box2);
        box1.setSelected(true);
        
        //search button
        Button searchButton = new Button("Search");
        searchButton.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if(searchfield.getText().isEmpty())
                {
                    updateObservableList();
                }
                else
                {
                    search(searchfield.getText(), box2.isSelected(), box1.isSelected());
                }
            }
        });
        
        //add search bar and button to top hboxBottom
        hboxTop.getChildren().add(searchfield);
        hboxTop.getChildren().add(searchButton);
        
        //add bar and checkboxes to vbox that is returned by method
        vbox.getChildren().add(hboxTop);
        vbox.getChildren().add(hboxBottom);
        return vbox;
    }
    
    
    /**
     * Returns an ObservableList holding the literatures to display.
     *
     * @return an ObservableList holding the literatures to display.
     */
    private ObservableList<Literature> getLiteratureList()
    {
        // Create an ObservableArrayList wrapping the LiteratureRegister
        literatures
                = FXCollections.observableArrayList(this.litReg.getRegister());
        return literatures;
    }
    
      /**
     * The stop() method is being called by the JavaFX-platform when the
     * platform stops, are being terminated. This would typically happen as a
     * result of the last open window being closed. Override this method to make
     * sure that the application is terminated.
     */
    @Override
    public void stop()
    {
        System.exit(0);
    }
    
     /**
     * Updates the ObservableArray wrapper with the current content in the
     * Literature register. Call this method whenever changes are made to the
     * underlying LiteratureRegister.
     */
    private void updateObservableList()
    {
        this.literatures.setAll(this.litReg.getRegister());
    }
    
    /**
     * Search for literature by Title Publisher or both. Updates the ObservableArray wrapper with
     * the search results.
     * 
     * @param input from the search text field
     * @param chkboxPublisher, check box for search by publisher
     * @param chkboxTitle, check box for search by title
     */
    private void search(String input, boolean chkboxPublisher, boolean chkboxTitle)
    {
        this.literatures.clear();
        ArrayList<Literature> results = new ArrayList<>();
        if(chkboxPublisher)
        {
            Iterator<Literature> i = this.litReg.searchByPublisher(input);
            while(i.hasNext())
            {
                results.add(i.next());
            }
        }
        if(chkboxTitle)
        {
            Iterator<Literature> i = this.litReg.searchByTitle(input);
            while(i.hasNext())
            {
                results.add(i.next());
            }
        }
        this.literatures.setAll(results);
        
    }
    
    /**
     * Opens a dialog for adding a new newspaper with all the required text fields
     */
    private void doAddNewspaper()
    {
        AddNewspaperDialog npDialog = new AddNewspaperDialog();

        Optional<Newspaper> result = npDialog.showAndWait();

        if (result.isPresent())
        {
            Newspaper newspaper = result.get();
            litReg.addLiterature(newspaper);
            updateObservableList();
        }
    }
    
    /**
     * Opens a dialog for adding a new book with all the required text fields
     */
    private void doAddBook()
    {
        AddBookDialog bookDialog = new AddBookDialog();

        Optional<Book> result = bookDialog.showAndWait();

        if (result.isPresent())
        {
            Book book = result.get();
            litReg.addLiterature(book);
            updateObservableList();
        }
    }
    
    /**
     * removes the literature from the register and updates the observableList
     * 
     * @param literature you want to remove
     */
    private void removeLiterature(Literature literature)
    {
        this.litReg.removeLiterature(literature);
        this.updateObservableList();
        
    }
    
    
    /**
     * Main method of the application
     * 
     * 
     * @param args 
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
    /**
     * Fills the register with dummy data.
     */
    private void fillRegisterWithDummyData()
    {
        this.litReg.addLiterature(new Newspaper("VG", "Schibsted Norge", 123, "National news", 20.0));
        this.litReg.addLiterature(new Newspaper("Aftenposten", "Schibsted Norge", 204, "National news", 20.0));
        this.litReg.addLiterature(new Newspaper("Dagbladet", "Dagbladet", 48, "National news", 20.0));
        this.litReg.addLiterature(new Newspaper("Hordaland", "Hordaland", 12, "National news", 20.0));
        this.litReg.addLiterature(new Book("Bibelen", "Gud", 500, "Fiction", 3728, "Hesus"));
        this.litReg.addLiterature(new Book("LoTR", "George Allen & Unwin", 250, "Fiction", 3, "JRR Tolkien"));
        this.litReg.addLiterature(new Book("OOP", "Helvete", 300, "Demotivasjon", 8, "Djevelen"));
        this.litReg.addLiterature(new Book("How to do stuff", "Someone", 600, "Educational", 5, "Some person"));
    }
    
    
}
