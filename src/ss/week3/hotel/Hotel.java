package ss.week3.hotel;


public class Hotel {
	
	/**
	*@invariant k101 != null
	*@invariant k102 != null
	*@invariant gast != null
	*@invariant hotelpass != null
	*/
	private String naam;
	private Room k101;
	private Room k102;
	private Guest gast;
	private Password hotelpass;
	
	/**
	**Constructor voor Hotel
	**@require naam != null
	**@ensure this.getNaam().equals(naam)
	**@param naam van het hotel
	*/
	public Hotel(String naam) {
		this.naam = naam;
		k101 = new Room(101, new Safe());
		k102 = new Room(102, new Safe());
		hotelpass = new Password();
	}
	
	/**
	**Check een gast in.
	**@require wachtwoord != null, naam != null en wachtwoord.equals(hotelpass.testWoord())
	**@ensure if(getPassword.testWoord(wachtwoord)&&getRoom(naam)==null&&getFreeRoom!=null) then checkedinkamer.getGuest().getName().equals(naam)
	**@param wachtwoord van het hotel
	**@param naam van de in te schrijven gast
	*/
	public Room checkIn(String wachtwoord, String naam) {
		Room checkedinkamer = null;
		if (hotelpass.testWord(wachtwoord) && (getFreeRoom()!=null)) { //kan ook: (k101.getGuest==null || k102.getGuest==null)
			gast = new Guest(naam);
			
			if (k101.getGuest()==null&&getRoom(naam)==null) {
				k101.setGuest(gast);
				checkedinkamer = k101;
			} else if (k102.getGuest()==null&&getRoom(naam)==null) {
				k102.setGuest(gast);
				checkedinkamer = k102;
			}
			return checkedinkamer;
		}
		return checkedinkamer;
	}
	/**
	**Check een gast uit.
	**@require naam!=null
	**@ensure k101.getGuest!=null && k101.getgast().equals(naam) || k102.getGuest!=null && k102.getgast().equals(naam)
	**@param naam van de uit te checken gast.
	*/
	public void checkOut(String naam) {
		if ((k101.getGuest()!=null) && naam.equals(k101.getGuest().getName())) {
			k101.setGuest(null);
			k101.getSafe().deactivate();
		}
		if ((k102.getGuest()!=null) && naam.equals(k102.getGuest().getName())) {
			k102.setGuest(null);
			k102.getSafe().deactivate();
		}
	}
	/**
	**Geef de naam van een vrije kamer terug.
	**@ensure (k101.getGuest() || k102.getGuest()) == null
	**@return Room die vrij is of null.
	*/
	public Room getFreeRoom() {
		if (k101.getGuest() == null) {
			return k101;
		} else if (k102.getGuest() == null) {
			return k102;
		} else {
			return null;
		}
	}
	
	/**
	**Check in welke kamer de gast zit.
	**@require naam!=null
	**@ensure (k101.getGast()!=null || k102.getGast()!=null) && (naam.equals(k101.getGast()) || naam.equals(k102.getGast))
	**@param naam van de gast
	**@return Kamer object waarin de gast is ingechecked.
	*/
	public Room getRoom(String naam) {
		Room object;
		if ((k101.getGuest()!=null) && naam.equals(k101.getGuest().getName())) {
			object = k101;
		} else if ((k102.getGuest()!=null) && naam.equals(k102.getGuest().getName())) {
			object = k102;
		} else {
			object = null;
			//System.out.println(k101.getGast() + " of " + k102.getGast() + " kwamen niet overeen met "+naam);
		}
		return object;
	}
	
	public Password getPassword() {
		return hotelpass;
	}
	
	public String getName() {
		return naam;
	}
	
	@Override public String toString() {
		String finalstring;
		finalstring = "Hotel heeft 2 kamers: " + k101.getNumber() + " met daarin de gast " + k101.getGuest() + " \nen de kamer " + k102.getNumber() + " met daarin de gast " + k102.getGuest();
		
		return finalstring;
	}
}
