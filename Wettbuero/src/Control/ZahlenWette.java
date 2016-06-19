package Control;

/**
 * 
 * @author Tobias
 * @version 1.0
 */

public class ZahlenWette extends Wette {
	protected int wette;
	protected String pars;

	public ZahlenWette(String pars, Account acc, double WettEinsatz) {
		super(acc,WettEinsatz,pars);
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