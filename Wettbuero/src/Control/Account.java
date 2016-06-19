package Control;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Tobias
 * @version 1.0
 *
 */
public class Account {
	protected double kontobetrag;
	protected int kontonummer;
	protected String benutzername;
	protected String vorname;
	protected String nachname;
	protected String email;
	protected String passwort;
	protected String benutzerSeit;
	protected int benutzerID;

	public Account(int benutzerID, double kontobet,String email, String benutzernamen, String vorn, String nachn, int kontonum,
			String pw) {
		this.benutzerID=benutzerID;
		this.email=email;
		kontobetrag = kontobet;
		vorname = vorn;
		nachname = nachn;
		kontonummer = kontonum;
		passwort = pw;
		benutzername = benutzernamen;

		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dat = new Date();
		benutzerSeit = formatter.format(dat);
	}

	public Account() {
	}
	
	public int getBenutzerID(){
		return this.benutzerID;
	}
	
	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public double getKontobetrag() {
		return kontobetrag;
	}

	public int getKontonummer() {
		return kontonummer;
	}

	public String getBenutzername() {
		return benutzername;
	}

	public String getNachname() {
		return nachname;
	}

	public String getEmail() {
		return email;
	}

	public String getBenutzerSeit() {
		return benutzerSeit;
	}

	public void einzahlung(double d) {
		kontobetrag = kontobetrag + d;
	}

	public void auszahlung(double d) {
		kontobetrag = kontobetrag - d;
	}
}
