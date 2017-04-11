package Task;

import java.util.TimerTask;
import java.util.Timer;
import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AlphabetLearner {
	
	private static int numLettersCorrect = 0;
	private static int numTries = 0;
	private static Timer alphaTimer = new Timer();
	private static int initialDelaySeconds = 10;
	private static int numSecondsPerLetter = 7;
	private static String yourNatoCharacter;
	
	class lettersTask extends TimerTask {
		public void run(){
			//Passes a new Scanner to the learnTheAlphabet method
			//Solutions I found for the problem of scanner waiting forever all used InputStreamReader
			//The scanner class is more in line with what  learned in the fall and has equivalent methods
			Scanner keyboard = new Scanner(System.in);
			alphabetInfo NATOChar = new alphabetInfo();
			learnTheAlphabet(keyboard, NATOChar);
			
		}
	}
	
	//When an AlphabetLearner object is constructed, it starts a timer with these parameters that executes lettersTask
	public AlphabetLearner(){
		long delay = initialDelaySeconds * 1000;
		long period = 4000;
		
		alphaTimer.schedule(new lettersTask(), delay, period);
	}
	
	//The "main" method, where everything happens
	public void learnTheAlphabet(Scanner input, alphabetInfo correctNATOCharacter){		//Takes a Scanner as explained in lettersTask
	
		//Generates a random character, a to z and creates an alphabetInfo object containing the NATO letter for it
		Random randLetter = new Random();
		//This generates a random number from 1-26 and sets 'a' as the "zero"
		char correctCharacter = (char) (randLetter.nextInt(26) + 'a');
		correctNATOCharacter.setNATOLetter(correctCharacter);
			
		//Sets the string to empty and then asks for and gets input
		System.out.println("Enter the NATO letter for " + correctCharacter);
		yourNatoCharacter = "";
		numSecondsPerLetter = 7; // waits 7 seconds at most
			
		//If there's no input for numSecondsPerLetter seconds, then it goes to the else and increments number of tries
		long startTime = System.currentTimeMillis();
		while ((System.currentTimeMillis() - startTime) < numSecondsPerLetter * 1000
		        && !input.hasNext())
		{
			//the empty while statement here prevents anything from being done while the timer is still going
			//or while there is input
		}
		
		//If input exists, it takes it in
		if (input.hasNext()) {
		    yourNatoCharacter = input.nextLine();
		}
		
		//If time has run out and there is no input, the program increments the number of tries by one
		else{
			numTries += 1;
		}
			
		//If it's correct, it tells you and increments the counters for the number of correct letters and tries
		if(yourNatoCharacter.equalsIgnoreCase(correctNATOCharacter.getNATOLetter())){
			System.out.println("Correct!");
			numLettersCorrect += 1;
			numTries += 1;
		}
			
		//If it's incorrect, it tells you it is, increments tries, and the timer restarts
		else if(!yourNatoCharacter.equalsIgnoreCase("quit")){
			System.out.println("Incorrect!");
			numTries += 1;
		}
			
		//Everything except "quit" has been accounted for so this closes the program when "quit" is entered
		else{
			alphaTimer.cancel();		//timer stops
			System.out.println("You got " + numLettersCorrect + " letters correct out of " + numTries + " tries.");
			System.out.println("Thank you for learning the NATO alphabet!");
		}
	}
	
	//Main simply gives instructions and creates an AlphabetLearner object, starting the timer
	public static void main(String[] args){
		System.out.println("In " + initialDelaySeconds + " seconds, you will begin to learn the NATO alphabet.  Enter the"
				+ " word for the provided character or quit to stop.  You will have " + numSecondsPerLetter + " seconds "
						+ "for each letter.");
		new AlphabetLearner();
		
	}
}
