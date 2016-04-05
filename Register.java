import java.util.HashMap;


/**
 * This class shall register the newspapers created by the Newspaper class.
 * It can add new newspapers, remove them, display all the papers in store, search for all the papers
 * written by a specific publisher and search for a specific paper by its title and publisher.
 * 
 * 
 * 
 * @author Ole Martin Hanstveit and Oscar Kise.
 * @version 2015.12.02
 */

public class Register
{
 

    private final HashMap<String,Newspaper> newspaperCollection;

    /**
     * Creates a hashmap for collecting the newspapers.
     */
    public Register()
    {
        newspaperCollection = new HashMap<>();

    }

    
    
    /**
     * This method adds a newspaper to the collection, fill in details.
     *
     * 
     * @param String: name adds a titlename to the paper. String: publisher adds a publisher name to the paper.
     * int: issueNumber adds the number of issue of the paper. String: genre adds the type of genre.
     */

    public void addNewspaper(String name, String publisher, int issueNumber, String genre)
    {
        Newspaper newspaper = new Newspaper(name, publisher, issueNumber, genre);
        newspaperCollection.put(newspaper.getTitle(),newspaper);
    }
    

    /**
     * Removes a newspaper, type in the title of the paper you wish to remove.
     * 
     * @param String: newspaperToBeRemoved will find a matching key in the newsCollection hashMap
     * and remove the object.
     */
    public void removeNewspaper(String newspaperToBeRemoved)
    {
        newspaperCollection.remove(newspaperToBeRemoved);
    }
    
     /**
     * Method that sets the price of the paper
     *
     * @param String: tirle of the paper.  double: price of the paper.
     */
    public void setPrice(String title ,double price)
    {
         Newspaper paper = newspaperCollection.get(title);
         paper.setPrice(price);
         
    }

    /**
     * Returns a display of the entire collection of newspapers with their
     * information.
     * 
     * @return Returns a display of the entire collection of newspapers with
     * their information.
     * 
     * //TODO: Refactor, fjerne all string oppbyging og returnere en samling
     *  istedefor. gjelder alle return metoder! 
     */
    
    public String displayCollection()
    {
        String collection = "";
        if(newspaperCollection.isEmpty())
        {
            collection += "There is no newspaper in the collection!";
        }
        else
        {
            for(String key : newspaperCollection.keySet())
            {
                collection += "\nTitle: " + key + " , publisher: " +
                        newspaperCollection.get(key).getPublisher()
                    + " , issue: " + newspaperCollection.get(key).getIssueNumber()+
                        " , genre: " + newspaperCollection.get(key).getGenre() + " , price: "
                    + newspaperCollection.get(key).getPrice();
            }
        }
        return collection;
    }
    

    /**
     * Search for a specific newspaper by typing the title and publisher of the newspaper.
     * Remember to type in the exact correct title and publisher name.
     * Returns the result of the search as a string.
     * 
     * @param titleSearch checks the stored titles in the hashMap collection against the 
     * title we're searching for.
     * @param publisherSearch checks the stored publishers in the hashMap collection against the 
     * publisher we're searching for.
     * @return Returns the result of the search as a string.
     */
    
    public String searchForNewspaper(String titleSearch, String publisherSearch)
    {
        Newspaper newsPaper = newspaperCollection.get(titleSearch);
        String result = "";
        
        if(newspaperCollection.containsValue(newsPaper) && newsPaper.getPublisher().equals(publisherSearch))
        {
            result += "Newspaper found! Title: "+ titleSearch + ", publisher: " + newsPaper.getPublisher()
                + ", issue: " + newsPaper.getIssueNumber() + ", genre: " + newsPaper.getGenre() + ", price: "
                + newsPaper.getPrice() + " dollar.";
        }
        else
        {
            result += "Error, newspaper not found!";
        }
        return result;
    
    }
    
    

    
    /**
     * When searching for publisher, display all the work that is published by the publisher.
     * 
     * @param publisherSearch compares the typed publisher parameter to all the
     * publishers stored in newsCollection.
     */
    
    
    public String searchAllFromPublisher(String publisherSearch)
    {
        String result = "";
        for(String key : newspaperCollection.keySet())
        {
            String publisher = newspaperCollection.get(key).getPublisher();
            if(publisher.equals(publisherSearch))
            {
                result += "\n"+ newspaperCollection.get(key).getPublisher()
                        +" has written: "+ newspaperCollection.get(key).getTitle();
            }
            else
            {
                result += "No match, this publisher has not created anything!";
            }
        }
        return result;
    }
    
   
    //Tester å legge in kommentar. Morten sitter på telefonen sin.
            
}
