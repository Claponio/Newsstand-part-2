import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;




/**
 * This class keeps a hold of all the literature.
 * Literature can be of many types such as newspaper and book, the specific
 * literature inherits from this class.
 * 
 * @author Ole Martin Hanstveit and Oscar Kise.
 * @version 2015.12.02
 */

public class Register
{
 

    private final ArrayList<Literature> collection;

    /**
     * Each register creates a collection that can hold all kinds of literature.
     */
    public Register()
    {
        collection = new ArrayList<>();
        
    }

    /**
     * Adds new literature to collection.
     * @param literature to add to the collection.
     */

    public void addLiterature(Literature literature)
    {
        collection.add(literature);
    }
    
    /**
     * Removes a literature from the collection.
     * @param literature to remove from the collection.
     */
    public void removeLiterature(Literature literature)
    {
        collection.remove(literature);
    }


    /**
     * Returns the collection.
     * @return an iterator of the collection.
     */
    public Iterator<Literature> getCollection() 
    {    
        return collection.iterator();
    }
    
    /**
     * Search the literature collection by a title name and the publisher name.
     * @param title name of the literature.
     * @param publisher name of the literature.
     * @return an iterator of the literatures found.
     */
    public Iterator<Literature> searchByTitleAndPublisher(String title, String publisher)
    {
        ArrayList<Literature> list = new ArrayList<>();
        for(Literature lit: collection)
        {
            if(lit.getTitle().equals(title) && lit.getPublisher().equals(publisher))
            {
                list.add(lit);
            }
        }
        
    return list.iterator();
    }
    

    /**
     * Search the collection of literatures by the publisher name.
     * Returns the literature(s).
     * @param publisher of the literature.
     * @return an iterator of the found literatures.
     */
    public Iterator<Literature> searchByPublisher(String publisher)
    {
        ArrayList<Literature> list = new ArrayList<>();
        for(Literature lit: collection)
        {
            if(lit.getPublisher().equals(publisher))
            {
                list.add(lit);
            }
        }
        
    return list.iterator();
    }
    
    /**
     * Search the collection of literatures by the publisher name.
     * Returns the literature(s).
     * @param title of the literature.
     * @return an iterator of the collection.
     */
    public Iterator<Literature> searchByTitle(String title)
    {
        ArrayList<Literature> list = new ArrayList<>();
        for(Literature lit: collection)
        {
            if(lit.getTitle().equals(title))
            {
                list.add(lit);
            }
        }
        
    return list.iterator();
    }
    
    public List<Literature> getRegister()
    {
        return this.collection;
    }
    
        
       
}
