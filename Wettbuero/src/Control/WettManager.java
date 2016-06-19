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

	public void wetteSetzen(Wette wette) throws Exception {
		wettDBManager.setWette(wette, 0);
	}

	public void accountsErstellen(Account account) throws Exception {
		wettDBManager.setAccount(account);
	}

	public void wetteSetzen(WettobjektObserveable wettobjekt) throws SQLException {
		wettDBManager.setWettobjektObserveable(wettobjekt);
	}

}
