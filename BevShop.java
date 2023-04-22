import java.util.ArrayList;

public class BevShop implements BevShopInterface{
	//Instances
	private int number_of_Alcohol_inOrder;
	private int currentOrder_Index;
	ArrayList<Order> orderList;
	
	//Constructor
	public BevShop() {
		orderList = new ArrayList<>();
	}
	
	//Methods
	public boolean validTime(int time) {
		if(time >= MIN_TIME && time <= MAX_TIME) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean eligibleForMore() {
		if (number_of_Alcohol_inOrder < 3) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public  boolean validAge(int age) {
		if(age > MIN_AGE_FOR_ALCOHOL) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		Customer customer = new Customer(customerName, customerAge);
		Order order = new Order(time, day, customer);
		orderList.add(order);
		currentOrder_Index = orderList.indexOf(order);
		number_of_Alcohol_inOrder = 0;
	}
	
	public void processCoffeeOrder( String bevName, SIZE size, boolean extraShot, boolean 
			extraSyrup) {
		orderList.get(currentOrder_Index).addNewBeverage(bevName, size, extraShot,
				extraSyrup);
	}
	
	public void  processAlcoholOrder( String bevName, SIZE size) {
		orderList.get(currentOrder_Index).addNewBeverage(bevName, size);
		number_of_Alcohol_inOrder++;
	}
	
	public void processSmoothieOrder( String bevName, SIZE size, int numOfFruits, boolean
			addProtien) {
		orderList.get(currentOrder_Index).addNewBeverage(bevName, size, numOfFruits,
				addProtien);
	}
	
	public int findOrder(int orderNo) {
		for(int i = 0; i < orderList.size(); i++) {
			if(orderList.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}
		return -1;
	}
	
	public double totalOrderPrice(int orderNo) {
		double sale = 0;
		
		for(Order order : orderList) {
			if(order.getOrderNo() == orderNo) {
				for(Beverage bev : order.getBeverages_Item()) {
					sale += bev.calcPrice();
				}
			}
		}
		return sale;
	}
	
	public double totalMonthlySale() {
		double total = 0;
		
		for(Order order : orderList) {
			for(Beverage bev : order.getBeverages_Item()) {
				total += bev.calcPrice();
			}
		}
		
		return total;
	}
	
	public  void sortOrders() {
		int minimum_OrderNum_Index;
		for(int i = 0; i < orderList.size() - 1; i++) {
			minimum_OrderNum_Index = i;
			for(int j = i + 1; j < orderList.size(); j++) {
				if(orderList.get(j).getOrderNo() < orderList.get(minimum_OrderNum_Index)
						.getOrderNo()) {
					minimum_OrderNum_Index = j;
				}
			}
			
			Order temp = orderList.get(minimum_OrderNum_Index);
			orderList.set(minimum_OrderNum_Index, orderList.get(i));
			orderList.set(i, temp);
		}
	}
	
	public Order getCurrentOrder() {
		return orderList.get(currentOrder_Index);
	}
	
	public Order getOrderAtIndex(int index) {
		return orderList.get(index);
	}

	public boolean isMaxFruit(int num) {
		if(num > MAX_FRUIT) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int totalNumOfMonthlyOrders() {
		return orderList.size();
	}
	
	public int getNumOfAlcoholDrink() {
		return number_of_Alcohol_inOrder;
	}
	
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += "Monthly Orders\n";
		
		for(Order order : orderList) {
			str += order.toString();
		}
		
		str += "Total Sale: " + totalMonthlySale();
		return str;
	}
}
