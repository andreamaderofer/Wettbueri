package Control;

/**
 * @author Tobias
 * @version 1.0
 */
public class LottoWette extends Wette {

	protected int[] wette;

	public LottoWette(String pars, Account acc, double WettEinsatz) {
		super(acc,WettEinsatz,pars);
		String[] split = pars.split(",");
		for (int i = 0; i < split.length; i++) {
			wette[i] = Integer.parseInt(split[i]);
		}
	}

	public int[] getWette() {
		return wette;
	}

	public LottoWette(int[] w) {
		wette = w;
	}

}