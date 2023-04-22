
public class Smoothie extends Beverage{
	//Instances
	private int num_of_Fruits;
	private boolean isProteinPowder;
	private final double FRUITS_PRICE = .50;
	private final double PROTEIN_PRICE = 1.50;
	
	//Constructor
	public Smoothie(String name, SIZE size, int fruitsNumber, boolean proteinPowder) {
		super(name, TYPE.SMOOTHIE, size);
		this.num_of_Fruits = fruitsNumber;
		this.isProteinPowder = proteinPowder;
	}
	
	//Methods
	/**
	 * @return the num_of_Fruits
	 */
	public int getNumOfFruits() {
		return num_of_Fruits;
	}

	/**
	 * @param num_of_Fruits the num_of_Fruits to set
	 */
	public void setNum_of_Fruits(int num_of_Fruits) {
		this.num_of_Fruits = num_of_Fruits;
	}

	/**
	 * @return the isProteinPowder
	 */
	public boolean getAddProtien() {
		return isProteinPowder;
	}

	/**
	 * @param isProteinPowder the isProteinPowder to set
	 */
	public void setProteinPowder(boolean isProteinPowder) {
		this.isProteinPowder = isProteinPowder;
	}

	/**
	 * @return the fRUITS_PRICE
	 */
	public double getFRUITS_PRICE() {
		return FRUITS_PRICE;
	}

	/**
	 * @return the pROTEIN_PRICE
	 */
	public double getPROTEIN_PRICE() {
		return PROTEIN_PRICE;
	}
	
	public boolean equals(Smoothie smoothie) {
		if(super.equals(smoothie) && num_of_Fruits == smoothie.getNumOfFruits() &&
				isProteinPowder == smoothie.getAddProtien()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public double calcPrice() {
		double smoothiePrice = super.getBasePrice();
		
		if (super.getSize() == SIZE.MEDIUM) {
			smoothiePrice += super.getUP_SIZEPRICE();
		}
		else if(super.getSize() == SIZE.LARGE) {
			smoothiePrice += 2 * super.getUP_SIZEPRICE();
		}
		
		smoothiePrice += num_of_Fruits * FRUITS_PRICE;
		
		if(isProteinPowder) {
			smoothiePrice += PROTEIN_PRICE;
		}
		
		return smoothiePrice;
	}

	@Override
	public String toString() {
		String str = "";
		str += "Beverage Name: " + getBevName() + ", Size: " + getSize() + " with " +
		num_of_Fruits + " number of Fruits";
		
		if(isProteinPowder) {
			str += " with Protein Powder";
		}
		
		str += ", $" + calcPrice();
		return str;
	}
}
