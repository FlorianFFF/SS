package ss.week3.hotel;

/**
 * * Represents a guest in an hotel management app * * @author Michiel Bakker * @version
 * 1.0
 */
public class Guest {
	/** * The name of the guest */
	private final String name;
	/** * The room the guest is currently in, can be null */
	private Room room;

	/**
	 * * Creates a new guest with the specified name and no room * * @param n *
	 * - The guests name
	 */
	public Guest(String n) {
		name = n;
	}

	/**
	 * * Sets the guests current room, providing the guest has no current room *
	 * * @param room * - The new room * @return True if the checkin succeeded,
	 * false if not
	 */
	public boolean checkIn(Room room) {
		if (room != null && this.room == null && room.getGuest() == null) {
			this.room = room;
			room.setGuest(this);
			return true;
		} else
			return false;
	}

	/**
	 * * Checks the guest out, by setting the room to null, providing the room
	 * currently isn't null * * @return True if the checkout succeeded, false if
	 * not
	 */
	public boolean checkOut() {
		if (room == null)
			return false;
		room.setGuest(null);
		room = null;
		return true;
	}

	/** * @return The name of the guest */
	public String getName() {
		return name;
	}

	/** * @return The room the guest is in */
	public Room getRoom() {
		return room;
	}

	@Override
	public String toString() {
		return "Guest " + name;
	}
}