package Control;

/**
 * 
 * @author Tobias
 * @version 1.0
 */

public class ZahlenWette extends Wette {
	protected int wette;
	protected String pars;

	public ZahlenWette(int wettID,String pars, Account acc, double WettEinsatz) {
		super(wettID,acc,WettEinsatz,pars);
	}

	public ZahlenWette(String parsi) {
		pars = parsi;
	}

	public ZahlenWette(int wetti) {
		wette = wetti;
	}

	public ZahlenWette() {
	}
}