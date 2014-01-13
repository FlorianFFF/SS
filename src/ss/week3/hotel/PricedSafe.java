package ss.week3.hotel;

public class PricedSafe extends Safe implements Bill.Item{
	private final double price;
	
	//@ requires price >= 0.0;
	//@ ensures price == getPrice();
	public PricedSafe(double price){
		super();
		this.price = price;
	}
	
	//@ pure
	@Override
	public double getPrice(){
		return price;
	}
}
