/**
 * A class that calculates the holiday bonus for each store and the total of all
 * holiday bonuses given
 * 
 * @author Ifedapo Abiola
 *
 */

public class HolidayBonus extends TwoDimRaggedArrayUtility{
	HolidayBonus() {
	}
	
	//Methods
	/**
	 * Calculates the holiday bonus for each store
	 * 
	 * @param data  The two dimensional array of store sales
	 * @param high  Bonus for the highest store in the category
	 * @param low   Bonus for the lowest store in a category
	 * @param other Bonus for all other stores in a category
	 * @return An array of the bonus for each store
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low,
			double other) {
		double[] array_of_SpecialBonuses = new double[data.length];
		
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				double h = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
				double l = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);
				
				if (data[row][col] >= 0) {
					if (data[row][col] == h) {
						array_of_SpecialBonuses[row] += high;
					}
					else if (data[row][col] == l) {
						array_of_SpecialBonuses[row] += low;
					}
					else {
						array_of_SpecialBonuses[row] += other;
					}
				}
			}
		}
		return array_of_SpecialBonuses;
	}
	
	/**
	 * Calculates the total holiday bonuses
	 * 
	 * @param data  The two dimensional array of store sales
	 * @param high  Bonus for the highest store in a category
	 * @param low   Bonus for the lowest store in a category
	 * @param other Bonus for all other stores in a category
	 * @return The total for all holiday bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low,
			double other) {
		double[] total_of_SpecialBonuses = calculateHolidayBonus(data, high, low, other);
		double totalBonus = 0;
		
		for(int row = 0; row < total_of_SpecialBonuses.length; row++) {
			totalBonus += total_of_SpecialBonuses[row];
		}
		
		return totalBonus;
	}
}
