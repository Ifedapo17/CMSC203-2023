import java.util.Scanner;

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
 * Create a new object of type Scanner that reads from the keyboard
 * Create a new movie object
 * Prompt the user to enter the title of a movie
 * Read in the line that the user types
 * Set the title in the movie object
 * Prompt the user to enter the movie’s rating
 * Read in the line that the user types
 * Set the rating in the movie object
 * Prompt the user to enter the number of tickets sold at a (unnamed) theater
 * Read in the integer that the user types
 * Set the number of tickets sold in the movie object
 * Print out the information using the movie’s toString method
 */
public class MovieDriver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); //Create a Scanner class object
		String movieName,
			movieRating;
		int no_Of_Tickets;
		char reply;
		
		do {
			System.out.println("Enter the name of a movie");
			movieName = scan.nextLine();
			System.out.println("Enter the rating of the movie");
			movieRating = scan.nextLine();
			System.out.println("Enter the number of tickets sold for this movie");
			no_Of_Tickets = scan.nextInt();
			System.out.println(movieName + " (" + movieRating + "): Tickets Sold: " + no_Of_Tickets);
			scan.nextLine();
			System.out.println("Do you want to enter another? (y or n)");
			reply = scan.next().charAt(0);
		}while(reply == 'y');
		System.out.println("Goodbye");
		scan.close();
		System.exit(0);
	}

}
