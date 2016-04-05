
/**
 * Create a Newspaper with the following information:
 * 
 * Title of the paper, publisher, genre and number of releases a year
 * 
 * Contains methods to return any of the above information.
 * 
 * @author Vegard Fjørtoft og Morten Solli
 * @version 1.0.1
 */
public class Newspaper
{
    // Newspaper variables
    private int numberOfIssue;
    private String title;
    private String publisher;
    private String genre;
    private double price;
    private double defaultPrice;

    /**
     * Constructor for objects of class Newspaper
     * 
     * @param title of paper. 
     * @param publisher of paper. 
     * @param issueNumber, how many releases a year. 
     * @param genre of the paper.
     */
    public Newspaper(String title, String publisher, int issueNumber, String genre)
    {
        this.title = title;
        this.publisher = publisher;
        this.genre = genre;
        this.numberOfIssue = issueNumber;
        this.defaultPrice = 19.99;
        this.price = defaultPrice;
    }

    /**
     * Returns the number of releases a year this paper has.
     * 
     * @return number of releases a year.
     */
    public int getIssueNumber()
    {
        return this.numberOfIssue;
    }

    /**
     * Returns the title of the paper.
     * 
     * @return title of the paper.
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * Returns the publisher of the paper.
     * 
     * @return publisher of the paper.
     */
    public String getPublisher()
    {
        return this.publisher;
    }

    /**
     * Returns the genre of the paper.
     *
     * @return genre of the paper.
     */
    public String getGenre()
    {
        return this.genre;
    }

    /**
     * Sets the price of the paper.
     *
     * @param price of the paper.
     */
    public void setPrice(double price)
    {
        this.price = price;
    }

    /**
     * Method that returns the price of the paper
     *
     * @return  double: price of the paper
     */
    public double getPrice()
    {
        return price;
    }
}
