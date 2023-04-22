
public abstract class Beverage {
	//Instances
	private String nameOfBeverage;
	private TYPE typeOfBeverage;
	private SIZE sizeOfBeverage;
	private final double BASE_PRICE = 2.0;
	private final double UP_SIZEPRICE = 1.0;
	
	
	//Constructor
	public Beverage(String name, TYPE type, SIZE size) {
		this.nameOfBeverage = name;
		this.typeOfBeverage = type;
		this.sizeOfBeverage = size;
	}
	
	//Methods
	public abstract double calcPrice();
	
	public boolean equals(Beverage beverage) {
		if(nameOfBeverage.equals(beverage.getBevName()) && 
				typeOfBeverage==beverage.getType() && 
				sizeOfBeverage==beverage.getSize()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
	/**
	 * @return the nameOfBeverage
	 */
	public String getBevName() {
		return nameOfBeverage;
	}

	/**
	 * @param nameOfBeverage the nameOfBeverage to set
	 */
	public void setNameOfBeverage(String nameOfBeverage) {
		this.nameOfBeverage = nameOfBeverage;
	}

	/**
	 * @return the typeOfBeverage
	 */
	public TYPE getType() {
		return typeOfBeverage;
	}

	/**
	 * @param typeOfBeverage the typeOfBeverage to set
	 */
	public void setTypeOfBeverage(TYPE typeOfBeverage) {
		this.typeOfBeverage = typeOfBeverage;
	}

	/**
	 * @return the sizeOfBeverage
	 */
	public SIZE getSize() {
		return sizeOfBeverage;
	}

	/**
	 * @param sizeOfBeverage the sizeOfBeverage to set
	 */
	public void setSizeOfBeverage(SIZE sizeOfBeverage) {
		this.sizeOfBeverage = sizeOfBeverage;
	}

	/**
	 * @return the bASE_PRICE
	 */
	public double getBasePrice() {
		return BASE_PRICE;
	}

	/**
	 * @return the uP_SIZEPRICE
	 */
	public double getUP_SIZEPRICE() {
		return UP_SIZEPRICE;
	}

	public String toString() {
		String str = "";
		str += "Beverage Name: " + nameOfBeverage + " Size: " + sizeOfBeverage;
		return str;
	}	
}
