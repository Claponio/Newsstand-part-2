
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
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
    public String getFirstWord() throws EmptyStringException
    {
        Scanner scanner = new Scanner(System.in);
        String firstWord = scanner.next();
        if(firstWord.isEmpty())
        {
            throw new EmptyStringException();
        }
        else
        {
            return firstWord; 
        }
    }
    
    public String getInput() throws EmptyStringException
    {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        if(inputLine.isEmpty())
        {
            throw new EmptyStringException();
        }
        else
        {
            return inputLine; 
        }

    }
}
