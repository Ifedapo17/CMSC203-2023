
public class Coffee extends Beverage{
	//Instances
	private boolean isExtraShot;
	private boolean isExtraSyrup;
	private final double EXTRA_SHOTPRICE = .50;
	private final double EXTRA_SYRUPPRICE = .50;
	
	//Constructor
	public Coffee(String name, SIZE size, boolean shot, boolean syrup) {
		super(name, TYPE.COFFEE, size);
		this.isExtraShot = shot;
		this.isExtraSyrup = syrup;
	}
	
	//Methods
	/**
	 * @return the isExtraShot
	 */
	public boolean getExtraShot() {
		return isExtraShot;
	}

	/**
	 * @param isExtraShot the isExtraShot to set
	 */
	public void setExtraShot(boolean isExtraShot) {
		this.isExtraShot = isExtraShot;
	}

	/**
	 * @return the isExtraSyrup
	 */
	public boolean getExtraSyrup() {
		return isExtraSyrup;
	}

	/**
	 * @param isExtraSyrup the isExtraSyrup to set
	 */
	public void setExtraSyrup(boolean isExtraSyrup) {
		this.isExtraSyrup = isExtraSyrup;
	}

	/**
	 * @return the eXTRA_SHOTPRICE
	 */
	public double getEXTRA_SHOTPRICE() {
		return EXTRA_SHOTPRICE;
	}

	/**
	 * @return the eXTRA_SYRUPPRICE
	 */
	public double getEXTRA_SYRUPPRICE() {
		return EXTRA_SYRUPPRICE;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += "Beverage Name: " + getBevName() + ", Size: " + getSize();
		
		if(isExtraShot) {
			str += " with extra shot";
		}
		
		if(isExtraSyrup) {
			str += " with extra syrup";
		}
		
		str += ", $" + calcPrice();
		return str;
	}
	
	@Override
	public double calcPrice() {
		double coffeePrice = super.getBasePrice();
		
		if (super.getSize() == SIZE.MEDIUM) {
			coffeePrice += super.getUP_SIZEPRICE();
		}
		else if(super.getSize() == SIZE.LARGE) {
			coffeePrice += 2 * super.getUP_SIZEPRICE();
		}
		
		if(isExtraShot) {
			coffeePrice += EXTRA_SHOTPRICE;
		}
		
		if(isExtraSyrup) {
			coffeePrice += EXTRA_SYRUPPRICE;
		}
		
		return coffeePrice;
	}
	
	public boolean equals(Coffee coffee) {
		if (super.equals(coffee) && isExtraShot == coffee.getExtraShot() && isExtraSyrup ==
				coffee.getExtraSyrup()) {
			return true;
		}
		else {
			return false;
		}
	}
}
