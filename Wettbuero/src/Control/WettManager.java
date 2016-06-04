package Control;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author Kurt
 * @version 1.0
 *
 */
public class WettManager {
	protected WettDBManager wettDBManager;
	public ArrayList<Account> accountListe;

	public WettManager() {

	}

	public void wetteSetzen(Wette wette) throws SQLException {
		wettDBManager.setWette(wette);
	}

	public void accountsErstellen(Account account) throws SQLException {
		wettDBManager.setAccount(account);
	}

	public void wetteSetzen(WettobjektObserveable wettobjekt){
		wettDBManager.setWettobjektObserveable(wettobjekt);
	}
	
}
