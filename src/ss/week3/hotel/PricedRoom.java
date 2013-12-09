package ss.week3.hotel;

public class PricedRoom extends Room implements Bill.Item {
	public PricedRoom(int no, Safe safe) {
		super(no,safe);
	}
}
