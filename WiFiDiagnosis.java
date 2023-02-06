/*
 * Class: CMSC 203 30375
 * Instructor: Ahmed Tarek
 * Description: I am creating a program that will step through some possible problems to restore
 * Internet connectivity with a user. I will be assuming that the user's computer uses WiFi to
 * connect to a router which connects to an Internet Service Provider (ISP) which connects to the
 * Internet.
 * Due: 02/06/2023
 * Platform/Compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * i have not copied the code from a student or any source.
 * Print your name here: Ifedapo Abiola
 * 
 * Pseudocode:
 * Start
 * Display message
 * 		“If you have a problem with Internet connectivity, this Wi-Fi Diagnosis might work.\n
 * 		First step: reboot your computer
 * 		Are you able to connect with the Internet? (yes or no)”
 * Initialize string variable reply
 * Read input into variable reply
 * Use if/else statements to determine the outcome of this part of the code.
 * If reply is yes
 * Display message “Rebooting your computer seemed to work”
 * Else
 * Display message
 * “Second step: reboot your router
 * Now are you able to connect with the Internet? (yes or no)”
 * Initialize string variable reply1
 * Read input into variable reply1
 * Use if/else statements to determine the outcome of this part of the code.
 * If reply1 is yes
 * Display message “Rebooting your router seemed to work”
 * Else
 * Display message
 * 		“Third step: make sure the cables connecting the router are firmly plugged in and power
 * 			is getting to the router
 * 		Now are you able to connect with the Internet? (yes or no)”
 * Initialize string variable reply2
 * Read input into variable reply2
 * Use if/else statements to determine the outcome of this part of the code.
 * If reply2 is yes
 * Display message “Checking the router’s cable seemed to work”
 * Else
 * Display message
 * 		“Fourth step: move the computer closer to the router
 * 		Now are you able to connect with the Internet? (yes or no)”
 * Initialize string variable reply3
 * Read input into variable reply3
 * Use if/else statements to determine the outcome of this part of the code.
 * If reply3 is yes
 * Display message “Moving your computer closer to the router seemed to work”
 * Else
 * Display message
 * 		“Fifth step: contact your Internet Service Provider (ISP)
 * 		Make sure your ISP is hooked up to your router.
 * 		You should be able to connect to the Internet.”
 * End
 */

import java.util.Scanner; //This is needed in order to use the scanner class for input

public class WiFiDiagnosis { //Java class name

	public static void main(String[] args) { //This is the main method
		System.out.print("If you have a problem with internet connectivity, this WiFi ");
		//Used print because I want the display text to be on the same line.
		System.out.println("Diagnosis might work.\n");
		/*
		 * Used the \n because after the test is displayed and moved to the next line, the \n
		 * creates moves to the next line without any display of text.
		 */
		
		Scanner scan = new Scanner(System.in);
		//Creates a scanner class object
		
		System.out.println("First step: reboot your computer");
		System.out.println("Are you able to connect with the internet? (yes or no)");
		String reply = scan.nextLine(); //Read the input
		if(reply.equalsIgnoreCase("yes")) {
			System.out.println("Rebooting your computer seemed to work");
		}
		else {
			System.out.println("Second step: reboot your router");
			System.out.println("Now are you able to connect with the internet? (yes or no)");
			String reply1 = scan.nextLine();
			if(reply1.equalsIgnoreCase("yes")) {
				System.out.println("Rebooting your router seemed to work");
			}
			else {
				System.out.print("Third step: make sure the cables connecting the router are ");
				//Used print because I want the display text to be on the same line.
				System.out.println("firmly plugged in and power is getting to the router");
				System.out.println("Now are you able to connect with the internet? (yes or no)");
				String reply2 = scan.nextLine();
				if(reply2.equalsIgnoreCase("yes")) {
					System.out.println("Checking the router's cable seemed to work");
				}
				else {
					System.out.println("Fourth step: move the computer closer to the router");
					System.out.print("Now are you able to connect with the internet? ");
					//Used print because I want the display text to be on the same line.
					System.out.println("(yes or no)");
					String reply3 = scan.nextLine();
					if(reply3.equalsIgnoreCase("yes")) {
						System.out.print("Moving your computer closer to the router seemed ");
						//Used print because I want the display text to be on the same line.
						System.out.println("to work");
					}
					else {
						System.out.print("Fifth step: contact your Internet Service Provider ");
						//Used print because I want the display text to be on the same line.
						System.out.println("(ISP)");
						System.out.println("Make sure your ISP is hooked up to your router.");
						System.out.println("You should be able to connect to the Internet.");
					}
				}
			}
		}
		scan.close(); //Close the open scanner
		System.exit(0); //To terminate the background running thread
	}
}
