package ss.week3.hotel;

public class PricedRoom extends Room implements Bill.Item {
	public PricedRoom(int no, String password) {
		super(no,new Safe(password));
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
}
