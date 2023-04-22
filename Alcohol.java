
public class Alcohol extends Beverage{
	//Instances
	private boolean isWeekend;
	private final double WEEKEND_PRICE = 0.60;
	
	//Constructor
	public Alcohol(String name, SIZE size, boolean weekend) {
		super(name, TYPE.ALCOHOL, size);
		this.isWeekend = weekend;
	}
	
	//Methods
	/**
	 * @return the isWeekend
	 */
	public boolean getWeekend() {
		return isWeekend;
	}

	/**
	 * @param isWeekend the isWeekend to set
	 */
	public void setWeekend(boolean isWeekend) {
		this.isWeekend = isWeekend;
	}

	/**
	 * @return the wEEKEND_PRICE
	 */
	public double getWEEKEND_PRICE() {
		return WEEKEND_PRICE;
	}

	@Override
	public String toString() {
		String str = "";
		str += "Beverage Name: " + getBevName() + ", Size: " + getSize();
		
		if(isWeekend) {
			str += " on the weekend";
		}
		
		str += ", $" + calcPrice();
		return str;
	}
	
	public boolean equals(Alcohol alcohol) {
		if(super.equals(alcohol) && isWeekend == alcohol.getWeekend()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public double calcPrice() {
		double alcoholPrice = super.getBasePrice();
		
		if (super.getSize() == SIZE.MEDIUM) {
			alcoholPrice += super.getUP_SIZEPRICE();
		}
		else if(super.getSize() == SIZE.LARGE) {
			alcoholPrice += 2 * super.getUP_SIZEPRICE();
		}
		
		if(isWeekend) {
			alcoholPrice += WEEKEND_PRICE;
		}
		
		return alcoholPrice;
	}
}
