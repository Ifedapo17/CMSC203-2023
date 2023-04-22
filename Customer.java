
public class Customer {
	//Instances
	private String nameOfCustomer;
	private int ageOfCustomer;
	
	//Constructors
	public Customer(String name, int age) {
		this.nameOfCustomer = name;
		this.ageOfCustomer = age;
	}
	
	public Customer(Customer copy){
		this.nameOfCustomer = copy.getName();
		this.ageOfCustomer = copy.getAge();
	}
	
	//Methods
	public String toString() {
		String str = "";
		str += nameOfCustomer + " " + ageOfCustomer;
		return str;
	}

	/**
	 * @return the nameOfCustomer
	 */
	public String getName() {
		return nameOfCustomer;
	}

	/**
	 * @param nameOfCustomer the nameOfCustomer to set
	 */
	public void setName(String nameOfCustomer) {
		this.nameOfCustomer = nameOfCustomer;
	}

	/**
	 * @return the ageOfCustomer
	 */
	public int getAge() {
		return ageOfCustomer;
	}

	/**
	 * @param ageOfCustomer the ageOfCustomer to set
	 */
	public void setAge(int ageOfCustomer) {
		this.ageOfCustomer = ageOfCustomer;
	}
}
