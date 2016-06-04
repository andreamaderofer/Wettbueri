package Control;

/**
 * 
 * @author Tobias
 * @version 1.0
 */
class Wette {
	protected Account account;
	protected Wette einsatz;
	protected int id = -1;
	private int tipp;

	public Wette(Account acc, Wette eins) {
		id++;
		account = acc;
		einsatz = eins;
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
}
