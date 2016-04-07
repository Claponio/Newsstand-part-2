
import java.util.Iterator;



/**
 * Class Application - the class teth connects the UserInterface with the
 * with the registers.
 * 
 * This class is used to access all the commands used by the system.
 * 
 * @author Morten Solli, Oscar Kise, Ole Martin Hanstveit.
 * @version V1.0.1. 04.03.2016
 */
public class Application
{
    private Register register;
       
    /**
     * Creates the registers the application: Newsstand needs, ex. 
     * 
     */
    public Application()
    {
        
        register = new Register();
        
    }
    
  
    
    /**
     * returns all the literature in the register
     * 
     * 
     */
    public Iterator<Literature> getAllLiterature()
    {
        return register.getCollection();
    }
    
    /**
     * returns all the Literature from by a specific publisher
     * 
     * @return all Literature from one publisher
     */
    public Iterator<Literature> searchByPublisher(String publisher)
    {
        return register.searchByPublisher(publisher);
    }
    
    /**
     * returns the Literature with the given title and publisher if it excists.
     * 
     * @return returns the newspaper with the given title 
     */
    public Iterator<Literature> searchByTitleAndPublisher(String title, String publisher)
    {
        return register.searchByTitleAndPublisher(title, publisher);
    }
    
    
    /**
     * returns the Literature with the given title it it excists.
     * 
     * @param title
     * @return 
     */
    public Iterator<Literature> searchByTitle(String title)
    {
        return register.searchByTitle(title);
    }
    

    /**
     * Changes the price of the Literature if price is positive
     * 
     * @param title of the literature which the user want to change the price of.
     * @param new price you want to set.
     */
    public boolean changePrice(String title, double price)
    {
        boolean succesfull = false;
        
        if (price <= 0)
        {
            return succesfull;
        }
        
        Iterator<Literature> iterator = register.searchByTitle(title);
        while(iterator.hasNext())
        {
            succesfull = true;
            Literature literature = iterator.next();
            literature.setPrice(price);
        }
        
        return succesfull;
       
    }
    
    /**
     * Adds a newspaper to the register
     * 
     * @param title of the newspaper
     * @param publisher of the newspaper
     * @param issueNumber, the sequence number of the paper by the year
     * @param genre of the newspaper
     * @param price of the paper
     */
    public void addNewspaper(String title, String publisher, int issueNumber, String genre, double price)
    {
        
       register.addLiterature(new Newspaper(title, publisher, issueNumber, genre, price));
        
    }
    
    
    /**
     * Adds a book to the register
     * 
     * @param title of the book 
     * @param author of the book 
     * @param publisher of the book 
     * @param genre of the book 
     * @param edition of the book 
     * @param price of the book 
     */
    public void addBook(String title, String author, String publisher, String genre, int edition, double price)
    {
       register.addLiterature(new Book(title, publisher, price, genre, edition, author));
    }
    
    
    /**
     * remove a piece of literature
     * 
     * @param title of the literature
     */
    public void removeLiterature(String title)
    {
        Iterator<Literature> iterator = searchByTitle(title);
        while(iterator.hasNext())
        {
            register.removeLiterature(iterator.next());
        }
    }
    
}
