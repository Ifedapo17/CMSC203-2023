/*
 * Class: CMSC 303 30375
 * Instructor: Ahmed Tarek
 * Description: This class is to build an application that will receive a guess and report if the
 * 				guess is the random number that was generated. This application will narrow down
 * 				the choices according to the previous guesses and continue to prompt the user to
 * 				enter a guess until the user guess correctly.
 * Due: 02/20/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * Print your Name here: Ifedapo Abiola
 * 
 * Pseudocode:
 * Start
 * Create a file RNG.java that generates a number between 1 - 100
 * Declare the variables: nextGuess (integer) and reply (string)
 * Initialize the variable programmer (string) with the value "Ifedapo Abiola"
 * Create a do-while loop for the following that runs once then test the if the user's input is
 * "yes" or "no". If it is "yes" it will loop, but if it is "no" it will terminate the loop:
 * 		Initialize the variables: randNum (integer) with the value RNG.rand (class), lowGuess = 0,
 * 			highGuess = 100, count = 0.
 * 		Display "Enter your first guess"
 * 		Read input
 * 		Create a do-while loop for the following that runs once then test if the user's guess is
 * 		NOT the random number AND if the amount of attempts is less than 7:
 * 			Increment count
 * 			Display "Number of guesses is " count
 * 			Create an if-else statement for the following:
 * 				If the next guess is greater than the random number then,
 * 					Display "Your guess is too high"
 * 					Assign to highGuess variable the value of nextGuess variable
 * 				Else,
 * 					Display "Your guess is too low"
 * 					Assign to lowGuess variable the value of nextGuess variable
 * 			Display "Enter your next guess between " lowGuess " and " highGuess
 * 			Read input
 * 			Create an if statement for the following:
 * 				If nextGuess is greater than highGuess or lower than lowGuess then,
 * 					Display "  >>> Guess must be between " lowGuess " and " highGuess ". Try again"
 * 			Create an if statement for the following:
 * 				If nextGuess equals to randNum then,
 * 					Display "Congratulations, you guessed correctly"
 * 			Create an if statement for the following:
 * 				If count is greater than 7 then,
 * 					Display "You have reached maximum amount of attempts"
 * 		Read next line to eliminates accepting the Enter key as input
 * 		Display "Try again? (yes or no)"
 * 		Read input
 * Display "Thanks for playing..."
 * 			programmer
 * End.
 */
import java.util.Scanner;

public class RandomNumberGuesser extends RNG{

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //Create a Scanner class object
		/*
		 * Create the randNum variable and assign it the random number between 1 - 100 based on the
		 * RNG class
		 */
		int nextGuess;
		String programmer = "Ifedapo Abiola"; //Create a variable to hold the programmer's name
		String reply;
		
		do {
			int randNum = RNG.rand();
			int lowGuess = 0,
				highGuess = 100;
			int count = 0;
			
			System.out.println("Enter your first guess"); //First guess
			nextGuess = scan.nextInt(); //Read the input into the variable nextGuess
			
			do {
				++count; //Increment the variables every time
				
				//Let the user the amount of guesses they have attempted
				System.out.println("Number of guesses is " + count);
				
				/*
				 * This if-else statements check if the guess is greater than or less than the 
				 * random number and based on the circumstances will set the limit of the range
				 * of numbers the user gets to guess from
				 * For example, if random number is 75 and the user guesses 50, the lower limit
				 * will be 50 and the higher limit will still be 99, then if the user guesses 100,
				 * the lower limit will be 0 and the higher limit will be 99
				 */
				if (nextGuess > randNum) {
					System.out.println("Your guess is too high");
					highGuess = nextGuess;
				}
				else {
					System.out.println("Your guess is too low");
					lowGuess = nextGuess;
				}
				
				/*
				 * Based on the previous if-else statement this will display a message that will
				 * prompt the user to guess again but with different ranges.
				 */
				System.out.println("Enter your next guess between " + lowGuess + " and " + 
									highGuess);
				nextGuess = scan.nextInt();
				
				/*
				 * This is an input-validation if statement that test the value of the input to the
				 * range specified and if it is below or higher than the range, the user will be
				 * prompted to guess the value again and it must be between the specified range.
				 */
				if (nextGuess < lowGuess || nextGuess > highGuess) {
					System.out.println("   >>> Guess must be between " + lowGuess + " and " 
										+ highGuess + ". Try again");
				}
				
				/*
				 * This is an input-validation if statement that test if the user's guess is the
				 * random number generated. If it is, there will be a congratulation statement
				 */
				if (nextGuess == randNum) {
					System.out.println("Congratulations, you guessed correctly");
				}
				
				/*
				 * This is an input-validation if statement that test if the amount of attempts is
				 * greater than or equals to 7 because the user's attempts is limited.
				 */
				if (count >= 7) {
					System.out.println("You have reached maximum amount of attempts");
				}
			}while(nextGuess != randNum && count < 7);
			
			scan.nextLine();
			System.out.println("Try again? (yes or no)");
			reply = scan.nextLine();
		}while(reply.equalsIgnoreCase("yes"));
		
		System.out.println("Thanks for playing...");
		System.out.println(programmer); //Print out the value of the variable programmer
		scan.close(); //Close the open scanner
		System.exit(0); //To terminate the background running thread
	}

}
