
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
                        this.isEmpty(iterator);
                        while (iterator.hasNext())
                        {
                            this.printLiteratureInfo(iterator.next());
                        }
                        this.returnToMainMenu();
                        menuSelection = this.defaultMenuPosition;
                        break;

                    //register submenu
                    case 2:
                        this.printRegisterSubMenu();
                        int registerSubMenuSelection = inputScanner.menuSelection(4);
                        switch (registerSubMenuSelection)
                        {
                            case 1:
                                application.addNewspaper(this.getTitle(), this.getPublisher(), this.getIssueNumber(), this.getGenre(), this.getPrice());
                                if (this.returnToMainMenu())
                                {
                                    menuSelection = this.defaultMenuPosition;
                                }
                                break;

                            case 2:
                                application.addBook(this.getTitle(), this.getAuthor(), this.getPublisher(), this.getGenre(), this.getEdition(), this.getPrice());
                                if (this.returnToMainMenu())
                                {
                                    menuSelection = this.defaultMenuPosition;
                                }
                                break;

                            case 3:
                                System.out.println("placeholder");
                                if (this.returnToMainMenu())
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

                    //search submenu
                    case 3:
                        this.printFindProductSubMenu();
                        int FindProductSubmenuSelection = inputScanner.menuSelection(4);
                        switch (FindProductSubmenuSelection)
                        {
                            case 1:
                                Iterator<Literature> results1 = application.searchByTitle(this.getTitle());
                                this.isEmpty(results1);
                                while (results1.hasNext())
                                {
                                    this.printLiteratureInfo(results1.next());
                                }
                                if (this.returnToMainMenu())
                                {
                                    menuSelection = this.defaultMenuPosition;
                                }
                                break;

                            case 2:
                                Iterator<Literature> results2 = application.searchByPublisher(this.getTitle());
                                this.isEmpty(results2);
                                while (results2.hasNext())
                                {
                                    this.printLiteratureInfo(results2.next());
                                }
                                if (this.returnToMainMenu())
                                {
                                    menuSelection = this.defaultMenuPosition;
                                }
                                break;

                            case 3:
                                Iterator<Literature> results3 = application.searchByTitleAndPublisher(this.getTitle(), this.getPublisher());
                                this.isEmpty(results3);
                                while (results3.hasNext())
                                {
                                    this.printLiteratureInfo(results3.next());
                                }
                                if (this.returnToMainMenu())
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

                    case 4:
                        if (application.removeLiterature(this.getTitle()));
                        {
                            System.out.println("\nSuccessfully removed product!");
                        }
                        else
                        {
                            System.out.println("\nDid not find any litterature with that title");
                        }
                        if (this.returnToMainMenu())
                        {
                            menuSelection = this.defaultMenuPosition;
                        }
                        break;

                    case 5:
                        if (application.changePrice(this.getTitle(), this.getPrice()))
                        {
                            System.out.println("\nSuccessfully changed price of product");
                        }
                        else
                        {
                            System.out.println("\nInvalid price or title");
                        }
                        if (this.returnToMainMenu())
                        {
                            menuSelection = this.defaultMenuPosition;
                        }
                        break;

                    //exit the application
                    case 6:
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
        System.out.println("3. Find a product by title and/or publisher");
        System.out.println("4. Remove product");
        System.out.println("5. Change price of product");
        System.out.println("6. Exit\n");
        System.out.println("Please choose menu item (1-4): \n");
        System.out.print(">  ");
    }

    /**
     * Prints the register submenu to system out
     */
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

    /**
     * Prints the search submenu to system out
     */
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

    /**
     * Prints all valid info from the literature parameter to system out
     *
     * @param literature you want to print information from
     */
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

    /**
     * Returns true if "yes" is inputted by user and false if "no" is. Prints:
     * "Do you want to go back to main menu?" upon use and an error message if
     * invalid statement is entered by user.
     *
     * @return Returns true if "yes" is inputted by user and false if "no" is
     */
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

    /**
     * Checks if iterator is empty and prints error message if it is and
     * "products" as header for whatever you choose to print next
     *
     * @param iterator you want print header for
     */
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

    /**
     * Asks user for title and returns it
     *
     * @return title entered by user
     */
    private String getTitle()
    {
        System.out.println("\nPlease insert name of literature");
        System.out.print("\n>  ");
        return inputScanner.getFirstWord();
    }

    /**
     * Asks user for publisher and returns it
     *
     * @return publisher entered by user
     */
    private String getPublisher()
    {
        System.out.println("\nPlease insert publisher of literature");
        System.out.print("\n>  ");
        return inputScanner.getFirstWord();
    }

    /**
     * Asks user for price and returns the value as a double
     *
     * @return the new price the user wants to set
     */
    private double getPrice()
    {
        System.out.println("\nPlease insert new price of product");
        System.out.print("\n>  ");
        return inputScanner.getNextDouble();
    }
    
    /**
     * Asks the user for the issue number of the paper and returns it as an int
     * 
     * @return the issue number of the paper
     */
    private int getIssueNumber()
    {
        System.out.println("\nPlease insert issue number of the paper");
        System.out.print("\n>  ");
        return inputScanner.getNextInt();
    }

    /**
     * Asks the user for the genre and returns it as string
     * @return genre of the product
     */
    private String getGenre()
    {
        System.out.println("\nPlease insert genre of literature");
        System.out.print("\n>  ");
        return inputScanner.getFirstWord();
    }
    
    /**
     * Asks the user for the author and returns it as string
     * @return author of the product
     */
    private String getAuthor()
    {
        System.out.println("\nPlease insert Author of literature");
        System.out.print("\n>  ");
        return inputScanner.getFirstWord();
    }
    
    /**
     * Asks the user for the edition and returns it as int
     * @return edition of the product
     */
    private int getEdition()
    {
        System.out.println("\nPlease insert genre of literature");
        System.out.print("\n>  ");
        return inputScanner.getNextInt();
    }
    
}
