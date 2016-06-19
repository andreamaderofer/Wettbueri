package Control;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Kurt
 * @version 1.0
 */

public class WettDBManager {
	protected Connection conn;

	public WettDBManager() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost/wettbuero", "root", "");
	}

	public ArrayList<Account> getAccounts() throws Exception {
		int accZahl = 0;
		Account account = null;
		ArrayList<Account> accounts = new ArrayList<Account>();
		String sql = "SELECT * FROM account";
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);
		while (rs.next()) {
			int kontostand = rs.getInt("kontostand");
			int accountID = rs.getInt("accountID");
			String email=rs.getString("email");
			String vorname = rs.getString("vorname");
			String nachname = rs.getString("nachname");
			String benutzer = rs.getString("benutzername");
			String passwort = rs.getString("passwort");
			account = new Account(accZahl, kontostand, email, benutzer, nachname, vorname, accountID, passwort);
			accounts.add(account);
			accZahl++;
		}
		rs.close();
		stmt.execute(sql);
		return accounts;
	}

	public Wette getWette(Wette wette) throws Exception {
		String sql = "SELECT * FROM wette";
		Account acc;
		Statement stmt = (Statement) conn.createStatement();
		ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql);
		while (rs.next()) {
			int kontostand = rs.getInt("kontostand");
			int wettID = rs.getInt("WettID");
			int accountID = rs.getInt("accountID");
			String vorname = rs.getString("vorname");
			String nachname = rs.getString("nachname");
			String passwort = rs.getString("passwort");
			for (int i = 0; i <= getAccounts().size() - 1; i++) {
				if (accountID == getAccounts().get(i).getBenutzerID()) {
					return new Wette(getAccounts().get(i), wette.einsatz,null);
				}
			}
		}
		rs.close();
		stmt.execute();
		return wette;
	}

	public void setAccount(Account account) throws Exception {
		String sql = "insert into Account values(?,?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, account.benutzerID);
		stmt.setInt(2, account.kontonummer);
		stmt.setString(3, account.email);
		stmt.setString(4, account.passwort);
		stmt.setString(5, account.nachname);
		stmt.setString(6, account.vorname);
		stmt.setString(7, account.benutzername);
		stmt.setDouble(8, account.kontobetrag);
		stmt.setString(9, account.benutzerSeit);
		stmt.executeUpdate();
		stmt.close();
	}

	public void setWette(Wette wette, int benutzerID) throws SQLException {
		String sql = "insert into wette values(?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);

		System.out.println("WettID: "+wette.getID());
		System.out.println("benutzerID: "+benutzerID);
		System.out.println("wettEinsatz"+wette.einsatz);
		System.out.println("WettTipp: "+wette.getTipp());
		System.out.println("Erloese: "+wette.getErloese());
		stmt.setInt(1, wette.getID());
		stmt.setInt(2, benutzerID);
		stmt.setDouble(3, wette.einsatz);
		stmt.setString(4, ""+wette.getTipp());
		stmt.setDouble(5, wette.getErloese());
		stmt.executeUpdate();
		stmt.close();
	}

	public void setWettobjektObserveable(WettobjektObserveable wettObjekt) throws SQLException {
		String sql = "insert into wettobjekt value(?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		if (wettObjekt instanceof LottoWettObjekt) {
			LottoWettObjekt lotto = (LottoWettObjekt) wettObjekt;
			stmt.setInt(1, lotto.getId());
			stmt.setString(2, lotto.getBeschreibung());
			stmt.setDate(3, lotto.getStartDate());
			stmt.setDate(4, lotto.getEndDate());
			stmt.setString(6, "" + lotto.ergebnis());
		} else {
			if (wettObjekt instanceof ZahlenWettObjekt) {
				ZahlenWettObjekt zahl = (ZahlenWettObjekt) wettObjekt;
				stmt.setInt(1, zahl.getId());
				stmt.setString(2, zahl.getBeschreibung());
				stmt.setDate(3, zahl.getStartDate());
				stmt.setDate(4, zahl.getEndDate());
				stmt.setString(6, "" + zahl.ergebnis());
			}
		}
		stmt.executeUpdate();
		stmt.close();
	}

	public void close() throws SQLException {
		conn.close();
	}
}