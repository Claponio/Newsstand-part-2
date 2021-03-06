
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * Class for scanning user input with methods tailored for the appInterface class
 *
 * @author Vegard Fjørtoft
 */
public class InputScanner
{

    public void scanner()
    {

    }


    /**
     * Returns the next number input by the user between 1 and the set limit
     * 
     * @param limitHigh highest number method can return (inclusive).
     * @return the next number input by the user between 1 and the set limit
     * @throws InputMismatchException 
     */
    public int menuSelection(int limitHigh) throws InputMismatchException
    {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if ((number < 1) || (number > limitHigh)) {
            throw new InputMismatchException();
        }
        return number;

    }
    /**
     * returns first word entered by the user
     * @return first word entered by the user
     */
    public String getFirstWord()
    {
        Scanner scanner = new Scanner(System.in);
        String firstWord = scanner.next();
        return firstWord; 
    }
    
    /**
     * returns entire input line
     * @return returns entire input line
     */
    public String getInput()
    {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        return inputLine; 

    }
    
    /**
     * Takes user input of yes or no and returns true or false accordingly
     * @return true if user input is "yes" and false if "no"
     * @throws InvalidInputStringException 
     */
    public boolean getYesNoInput() throws InvalidInputStringException
    {
        Scanner scanner = new Scanner(System.in);
        String firstWord = scanner.next();
        if(firstWord.equals("yes"))
        {
            return true;
        }
        else if(firstWord.equals("no"))
        {
            return false;
        }
        else
        {
            throw new InvalidInputStringException();
        }
    }
    
    /**
     * Returns the next decimal number inputted by the user
     * @return Returns the next decimal number inputted by the user
     */
    public double getNextDouble()
    {
        Scanner scanner = new Scanner(System.in);
        double number = scanner.nextDouble();
        return number;
    }
    
    /**
     * Returns the next whole number inputted by the user
     * @return Returns the next whole number inputted by the user
     */
    public int getNextInt()
    {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return number;
    }
    
}
