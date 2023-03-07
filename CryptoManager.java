/*
 * Class: CMSC203 CRN 30375
 * Program: Assignment 3
 * Instructor: Ahmed Tarek
 * Description: Purpose of CryptoManager class is to encrypt and decrypt anthing the user 
 * 				inputs into Caesar Cipher and Bellaso.
 * 
 * 				The purpose of CryptoManagerGFATest is to guarantee and assure everything
 * 				works fine from the class CryptoManager using JUnit.
 * 
 * 				The Purpose of FXMAINPANE and FXDriver is to display everything for the output
 * 				design of the GUI and make sure it works using JavaFX.
 * 
 * 				The purpose of CryptoManagerTestPublic is to assure that the GUI works for
 * 				CryptoManager by testing examples.
 * Due Date: 03/06/2023
 * Platform/compiler: Eclipse
 * Integrity Pledge: I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * Print your Name here: Ifedapo Abiola
 */
 
public class CryptoManager extends FXMainPane{
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;
	
	

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		//throw new RuntimeException("method not implemented");
		char letter;
		for (int i = 0; i < plainText.length(); i++) {
			letter = plainText.charAt(i);
			if ((letter < LOWER_BOUND) || (letter > UPPER_BOUND)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		//throw new RuntimeException("method not implemented");
		int ceaserKey = 0,
			tempLetter,
			encryptLetter;
		String ceaserEncryptText = "";
		char letter,
			ceaserEncryptLetter;
		
		for(int i = 0; i < plainText.length(); i++) {
			letter = plainText.charAt(i);
			tempLetter = (int)letter;
			encryptLetter = tempLetter + ceaserKey;
			while(encryptLetter > UPPER_BOUND) {
				encryptLetter -= RANGE;
			}
			ceaserEncryptLetter = (char)encryptLetter;
			ceaserEncryptText += ceaserEncryptLetter;
		}
		return ceaserEncryptText;
	}
		
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		char sentry,
			encryptChar;
		String sample = "",
			sample2 = "",
			bellasoEncryptText = "";
		int value1,
			value2,
			cipherTxt,
			cipherPT,
			cipher,
			result = 0;
		if (plainText.length() > bellasoStr.length()) {
			value1 = plainText.length() / bellasoStr.length();
			value2 = plainText.length() % bellasoStr.length();
			
			for (int i = 0; i < value1; i++) {
				for (int j = 0; j < bellasoStr.length(); j++) {
					sentry = bellasoStr.charAt(j);
					sample2 += sentry;
				}
			}
			for (int i = 0; i < value2; i++) {
				sentry = bellasoStr.charAt(i);
				sample += sentry;
			}
			sample2 += sample;
		}
		for (int i = 0; i < sample2.length(); i++) {
			cipherTxt = (int)sample2.charAt(i);
			cipherPT = (int)plainText.charAt(i);
			cipher = cipherTxt + cipherPT;
			
			if((cipher < LOWER_BOUND) && (cipher > UPPER_BOUND)) {
				result = cipherTxt + cipherPT;
			}
			
			while(cipher > UPPER_BOUND) {
				cipher -= RANGE;
			}
			encryptChar = (char)result;
			bellasoEncryptText += encryptChar;
		}
		return bellasoEncryptText;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		//throw new RuntimeException("method not implemented");
		char letter,
			ceaserDecryptLetter;
		int tempLetter,
			decryptLetter,
			ceaserKey = 0;
		String ceaserDecryptText = "";
		for (int i = 0; i < encryptedText.length(); i++) {
			letter = encryptedText.charAt(i);
			tempLetter = (int)letter;
			decryptLetter = tempLetter - ceaserKey;
			while(decryptLetter < LOWER_BOUND) {
				decryptLetter += RANGE;
			}
			ceaserDecryptLetter = (char)decryptLetter;
			ceaserDecryptText += ceaserDecryptLetter;
		}
		return ceaserDecryptText;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		char sentry,
		decryptChar;
	String sample = "",
		sample2 = "",
		bellasoDecryptText = "";
	int value1,
		value2,
		cipherTxt,
		cipherPT,
		cipher,
		result = 0;
	if (encryptedText.length() > bellasoStr.length()) {
		value1 = encryptedText.length() / bellasoStr.length();
		value2 = encryptedText.length() % bellasoStr.length();
		
		for (int i = 0; i < value1; i++) {
			for (int j = 0; j < bellasoStr.length(); j++) {
				sentry = bellasoStr.charAt(j);
				sample2 += sentry;
			}
		}
		for (int i = 0; i < value2; i++) {
			sentry = bellasoStr.charAt(i);
			sample += sentry;
		}
		sample2 += sample;
	}
	for (int i = 0; i < sample2.length(); i++) {
		cipherTxt = (int)sample2.charAt(i);
		cipherPT = (int)encryptedText.charAt(i);
		cipher = cipherTxt - cipherPT;
		
		if((cipher < LOWER_BOUND) && (cipher > UPPER_BOUND)) {
			result = cipherTxt + cipherPT;
		}
		
		while(cipher < LOWER_BOUND) {
			cipher -= RANGE;
		}
		decryptChar = (char)result;
		bellasoDecryptText += decryptChar;
	}
	return bellasoDecryptText;
	}
}