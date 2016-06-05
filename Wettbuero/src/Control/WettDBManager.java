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
 * 
 * @author Kurt
 * @version 1.0
 *
 */

public class WettDBManager {
	protected Connection conn;

	public WettDBManager() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("");
	}

	public ArrayList<Account> getAccounts() {
		Account account = null; 
		ArrayList<Account> accounts = new ArrayList<Account>(); 
		String sql = "SELECT * FROM account"; 
		Statement stmt = (Statement) conn.createStatement(); 
		ResultSet rs = ((java.sql.Statement) stmt).executeQuery(sql); 
		while(rs.next()) 
		{ 
			int kontostand = rs.getInt("kontostand"); 
			int accountID = rs.getInt("accountID"); 
			String vorname = rs.getString("vorname"); 
			String nachname = rs.getString("nachname"); 
			String passwort = rs.getString("passwort"); 
			account = new Account(kontostand, nachname, vorname, accountID, passwort); 
			accounts.add(account); 
		} 
		rs.close(); 
		stmt.close(); 
		 		 
		return accounts; 

	}

	public Wette getWette(Wette wette) {
		return null;
	}

	public void setAccount(Account account) throws SQLException {
		String sql = "insert into account values(?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, account.kontonummer);
		stmt.setString(2, account.email);
		stmt.setString(3, account.passwort);
		stmt.setString(4, account.nachname);
		stmt.setString(5, account.vorname);
		stmt.setString(6, account.benutzername);
		stmt.setDouble(7, account.kontobetrag);
		stmt.setString(8, account.benutzerSeit);

		stmt.executeUpdate(sql);
		stmt.close();
	}

	public void setWette(Wette wette) throws SQLException {
		String sql = "insert into wette values(?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, wette.getID());
		stmt.setInt(2, wette.account.kontonummer);
		stmt.setObject(3, wette.einsatz);
		stmt.setInt(4, wette.getTipp());
		stmt.setInt(5, wette.getErloese());

		stmt.executeUpdate(sql);
		stmt.close();
	}

	public void setWettobjektObserveable(WettobjektObserveable wettObjekt) {
		
		String sql = "INSERT INTO wettobjekt VALUES(?, ?, ?, ?, ?, ?)"; 
		PreparedStatement stmt = conn.prepareStatement(sql); 
		// stmt.setInt(1, wettobjekt.getWettobjektID()); 
		stmt.setString(2, wettObjekt).getBeschreibung()); 
		stmt.setDate(3, wettObjekt.getStartDate()); 
		stmt.setDate(4, wettObjekt.getEndDate()); 
		 
		stmt.setString(6, wettObjekt.getErgebnis()); 
		stmt.executeUpdate(); 
		stmt.close(); 

		stmt.setInt(1, wettObjekt.id);
		stmt.setInt(2, wettObjekt.wette.id);
		stmt.setString(3, wettObjekt.beschreibung);
		stmt.setDate(4, (Date) wettObjekt.start);
		stmt.setDate(5, (Date) wettObjekt.end);
		stmt.setString(6, wettObjekt.beschreibung);

		stmt.executeUpdate(sql);
		stmt.close();
	}

	public void close() throws SQLException {
		conn.close();
	}
	
	/*
	 * public Wettobjekt_Observeable getWettobjekt(Wettobjekt_Observeable wettobjekt) throws SQLException 
71 	{ 
72 		Wettobjekt_Observeable wettobjekt1 = null; 
73 		String sql = "SELECT * FROM wettobjekt WHERE wettobjektID = " + wettobjekt.getID(); 
74 		Statement stmt = conn.createStatement(); 
75 		ResultSet rs = stmt.executeQuery(sql); 
76 		if(wettobjekt instanceof LottoWettObjekt) 
77 		{ 
78 			while(rs.next()) 
79 			{ 
80 				Date wettstart = rs.getDate("wettstart"); 
81 				Date wettende = rs.getDate("wettende"); 
82 				String beschreibung = rs.getString("beschreibung"); 
83 				String zahlen = rs.getString("ergebnis"); 
84 				wettobjekt1 = new LottoWettObjekt(wettstart, wettende, beschreibung, zahlen); 
85 				wettobjekt1 = (Wettobjekt_Observeable) wettobjekt1; 
86 			} 
87 			rs.close(); 
88 			stmt.close(); 
89 		} 
90 		if(wettobjekt instanceof ZahlenWettObjekt) 
91 		{ 
92 			while(rs.next()) 
93 			{ 
94 				Date wettstart = rs.getDate("wettstart"); 
95 				Date wettende = rs.getDate("wettende"); 
96 				String beschreibung = rs.getString("beschreibung"); 
97 				String zahl = rs.getString("ergebnis"); 
98 				wettobjekt1 = new ZahlenWettObjekt(wettstart, wettende, beschreibung, zahl); 
99 				wettobjekt1 = (Wettobjekt_Observeable) wettobjekt1; 
100 			} 
101 			rs.close(); 
102 			stmt.close(); 
103 		} 
104 		 
105 		return wettobjekt1; 
106 	} 

	 */

}