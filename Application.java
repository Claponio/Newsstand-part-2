

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
    Register newspaperRegister;
       
    /**
     * Creates the registers the application: Newsstand needs, ex. 
     * 
     */
    public Application()
    {
        
        newspaperRegister = new Register();
        
    }
    
  
    
    /**
     * returns the information about all the content in the chosen register, sorted
     * after Author/Publisher and title/name.
     * 
     * 
     * //@param  register, name of the register the user want to display content off.
     * @return content of the register the user want to display.
     * 
     * //TODO: in next build add parameter (Register register) Bc.
     * we will expand with more registers.
     */
    public String getContentOfRegister()
    {
        String content = "";
        content += newspaperRegister.displayCollection();
        
        return content;
    }
    
    /**
     * returns all the newspappers from the publiser which is searched for.
     * 
     * @return newspapers from one publisher
     */
    public String getSpecificPublisher(String publisher)
    {
        String publisherInfo = "";
        publisherInfo += newspaperRegister.searchAllFromPublisher(publisher);
        
        return publisherInfo;
    }
    
    /**
     * returns the newspaper with the given title and publisher if it excists.
     * 
     * @return returns the newspaper with the given title 
     */
    public String getSpecificNewspaper(String title, String publisher)
    {
        String newspaperInfo = "";
        newspaperInfo += newspaperRegister.searchForNewspaper(title, publisher);
        

        return newspaperInfo;  
    }
    

    /**
     * Changes the price of the paper the user enters the title to.
     * 
     * @param title of the paper which the user want to change the price of.
     * @param price you want to set.
     */
    public void setNewspaperPrice(String title,double price)
    {
        newspaperRegister.setPrice(title, price);
       
    }
    
    /**
     * Adds a newspaper to the newspaper register with use of the title, publisher,
     * issue number and genre.
     * 
     * @param title of the newspaper
     * @param publisher of the newspaper
     * @param issueNumber, the sequence number of the paper by the year
     * @param genre of the newspaper
     */
    public void addNewspaper(String title, String publisher, int issueNumber, String genre)
    {
        
       newspaperRegister.addNewspaper(title, publisher, issueNumber, genre);
        
    }
    
    
    //TODO: implement Remove function for newspaperRegister.
    
}
