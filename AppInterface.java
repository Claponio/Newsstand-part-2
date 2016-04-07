
import java.util.InputMismatchException;
import java.util.Iterator;

/**
 * Makes up the user interface (text based) of the application. Responsible for
 * all user interaction, like displaying the menu and receiving input from the
 * user through the Input scanner.
 *
 * @author asty og Vegard Fjørtoft
 */
class AppInterface
{

    private final Application application;
    //scanner for user input
    private final InputScanner inputScanner;
    //use to keep track of where in the main menu we are
    private int menuSelection;
    //default position in menu
    private final int defaultMenuPosition;

    /**
     * Creates an instance of the AppInterface User interface. An instance of
     * the AppInterface is created, and initialized.
     */
    public AppInterface()
    {
        //TODO: Replace "new DummyApplication" with your application class.
        this.application = new Application();
        this.inputScanner = new InputScanner();
        this.defaultMenuPosition = 0;
        this.menuSelection = 0;

    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    void start()
    {
        //this.application.init();

        boolean quit = false;

        while (!quit)
        {
            try
            {

                switch (menuSelection)
                {
                    //default
                    case 0:
                        this.printMainMenu();
                        menuSelection = inputScanner.menuSelection(4);
                        break;

                    //lists all products
                    case 1:
                        Iterator<Literature> iterator = application.getAllLiterature();
                        isEmpty(iterator);
                        while (iterator.hasNext())
                        {
                            printLiteratureInfo(iterator.next());
                        }
                        returnToMainMenu();
                        menuSelection = this.defaultMenuPosition;
                        break;

                    //enters register submenu where you choose what to register
                    case 2:
                        this.printRegisterSubMenu();
                        int registerSubMenuSelection = inputScanner.menuSelection(4);
                        switch (registerSubMenuSelection)
                        {
                            case 1:
                                System.out.println("placeholder");
                                //this.application.doRegisterNewspaper();
                                break;

                            case 2:
                                //TODO: add method for registering different product
                                System.out.println("placeholder");
                                break;

                            case 3:
                                //TODO: add method for registering different product
                                System.out.println("placeholder");
                                break;

                            //goes back to default position in main menu
                            case 4:
                                menuSelection = this.defaultMenuPosition;
                                break;
                        }
                        break;

                    //find product by description, more search options will be added in own submenu
                    case 3:
                        this.printFindProductSubMenu();
                        int FindProductSubmenuSelection = inputScanner.menuSelection(4);
                        switch (FindProductSubmenuSelection)
                        {
                            case 1:
                                System.out.println("placeholder");
                                //this.application.doRegisterNewspaper();
                                break;

                            case 2:
                                //TODO: add method for registering different product
                                System.out.println("placeholder");
                                break;

                            case 3:
//                                String title = this.getTitle();
//                                String publisher = this.getPublisher();
                                Iterator<Literature> results = application.searchByTitleAndPublisher(this.getTitle(), this.getPublisher());
                                isEmpty(results);
                                while (results.hasNext())
                                {
                                    printLiteratureInfo(results.next());
                                }
                                if (returnToMainMenu())
                                {
                                    menuSelection = this.defaultMenuPosition;
                                }
                                break;

                            //goes back to default position in main menu
                            case 4:
                                menuSelection = this.defaultMenuPosition;
                                break;
                        }

                        break;

                    //exit the application
                    case 4:
                        System.out.println("\nThank you for using Application v0.1. Bye!\n");
                        quit = true;
                        break;

                    default:
                }
            }
            catch (InputMismatchException ime)
            {
                System.out.println("\nERROR: Please provide a valid menu number..\n");
            }

        }

    }

    /**
     * Prints the main menu to system out.
     */
    private void printMainMenu()
    {
        System.out.println("\n**** Application v0.1 ****\n");
        System.out.println("1. List all products");
        System.out.println("2. Register new product");
        System.out.println("3. Find a product by title and publisher");
        System.out.println("4. Exit\n");
        System.out.println("Please choose menu item (1-4): \n");
        System.out.print(">  ");
    }

    private void printRegisterSubMenu()
    {
        System.out.println("What item do you want to register? \n");
        System.out.println("1. Register newspaper");
        System.out.println("2. Register book");
        System.out.println("3. Placeholder different item");
        System.out.println("4. Go back \n");
        System.out.println("Please choose menu item (1-4): \n");
        System.out.print(">  ");
    }

    private void printFindProductSubMenu()
    {
        System.out.println("Which search function do you want to use? \n");
        System.out.println("1. By title");
        System.out.println("2. By publisher");
        System.out.println("3. By title and publisher");
        System.out.println("4. Go back \n");
        System.out.println("Please choose menu item (1-4): \n");
        System.out.print(">  ");
    }

    private void printLiteratureInfo(Literature literature)
    {
        if (literature instanceof Newspaper)
        {
            Newspaper newspaper = (Newspaper) literature;
            System.out.println("Newspaper: "
                    + "\nTitle:" + newspaper.getTitle()
                    + "\nPublisher: " + newspaper.getPublisher()
                    + "\nIsuue: " + newspaper.getIssueNumber()
                    + "\nGenre: " + newspaper.getGenre()
                    + "\nPrice: " + newspaper.getPrice());
        }
        else if (literature instanceof Book)
        {
            Book book = (Book) literature;
            System.out.println("Book:"
                    + "\nTitle:" + book.getTitle()
                    + "\nAuthor: " + book.getPublisher()
                    + "\nPublisher: " + book.getPublisher()
                    + "\nEdition: " + book.getEdition()
                    + "\nGenre: " + book.getGenre()
                    + "\nPrice: " + book.getPrice());
        }
    }

    private boolean returnToMainMenu()
    {
        System.out.println("\nDo you want to go back to main menu?");
        boolean choice = false;
        boolean stop = false;
        while (!stop)
        {
            try
            {
                System.out.print("\n>  ");
                choice = inputScanner.getYesNoInput();
                stop = true;
            }
            catch (InvalidInputStringException iise)
            {
                System.out.println("\nERROR: Only valid statements are yes or no");
            }
        }
        return choice;
    }

    private void isEmpty(Iterator<Literature> iterator)
    {
        if (!iterator.hasNext())
        {
            System.out.println("No registered literature");
        }
        else
        {
            System.out.println("\nProducts: \n");
        }
    }

    private String getTitle()
    {
        System.out.println("\nPlease insert name of literature");
        System.out.print("\n>  ");
        return inputScanner.getFirstWord();
    }

    private String getPublisher()
    {
        System.out.println("\nPlease insert publisher of literature");
        System.out.print("\n>  ");
        return inputScanner.getFirstWord();
    }

}
