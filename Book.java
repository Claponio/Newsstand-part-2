
/**
 * Creats an object of Book with the following information:
 * 
 * Title, Publisher, Price, Genre, Edition, Author.
 * 
 * 
 * @author Morten
 * @version 1.0.0   05.04.2016
 */
public class Book extends Literature
{
    //Fields for the book class
    private int edition;            // Edition of the book.
    private String author;          //Author of the book.
    private String seriesTitle;     //Title of the book series, if it's part of a series.
    private String seriesDate;      //Date of the publishing of the book in a series.
    private Boolean series;         //If true the book is part of a series.
    
    
    /**
     * Constructer for objects of the class Book
     * 
     * @param title of book
     * @param publisher of book
     * @param price of book
     * @param genre of book
     * @param edition of book
     * @param author of book
     */
    public Book(String title, String publisher, double price, String genre, 
                int edition, String author)
    {
        super(title, publisher, price, genre);
        this.edition = edition;
        this.author = author;
        this.series = false;
        
    }
    
    /**
     * Returns the name of the author
     * 
     * @return The name of author of the book
     */
    public String getAuthor()
    {
        return author;
    }
    
    
    /**
     * Returns the edition of the book
     * 
     * @return The edition of the book 
     */
    public int getEdition()
    {
        return edition;
    }
    
    
    /**
     * Returns the title of the book series if the book is part of a series, if not
     * it Throws the exception NotASeriesException.
     * 
     * @return The title to the book series
     * @throws NotASeriesException if the book is not part of a series 
     */
    public String getSeriesTitle() throws NotASeriesException
    {
        if(series == false)
        {
             throw new NotASeriesException();
        }
        
            return this.seriesTitle;        
    }
    
    
    /**
     * Adds the book to a book series, sets the series to true and adds a series title and the
     * date the book is published.
     * 
     * @param seriesTitle 
     * @param seriesBookDate
     */
    public void makeToSeries(String seriesTitle, String SeriesBookDate)
    {
        this.series = true;
        this.seriesTitle = seriesTitle;
        this.seriesDate = SeriesBookDate;
    }
    
    
}
