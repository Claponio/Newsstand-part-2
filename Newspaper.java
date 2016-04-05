
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
public class Newspaper extends Literature
{
    // Newspaper variables
    private int numberOfIssue;

    /**
     * Constructor for objects of class Newspaper
     * 
     * @param title of paper. 
     * @param publisher of paper. 
     * @param issueNumber, how many releases a year. 
     * @param genre of the paper.
     * @param price ot the paper
     */
    public Newspaper(String title, String publisher, int issueNumber, String genre,
                     double price)
    {
        
        super(title, publisher, price, genre);
        this.numberOfIssue = issueNumber;
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

}
