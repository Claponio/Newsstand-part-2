/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vegard
 */

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * A dialog used to get the necessary information about a newspaper from the
 * user, in order to be able to create a Newspaper instance to be added
 * to the register.
 *
 * @author asty
 */
public class AddBookDialog extends Dialog<Book>
{

    /**
     * Creates an instance of the NewspaperDetails dialog
     */
    public AddBookDialog()
    {
        super();
        setTitle("Book Details");

        // Set the button types.
        getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField title = new TextField();
        title.setPromptText("Title");

        TextField publisher = new TextField();
        publisher.setPromptText("Publisher");
        
        TextField genre = new TextField();
        genre.setPromptText("Genre");

        TextField editionTxt = new TextField();
        editionTxt.setPromptText("Edition");
        
        TextField author = new TextField();
        author.setPromptText("Author");

        // Prevent characters (non-integers) to be added
        editionTxt.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue)
            {
                try
                {
                    if (newValue.length() > 0)
                    {
                        Integer.parseInt(newValue);
                    }
                } catch (NumberFormatException e)
                {
                    editionTxt.setText(oldValue);
                }
            }
        });

        TextField priceTxt = new TextField();
        priceTxt.setPromptText("Price");
        // Prevent characters (non-doubles) to be added
        priceTxt.textProperty().addListener(new ChangeListener<String>()
        {
            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue)
            {
                try
                {
                    if (newValue.length() > 0)
                    {
                        Double.parseDouble(newValue);
                    }
                } catch (NumberFormatException e)
                {
                    priceTxt.setText(oldValue);
                }
            }
        });

        grid.add(new Label("Title:"), 0, 0);
        grid.add(title, 1, 0);
        grid.add(new Label("Publisher:"), 0, 1);
        grid.add(publisher, 1, 1);
        grid.add(new Label("edition:"), 0, 2);
        grid.add(editionTxt, 1, 2);
        grid.add(new Label("Genre:"), 0, 3);
        grid.add(genre, 1, 3);
        grid.add(new Label("Price:"), 0, 4);
        grid.add(priceTxt, 1, 4);
        grid.add(new Label("Author:"), 0, 5);
        grid.add(author, 1, 5);
        

        getDialogPane().setContent(grid);

        // Convert the result to a username-password-pair when the OK button is clicked.
        setResultConverter(new Callback<ButtonType, Book>()
        {
            @Override
            public Book call(ButtonType button)
            {
                if (button == ButtonType.OK)
                {
                    double price = Double.parseDouble(priceTxt.getText());
                    int edition = Integer.parseInt(editionTxt.getText());
                    return new Book(title.getText(), publisher.getText(), price, genre.getText(), edition, author.getText());
                }
                return null;
            }
        });
    }
}


