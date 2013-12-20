package ss.week3.hotel;


public class Safe {
	/**
	**@invariant Password
	*/
	private Password password;
	private boolean actief;
	private boolean open;
	
	/**
	**Constructor voor de kluis.
	**@ensure Password = Password.BEGINWOORD
	**@ensure open = alse en actief = false
	*/
	
	public Safe() {
		password = new Password();
		open = false;
		actief = false;
	}
	
	public Safe(String ww) {
		password = new Password();
		open = false;
		actief = false;
		password.setWord(Password.INITIAL, ww);
	}
	
	/**
	**Methode om de kluis te activeren.
	**@require Password om de kluis te activeren.
	**@ensure Password.testWoord(tekst)
	**@param tekst waarin het Password wordt meegegeven.
	*/
	
	public void activate(String tekst) {
		assert tekst != null;
		if (password.testWord(tekst)) {
			actief = true;
		} else {
			//blijft false
		}
	}
	
	/**
	**Methode om de kluis te deactiveren
	**@ensure actief = false
	**@ensure open = false
	*/
	
	public void deactivate() {
		actief = false;
		open = false;
	}
	
	/**
	**Deze methode opent de kluis
	**@require tekst is not null
	**@ensure Password.testWoord(tekst)
	**@param tekst wat het Password is dat getest wordt.
	*/
	
	public void open(String tekst) {
		assert tekst != null;
		if (password.testWord(tekst)) {
			open = true;
		} else {
			//blijft false
		}
	}
	
	/**
	**Methode voor het sluiten van de kluis.
	**@ensure open = false
	*/
	
	public void close() {
		open = false;
	}

	/**
	**Methode om de activiteit status van de kluis op te roepen.
	**@return actief
	*/
	
	public boolean isActive() {
		return actief;
	}
	
	/**
	**Methode om de open status van de kluis op te roepen.
	**@return open
	*/
	
	public boolean isOpen() {
		return open;
	}
	
	/**
	**Methode om het Password van de kluis op te roepen.
	**@return Password
	*/
	
	public Password getPassword() {
		return password;
	}
}
