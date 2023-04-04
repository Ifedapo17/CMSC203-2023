/*
 * Class: CMSC203 30375
 * Instructor: Ahmed Tarek
 * Description: Designs a Property Management that collects the plot, property and 
 * 				combines it together in an organized fashion.
 * Due: 03/27/23
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Ifedapo Abiola
*/


public class Property {
	//Data fields
	private String city;
	private String ownerName;
	private String propertyName;
	private double rent;
	private Plot plo2;
	
	//Constructors
	public Property() {
		this.city = "";
		this.ownerName = "";
		this.propertyName = "";
		this.rent = 0.0;
		plo2 = new Plot(0, 0, 1, 1);
	}
	
	public Property(Property prop) {
		this.city = prop.city;
		this.ownerName = prop.ownerName;
		this.propertyName = prop.propertyName;
		this.rent = prop.rent;
	}
	
	public Property(String name_of_Property, String name_of_City, double rentAmount, String owner) {
		this.city = name_of_City;
		this.ownerName = owner;
		this.propertyName = name_of_Property;
		this.rent = rentAmount;
	}
	
	public Property(String name_of_Property, String name_of_City, double rentAmount, String owner,
			int x, int y, int depth, int width) {
		this.city = name_of_City;
		this.ownerName = owner;
		this.propertyName = name_of_Property;
		this.plo2 = new Plot(x, y, depth, width);
		this.rent = rentAmount;
	}
	
	//Methods
	/**
	 * @return the city
	 */
	public String get_City() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void set_City(String city_Name) {
		this.city = city_Name;
	}

	/**
	 * @return the ownerName
	 */
	public String getName() {
		return ownerName;
	}

	/**
	 * @param ownerName the ownerName to set
	 */
	public void set_ownerName(String owner_Name) {
		this.ownerName = owner_Name;
	}

	/**
	 * @return the propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * @param propertyName the propertyName to set
	 */
	public void set_propertyName(String property_Name) {
		this.propertyName = property_Name;
	}

	/**
	 * @return the rent
	 */
	public double get_Rent() {
		return rent;
	}

	/**
	 * @param rent the rent to set
	 */
	public void set_Rent(double rent_Amount) {
		this.rent = rent_Amount;
	}
	
	public void setPlot(int x, int y, int width, int depth) {
		this.plo2 = new Plot(x, y, width, depth);
	}
	
	public Plot getPlot(){
		return plo2;
	}
	
	public String toString() {
		String property_String = "";
		property_String += "Property Name: " + propertyName + "\nLocated in " + city + 
				"\nBelonging to: " + ownerName + "\nRent Amount: " + rent;
		return property_String;
	}
}
