package ss.week3.hotel;

public class PricedRoom extends Room implements Bill.Item{
	private final double price;
	
	//@ requires price >= 0.0;
	//@ ensures price == getPrice();
	public PricedRoom(int no, String password, double price){
		super(no, new Safe(password));
		this.price = price;
	}
	
	//@pure
	@Override
	public double getPrice(){
		return price;
	}
}
