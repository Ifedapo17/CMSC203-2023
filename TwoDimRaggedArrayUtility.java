/* Class: CMSC203 CRN 30375|Program: Assignment 5
 * Instructor: Ahmed Tarek
 * Summary of Description: This application will assign bonuses to stores in District
 * 		5 based on how much each retail store sold in each category.
 * 		The retail store with the highest amount sold in the category will receive $5,000.
 * 		The retail store with the lowest amount sold in a category will receive $1,000.
 * 		All other retail stores in District #5 will receive $2,000.
 * 		If a retail store did not sell anything in a category, or they have a negative
 * 		sales amount, they are not eligible for a bonus in that category.
 * 		If only one retail store sold items in a category, they are eligible to receive
 * 		only the bonus of $5000 for that category.
 * Due Date: 04/10/2023
 * Integrity Pledge: I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 */

/**
 * This utility class works with 2 dimensional ragged arrays with a maximum of 10 Rows and 10 Columns.
 * This utility class works with negative and positive numbers.
 * This is a utility class - there are no private data members.
 * 
 * @author Ifedapo Abiola
 */

import java.io.*;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
	TwoDimRaggedArrayUtility(){
		
	}
	
	//Methods
	/**
	 * Returns the total of all the elements of the two dimensional array
	 * 
	 * @param data The two dimensional array
	 * @return The sum of all the elements in the two dimensional array
	 */
	public static double getTotal(double[][] data) {
		double total = 0;
		for (int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				total += data[row][col];
			}
		}
		return total;
	}
	
	/**
	 * Returns the average of the elements in the two dimensional array
	 * 
	 * @param data The two dimensional array
	 * @return The average of all the elements in the two dimensional array (total
	 *         of elements / Number of elements)
	 */
	public static double getAverage(double[][] data) {
		double average;
		double num_Count = 0;
		double total = 0;
		for (int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				total += data[row][col];
				num_Count++;
			}
		}
		average = total / num_Count;
		return average;
	}
	
	/**
	 * Returns the total of the selected column in the two dimensional array(Index 0
	 * refers to the first column). If a row in the two dimensional array doesn't
	 * have this column index, it is not an error, it doesn't participate in this
	 * method.
	 * 
	 * @param data The two dimensional array
	 * @param col  The column index to take the total of (0 refers to the first
	 *             column)
	 * @return The total of the selected column
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double columnTotal = 0;
		
		for (int row = 0; row < data.length; row++) {
			if(data[row].length <= col) {
				continue;
			}
			columnTotal += data[row][col];
		}
		
		return columnTotal;
	}
	
	/**
	 * Returns the total of the selected row in the two dimensional array (Index 0
	 * refers to the first row).
	 * 
	 * @param data The two dimensional array
	 * @param row  The row index to take the total of (0 Refers to the first row)
	 * @return The total of the selected row
	 */
	public static double getRowTotal(double[][] data, int row) {
		double rowTotal = 0;
		
		for (int col = 0; col < data[row].length; col++) {
			rowTotal += data[row][col];
		}
		
		return rowTotal;
	}
	
	/**
	 * Returns the largest element in Array
	 * 
	 * @param data the two dimensional array
	 * @return The largest element in the two dimensional array
	 */
	public static double getHighestInArray(double[][] data) {
		double arrayHighest = data[0][0];
		for (int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				if(arrayHighest < data[row][col]) {
					arrayHighest = data[row][col];
				}
			}
		}
		return arrayHighest;
	}
	
	/**
	 * Returns the smallest element in the two dimensional array
	 * 
	 * @param data the two dimensional array
	 * @return The smallest element in the two dimensional array
	 */
	public static double getLowestInArray(double[][] data) {
		double arrayLowest = data[0][0];
		for (int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				if(arrayLowest > data[row][col]) {
					arrayLowest = data[row][col];
				}
			}
		}
		return arrayLowest;
	}
	
	/**
	 * Returns the largest element of the selected column in the two dimensional
	 * array index 0 refers to the first column. If a row in the two dimensional
	 * array doesn't have this column index, it is not an error, it doesn't
	 * participate in this method.
	 * 
	 * @param data The two dimensional array
	 * @param col  The column index to find the largest element of (0 refers to the
	 *             first column)
	 * @return The largest element of the column
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double columnHighest = 0;
		for(int row = 0; row < data.length; row++) {
			if(data[row].length <= col) {
				continue;
			}
			
			if (data[row][col] > columnHighest) {
				columnHighest = data[row][col];
			}
		}
		return columnHighest;
	}
	
	/**
	 * Returns index of the largest element of the selected column in the two
	 * dimensional array index 0 refers to the first column. If a row in the two
	 * dimensional array doesn't have this column index, it is not an error, it
	 * doesn't participate in this method.
	 * 
	 * @param data The two dimensional array
	 * @param col  The column index to find the largest element of (0 refers to the
	 *             first column)
	 * @return The index of the largest element of the column
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		int columnHighestIndex = 0;
		double columnHighest = 0;
		
		for(int row = 1; row < data.length; row++) {
			if(data[row].length <= col) {
				continue;
			}
			
			if (data[row][col] > columnHighest) {
				columnHighest = data[row][col];
				columnHighestIndex = row;
			}
		}
		
		return columnHighestIndex;
	}
	
	/**
	 * Returns the largest element of the selected row in the two dimensional array
	 * index(0 refers to the first row)
	 * 
	 * @param data The two dimensional array
	 * @param row  The row index to find the largest element of (0 refers to the
	 *             first row)
	 * @return The largest element of the row
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double rowHighest = data[row][0];
		
		for(int col = 1; col < data[row].length; col++) {
			if (data[row][col] > rowHighest) {
				rowHighest = data[row][col];
			}
		}
		return rowHighest;
	}
	
	/**
	 * Returns the index of largest element of the selected row in the two
	 * dimensional array index (0 refers to the first row).
	 * 
	 * @param data The two dimensional array
	 * @param row  The row index to find the largest element of(0 refers to the
	 *             first row)
	 * @return The index of largest element of the row
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		int rowHighestIndex = 0;
		double rowHighest = data[row][0];
		for(int col = 1; col < data[row].length; col++) {
			if (data[row][col] > rowHighest) {
				rowHighest = data[row][col];
				rowHighestIndex = col;
			}
		}
		return rowHighestIndex;
	}
	
	/**
	 * Returns the smallest element of the selected column in the two dimensional
	 * array index 0 refers to the first column. If a row in the two dimensional
	 * array doesn't have this column index, it is not an error, it doesn't
	 * participate in this method.
	 * 
	 * @param data The two dimensional array
	 * @param col  The column index to find the smallest element of(0 refers to the
	 *             first column)
	 * @return The smallest element of the column
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double columnLowest = getHighestInColumn(data, col);
		for(int row = 0; row < data.length; row++) {
			if(data[row].length <= col) {
				continue;
			}
			if (data[row][col] < columnLowest) {
				columnLowest = data[row][col];
			}
		}
		return columnLowest;
	}
	
	/**
	 * Returns the index of the smallest element of the selected column in the two
	 * dimensional array index 0 refers to the first column. If a row in the two
	 * dimensional array doesn't have this column index, it is not an error, it
	 * doesn't participate in this method.
	 * 
	 * @param data The two dimensional array
	 * @param col  The column index to find the smallest element of(0 refers to the
	 *             first column)
	 * @return The index of the smallest element in the column
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		int columnLowestIndex = 0;
		double columnLowest = getHighestInColumn(data, col);
		for(int row = 0; row < data.length; row++) {
			if(data[row].length <= col) {
				continue;
			}
			if (data[row][col] < columnLowest) {
				columnLowest = data[row][col];
				columnLowestIndex = row;
			}
		}
		return columnLowestIndex;
	}
	
	/**
	 * Returns the smallest element of the selected row in the two dimensional array
	 * index (0 refers to the first row)
	 * 
	 * @param data The two dimensional array
	 * @param row  The row index to find the smallest element of (0 refers to the
	 *             first row)
	 * @return The smallest element of the row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double rowLowest = data[row][0];
		for(int col = 1; col < data[row].length; col++) {
			if (data[row][col] < rowLowest) {
				rowLowest = data[row][col];
			}
		}
		return rowLowest;
	}
	
	/**
	 * Returns the index of the smallest element of the selected row in the two
	 * dimensional array index 0 refers to the first row.
	 * 
	 * @param data The two dimensional Array
	 * @param row  The row index to find the smallest element of(0 refers to the
	 *             first row)
	 * @return The index of the smallest element of the row
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		int rowLowestIndex = 0;
		double rowLowest = data[row][0];
		for(int col = 1; col < data[row].length; col++) {
			if (data[row][col] < rowLowest) {
				rowLowest = data[row][col];
				rowLowestIndex = col;
			}
		}
		return rowLowestIndex;
	}
	
	/**
	 * Reads from a file and returns a ragged array of doubles. The maximum rows is
	 * 10 and the maximum columns for each row is 10. Each row in the file is
	 * separated by a new line and each element in the row is separated by a space.
	 * 
	 * @param file The file to read from
	 * @return A two dimensional ragged(depending on data) array of doubles if the
	 *         file is not empty, returns a null if file is empty
	 * @throws FileNotFoundException
	 */
	public static double[][] readFile(File file) throws FileNotFoundException{
		String[][] fileInput = new String[10][10];
		Scanner scan = new Scanner(file);
		int row = 0,
				col = 0;
		
		while(scan.hasNextLine()) {
			String[] currentRowInput = scan.nextLine().split(" ");
			for(col = 0; col < currentRowInput.length; col++) {
				fileInput[row][col] = currentRowInput[col];
			}
			row++;
		}
		//scan.close();
		
		double[][] sales = new double[row][];
		
		for(row = 0; row < sales.length; row++) {
			for(col = 0; col < fileInput[row].length; col++) {
				if(fileInput[row][col] == null) {
					break;
				}
			}
			sales[row] = new double[col];
		}
		
		for(row = 0; row < sales.length; row++) {
			for(col = 0; col < sales[row].length; col++) {
				sales[row][col] = Double.parseDouble(fileInput[row][col]);
			}
		}
		
		return sales;
	}
	
	/**
	 * Writes the ragged array of doubles into the file. Each row is on a separate
	 * line within the file, and each double is separated by a space.
	 * 
	 * @param data       Two dimensional ragged array of doubles
	 * @param outputFile The file to write to
	 * @throws FileNotFoundException If output file is not valid
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		PrintWriter file = new PrintWriter(outputFile);
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				if(col != 0) {
					file.print(" " + data[row][col]);
				}
				else {
					file.print(data[row][col]);
				}
				//file.print((col != 0)? " " + data[row][col]: data[row][col]);
			}
			file.println();
		}
		file.close();
	}
	
	/*
	 * Juveniles who commit murder or attempted murder should be punished with life without
	 * parole (LoP) in the case of high school students and first degree murder because
	 * If left to be released at an early age will likely commit more crime and because
	 * they are still minor giving the death penalty will be an extreme punishment whereas
	 * LoP will allow them to regret and mature their mind. Giving LoP is an extreme
	 * punishment
	 */
}
