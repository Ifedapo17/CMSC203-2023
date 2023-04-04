import java.util.Arrays;

public class ManagementCompany {
	//Data fields
	private final int  MAXIMUM_PROPERTY = 5;
	private double management_Fee_Percentage;
	private String managementName;
	private Property[] properties = new Property[MAXIMUM_PROPERTY];
	private String taxID;
	private final int  MANAGEMENT_WIDTH = 10;
	private final int  MANAGEMENT_DEPTH = 10;
	private Plot plo7 = new Plot();
	
	//Constructors
	public ManagementCompany() {
		this.managementName = "";
		this.taxID = "";
		this.plo7 = new Plot(0, 0, MANAGEMENT_WIDTH, MANAGEMENT_DEPTH);
		this.properties = new Property[MAXIMUM_PROPERTY];
	}
	
	/**
	 * 
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 * Constructor
	 * Default Constructor for ManagementCompany
	 */
	public ManagementCompany(String mgmtName, String tax_ID, double mgmtFee) {
		this.managementName = mgmtName;
		this.taxID = tax_ID;
		this.management_Fee_Percentage = mgmtFee;
	}
	
	/**
	 * 
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * Constructor 
	 * default constructor for ManagementCompany
	 */
	public ManagementCompany(String mgmtName, String tax_ID, double mgmtFee, int x, int y,
			int depth, int width) {
		this.managementName = mgmtName;
		this.taxID = tax_ID;
		this.management_Fee_Percentage = mgmtFee;
		this.properties = new Property[MAXIMUM_PROPERTY];
		this.plo7 = new Plot(0, 0, MANAGEMENT_WIDTH, MANAGEMENT_DEPTH);
	}
/**
 * 
 * @param otherCompany
 * @return copied the elements of other company. Deep Copy.
 */
	public ManagementCompany(ManagementCompany anotherCompany) {
		this.managementName = anotherCompany.managementName;
		this.taxID = anotherCompany.taxID;
		this.management_Fee_Percentage = anotherCompany.management_Fee_Percentage;
		this.properties = new Property[MAXIMUM_PROPERTY];
		this.plo7 = new Plot(anotherCompany.plo7);
	}
	

	//Methods
	/**
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @return the property expectations when its null, when it doesn't encompass, when it overlaps 
	 * and returns the subscript of the element that is not null given the parameters
	 */
	public int addProperty(Property prop){
		int value = 0;
		if (properties.length == 5) {
			value = -1;
		}
		else if (prop == null) {
			value = -2;
		}
		else if (!(prop.getPlot().encompasses(plo7))) {
			value = -3;
		}
		else if (!(prop.getPlot().overlaps(plo7))) {
			value = -4;
		}
		for (int i = 0; i < properties.length; i++) {
			if (properties[i] == null) {
				properties[i] = prop;
				value = i;
				break;
			}
		}
		return value;
	}
	
	
	public int addProperty(String property, String city_Name, double rent, String owner) {
		return addProperty(new Property(property, city_Name, rent, owner));
	}
	
	/**
	 * 
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return a new property with the following parameters. Uses addProperty method from above to return the number significant to the numbers added.
	 */
	public int addProperty(String property, String city_Name, double rent, String owner, int x, int y, int width, int depth) {
		return addProperty(new Property(property, city_Name, rent, owner));	
	}
	
	/**
	 * 
	 * @return the total rent from every property in the ManagementCompany
	 */
	public double totalRent() {
		double total = 0.0;
		for(int i = 0; i < properties.length; i++) {
			if (properties[i] == null) {
				break;
			}
			
			total += properties[i].get_Rent();
		}
		return total;
	}
	
	public double maxRentProp() {
		double maxRent = 0.0;
		for (int i = 0; i < properties.length; i++) {
			if (properties[i] == null) {
				break;
			}
			if(properties[i].get_Rent() > maxRent) {
				maxRent = properties[i].get_Rent();
			}
		}
		return maxRent;
	}
	
	public int maxRentPropertyIndex() {
		int index = -1;//if not found
		double maxRent = 0.0;
		for (int i = 0; i < properties.length; i++) {
			if(properties[i].get_Rent() > maxRent) {
				maxRent = properties[i].get_Rent();
				index = i;
			}
		}
		return index;
	}
	
	public String displayPropertyAtIndex(int i) {
		return properties[i].toString();
	}
	
	public int getMAX_PROPERTY() {
		return MAXIMUM_PROPERTY;
	}

	public void setPlot(int x, int y, int width, int depth) {
		this.plo7 = new Plot(x, y, width, depth);
	}
	
	/**
	 * 
	 * @return the plot from ManagementCompany
	 */
	public Plot getPlot(){
		return plo7;
	}
	
	/**
	 * 
	 * @return the the name from ManagementCompany
	 */
	public String getName() {
		return managementName;
	}

	/**
	 * @param ownerName the ownerName to set
	 */
	public void set_ownerName(String owner_Name) {
		this.managementName = owner_Name;
	}
	
	@Override
	/**
	 * 
	 * @return the String of every field in this class.
	 */
	public String toString() {
		String managementCompany_String = "";
		managementCompany_String += "List of the properties for " + managementName + ", taxID: " + taxID;
		managementCompany_String += "\n________________________________________________________________";
		for (Property p : properties) {
			managementCompany_String += "\nProperty Name: " + p.getPropertyName() + "\nLocated in " 
					+ p.get_City() + "\nBelonging to: " + p.getName() + "\nRent Amount: " + p.get_Rent();
		}
		managementCompany_String += "\n_________________________________________________________________";
		managementCompany_String += "\ntotal management Fee: " + totalRent();
		return managementCompany_String;
	}
}
