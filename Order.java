import java.util.ArrayList;
import java.util.Random;

public  class Order implements OrderInterface, Comparable<Order>{
	//Instances
	private int order_Num;
	private int order_Time;
	private DAY order_Day;
	private Customer customer;
	ArrayList <Beverage> drinks;
	
	//Constructor
	public Order(int time, DAY day, Customer audience) {
		this.order_Num = getRandom();
		this.order_Time = time;
		this.order_Day = day;
		this.customer = audience;
		this.drinks = new ArrayList<>();
	}
	
	//Methods
	/**
	 * @return the order_Num
	 */
	public int getOrderNo() {
		return order_Num;
	}

	/**
	 * @param order_Num the order_Num to set
	 */
	public void setOrder_Num(int order_Num) {
		this.order_Num = order_Num;
	}

	/**
	 * @return the order_Time
	 */
	public int getOrderTime() {
		return order_Time;
	}

	/**
	 * @param order_Time the order_Time to set
	 */
	public void setOrder_Time(int order_Time) {
		this.order_Time = order_Time;
	}

	/**
	 * @return the order_Day
	 */
	public DAY getOrderDay() {
		return order_Day;
	}

	/**
	 * @param order_Day the order_Day to set
	 */
	public void setOrder_Day(DAY order_Day) {
		this.order_Day = order_Day;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the drinks
	 */
	public ArrayList<Beverage> getDrinks() {
		return drinks;
	}

	/**
	 * @param drinks the drinks to set
	 */
	public void setDrinks(ArrayList<Beverage> drinks) {
		this.drinks = drinks;
	}
	
	public int getRandom() {
		//int randNum = (int)Math.random()*(90000-10001) + 10000;
		Random r = new Random();
		int randNum = r.nextInt(90000) + 10000;
		return randNum;
	}

	@Override
	public String toString() {
		String str = "";
		str += "_______________________________________________" + this.getOrderDay() +
				", " + this.getOrderTime() + "\n" + this.getCustomer().toString() +
				" Order Number: " + this.getOrderNo();
		
		for(Beverage bev : drinks) {
			str += "\n" + bev.toString();
		}
		
		str += "\n Order Total: " + calcOrderTotal();
		
		return str;
	}
	
	public boolean isWeekend() {
		if(order_Day == DAY.SATURDAY || order_Day == DAY.SUNDAY) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Beverage getBeverage(int num_of_Item) {
		return drinks.get(num_of_Item);
	}
	
	public int compareTo(Order order) {
		if(order_Num == order.getOrderNo()) {
			return 0;
		}
		else if (order_Num > order.getOrderNo()) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	public double calcOrderTotal() {
		double total = 0;
		
		for(Beverage bev : drinks) {
			total += bev.calcPrice();
		}
		
		return total;
	}
	
	public int findNumOfBeveType(TYPE type) {
		int count = 0;
		
		for(Beverage bev : drinks) {
			if(bev.getType() == type) {
				count++;
			}
		}
		
		return count;
	}
	
	public int getTotalItems() {
		return drinks.size();
	}
	
	public void addNewBeverage(String name, SIZE size, boolean extrashot, boolean
			extrasyrup) {
		Coffee coffee = new Coffee(name, size, extrashot, extrasyrup);
		drinks.add(coffee);
	}
	
	public void addNewBeverage(String name, SIZE size, int number_of_Fruits, boolean
			proteinPowder) {
		Smoothie smoothie = new Smoothie(name, size, number_of_Fruits, proteinPowder);
		drinks.add(smoothie);
	}
	
	public void addNewBeverage(String name, SIZE size) {
		boolean weekend = false;
		
		if(order_Day == DAY.SATURDAY || order_Day == DAY.SUNDAY) {
			weekend = true;
		}
		
		Alcohol alcohol = new Alcohol(name, size, weekend);
		drinks.add(alcohol);
	}
	
	public ArrayList<Beverage> getBeverages_Item(){
		return drinks;
	}
}
