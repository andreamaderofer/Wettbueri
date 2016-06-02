package Control;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Tobias
 * @version 1.0
 */
public class Account 
{
	protected int kontobetrag;
	protected int kontonummer;
	protected String benutzername;
	protected String vorname;
	protected String nachname;
	protected String email;
	protected String passwort;
	protected String benutzerSeit;

	public Account(int kontobet, String vorn, String nachn, int kontonum, String pw) 
	{
		kontobetrag = kontobet;
		vorname = vorn;
		nachname = nachn;
		kontonummer = kontonum;
		passwort = pw;
		benutzername = vorname + nachname;
		
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		benutzerSeit = formatter.format(date);
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

	public int getKontobetrag() {
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

	public void einzahlung (int betrag) 
	{
		kontobetrag = kontobetrag + betrag;
	}

	public void auszahlung (int betrag) 
	{
		kontobetrag = kontobetrag - betrag;
	}
}
