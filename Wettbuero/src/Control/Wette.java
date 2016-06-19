package Control;

import java.sql.SQLException;

/**
 * 
 * @author Tobias
 * @version 1.0
 */
public class Wette {
	protected Account account;
	protected double einsatz;
	protected int tipp=0;
	private int erloese=0;
	private int id=0;
	private String beschreibung = null;
	
	public Wette(int wettID, Account acc, double einsatz, String tipp) {
		id=wettID;
		account = acc;
		this.einsatz = einsatz;
		this.beschreibung = tipp;
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
