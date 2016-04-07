
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
     * returns an iterator of all the literature in the collection if 
     * ther is any literature in the collection.
     * 
     * @return an iterator of all the literature in the collection.
     */
    public Iterator<Literature> getAllLiterature()
    {
        return register.getCollection();
    }
    
    /**
     * Searches for literature by an given publisher and returns an 
     * iterator of the literature by that publisher.
     * 
     * @param publisher  The publisher of the literature.
     * @return all Literature from one publisher.
     */
    public Iterator<Literature> searchByPublisher(String publisher)
    {
        return register.searchByPublisher(publisher);
    }
    
    /**
     * Searches for literature by title and publisher, 
     * returns an iterature of the given literature. 
     * 
     * @param title  The title of the literature.
     * @param publisher  The publisher of the literature.
     * @return an iterator of the literature with the given parameters.
     */
    public Iterator<Literature> searchByTitleAndPublisher(String title, String publisher)
    {
        return register.searchByTitleAndPublisher(title, publisher);
    }
    
    
    /**
     * Searches for a pice of literature by titel and 
     * returns the Literature with the given title it excists.
     * 
     * @param title  The title of the of the literature.
     * @return an itteratore of the collection Literature.
     */
    public Iterator<Literature> searchByTitle(String title)
    {
        return register.searchByTitle(title);
    }
    

    /**
     * Changes the price of the Literature if the price is a positive number.
     * 
     * @param title  The title of the literature which the user want to change the price of.
     * @param price  New price you want to set.
     * @return succsesfull , returns true if the price was chaneged.
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
     * Adds a newspaper to the register, with the needed parameters.
     * 
     * @param title  The title of the newspaper.
     * @param publisher  The publisher of the newspaper.
     * @param issueNumber  The sequence number of the paper by the year.
     * @param genre  The genre of the newspaper.
     * @param price  The price of the paper.
     */
    public void addNewspaper(String title, String publisher, int issueNumber, String genre, double price)
    {
        
       register.addLiterature(new Newspaper(title, publisher, issueNumber, genre, price));
        
    }
    
    
    /**
     * Adds a book to the register, with the needed parameters.
     * 
     * @param title  The title of the book.
     * @param author  The author of the book.
     * @param publisher  The publisher of the book. 
     * @param genre  The genre of the book.
     * @param edition  The edition of the book. 
     * @param price  The price of the book.
     */
    public void addBook(String title, String author, String publisher, String genre, int edition, double price)
    {
       register.addLiterature(new Book(title, publisher, price, genre, edition, author));
    }
    
    
    /**
     * Searches for the literature by title and removes it if it's found in the 
     * collection. If not, it returns fals.
     * 
     * @param title of the literature.
     * @return succesfull, returns true if literature was suucsesfully removed.
     */
    public boolean removeLiterature(String title)
    {
        
        boolean succesfull = false;
        
        
        Iterator<Literature> iterator = searchByTitle(title);
        while(iterator.hasNext())
        {
            succesfull = true; 
            register.removeLiterature(iterator.next());
        }
        return succesfull;
    }
    

}
