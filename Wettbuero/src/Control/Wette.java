package Control;

import java.sql.SQLException;

/**
 * 
 * @author Tobias
 * @version 1.0
 */
class Wette {
	protected Account account;
	protected double einsatz;
	protected int id = 0;
	protected int tipp=0;
	private int erloese=0;
	private String beschreibung = null;
	
	public Wette(Account acc, double einsatz, String beschreibung) {
		id++;
		account = acc;
		this.einsatz = einsatz;
		this.beschreibung = beschreibung;
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
