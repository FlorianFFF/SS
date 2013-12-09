package ss.week2.hotel;

public class Password {
	public static final String INITIAL = "";
	private String word;

	public Password() {
		this.word = INITIAL;
	}

	public boolean acceptable(String word) {
		return word.length() >= 6 && !word.contains(" ");
	}

	public boolean testWord(String word) {
		return word.equals(this.word);
	}

	public boolean setWord(String oldPass, String newPass) {
		if (testWord(oldPass) && acceptable(newPass)) {
			word = newPass;
			return true;
		}
		return false;
	}
	
	public String getPassword(){
		return word;
	}
}