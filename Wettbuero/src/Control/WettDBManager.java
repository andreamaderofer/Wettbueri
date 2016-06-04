package Control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author Kurt Brennecke
 * @version 1.0
 *
 */
class WettDBManager 
{
	protected Connection conn;

	public WettDBManager() throws SQLException, ClassNotFoundException 
	{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("");
	}

	public ArrayList<Account> getAccounts () {
		return null;
	}
	
	public Wette getWette (Wette wette) {
		return null;
	}

	public ZahlenWettObjekt getWettobjekt (ZahlenWettObjekt wettobjekt) {
		return null;
	}
	
	public LottoWettObjekt getWettobjekt (LottoWettObjekt wettobjekt) {
		return null;
	}
	
	public void setAccount (Account account) throws SQLException
	{
		String sql = "insert into account values(?,?,?,?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, account.kontonummer);
		stmt.setString(2, account.email);
		stmt.setString(3,account.passwort);
		stmt.setString(4,account.nachname);
		stmt.setString(5,account.vorname);
		stmt.setString(6,account.benutzername);
		stmt.setInt(7,account.kontobetrag);
		stmt.setString(8,account.benutzerSeit);
		
		stmt.executeUpdate(sql);
		stmt.close();
	}

	public void setWette (Wette wette) throws SQLException
	{
		String sql = "insert into account values(?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, wette.getID());
		stmt.setInt(2, wette.account.kontonummer);
		stmt.setObject(3,wette.einsatz);
		stmt.setString(4,wette.tipp);
		stmt.setInt(5,wette.erloes);
		
		stmt.executeUpdate(sql);
		stmt.close();
	}

	public void setWettobjektObserveable(WettobjektObserveable wettObjekt){
		
	}
	
	public void close () throws SQLException {
		conn.close();
	}

}