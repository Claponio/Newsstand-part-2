
/**
 * abstract class Literature, an object of this class is created when a sub class
 * creates an object. Information needed for this class is:
 * 
 * Title, Publisher, Genre, Price
 * 
 * @author Morten
 * @version 1.0.0   05.04.2016
 */
public abstract class Literature 
{
    private String title;           //Title of the literature
    private String publisher;       //Publisher of the literature
    private String genre;           //Genre of the literature
    private double price;           //Price of the literature in NOK
    
    
    /**
     * Counstructer for objects of the class Literature
     * 
     * @param title of the literature
     * @param publisher of the literature
     * @param price of the literature in NOK
     * @param genre of the literature
     */
    public Literature (String title, String publisher, double price, String genre)
    {
        this.title = title;
        this.publisher = publisher;
        this.price = price;
        this.genre = genre;
    }
    
    
    /**
     * Returns the title of the literature
     * 
     * @return title of the literature
     */
    public String getTitle()
    {
        return this.title;
    }
    
    
    /**
     * Returns the publisher of the literature.
     * 
     * @return publisher of the literature.
     */
    public String getPublisher()
    {
        return this.publisher;
    }
    
    
    /**
     * Returns the genre of the literature.
     * 
     * @return genre of the literature.
     */
    public String getGenre()
    {
        return this.genre;
    }
    
    
    /**
     * Returns the price of the literature in NOK.
     * 
     * @return price of the literature in NOK. 
     */
    public double getPrice()
    {
        return this.price;
    }
    
    
    /**
     * Sets the price of the literature in NOK.
     * 
     * @param price of the literature in NOK.
     */
    public void setPrice(double price)
    {
        this.price = price;
    }
}
