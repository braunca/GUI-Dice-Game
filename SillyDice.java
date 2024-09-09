import java.io.*;
import java.util.Scanner;
/**
 * dice game that guesses the value that will be rolled using three dice
 * 
 * @author Casey Braun
 * @author Jonathan Hogenmiller
 * @version 3/1/2017
 */
public class SillyDice
{

    GVdie d1, d2, d3;
    private String  message;
    private int credit = 50;
    private int guess;

    /**************************************************************************************************************
     * default constructor 
     ***************************************************************************************************************/
    public SillyDice()
    {
        d1 = new GVdie();
        d2 = new GVdie();
        d3 = new GVdie();
        message = ("Welcome!");
    }

    /**************************************************************************************************************
     * return the current score
     * @return credit
     ***************************************************************************************************************/
    public int getCredits()
    {
        return credit;       
    }

    /**************************************************************************************************************
     * 
     * @return message
     ***************************************************************************************************************/
    public String getMessage()
    {
        return message;
    }

    /**************************************************************************************************************
     * roll the dice and compare the guess g with the rolled values by invoking: rollDice() and checkMatches()
     * 
     ***************************************************************************************************************/
    private void makeGuess(int g)
    {
        if(g <1 || g >6){
            message = "error: guess 1-6 ";
            return;
        }

        rollDice();
        guess = g;        
        checkMatches(); 

    }

    /**************************************************************************************************************
     * 
     * 
     ***************************************************************************************************************/
    private void rollDice()
    {
        d1.roll();
        d2.roll();
        d3.roll();
    }

    /**************************************************************************************************************
     * 
     * 
     ***************************************************************************************************************/
    private void checkMatches(){
        int matches = 0;
        if(d1.getValue() == guess){
            matches++;
        }
        if(d2.getValue() == guess){
            matches++;
        }
        if(d3.getValue() == guess){
            matches++;
        }

        if(matches == 0)
        {
            message = "No match";
            credit= credit - 10;
        }
        else if(matches == 1)
        {
            message = "One match";
            credit = credit + 10;
        }

        else if(matches == 2)
        {
            message = "Two matches";
            credit = credit + 20;
        }

        else if(matches == 3)
        {
            message = "Three matches";
            credit = credit + 50;
        }

        message = "You rolled" + " " +d1.getValue()+ " " + d2.getValue()+ " "+d3.getValue()+" "+ "(" + message + ")" +"\n"+"Current Score: "+credit +"\n" ;
    }
    public GVdie getDie(int num){
        if(num==1){
            return d1;
        }

        if(num==2){
            return d2;
        }

        else{
            return d3;
        }

    }

    public static void main(String args[]){
        SillyDice g = new SillyDice();
        int guess = 0;
        Scanner scnr = new Scanner(System.in);
        System.out.println(g.getMessage());
        do{
            System.out.print("Make a guess (1-6): ");
            guess = scnr.nextInt();
            if(guess > 0){
                g.makeGuess(guess);
                System.out.println(g.getMessage());
            }
        }while(guess != 0);
        System.out.println("Thanks for playing!");
    }       

}
