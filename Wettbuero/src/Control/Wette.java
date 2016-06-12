package Control;

/**
 * 
 * @author Tobias
 * @version 1.0
 */
class Wette {
	protected Account account;
	protected double einsatz;
	protected int id = -1;
	protected int tipp;
	private int erloese;

	public Wette(Account acc, double einsatz) {
		id++;
		account = acc;
		this.einsatz = einsatz;
	}

	public Wette() {

	}

	public int getID() {
		return id;
	}

	public int getTipp() {
		return tipp;
	}

	public Account getAccount() {
		return null;
	}

	public int getErloese() {
		return erloese;
	}

	public void setErloese(int erloese) {
		this.erloese = erloese;
	}
}
