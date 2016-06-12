package Control;

/**
 * @author Tobias
 * @version 1.0
 */
class LottoWette extends Wette {


	protected int[] wette;
	int zaehler = 0;

	public LottoWette(String pars) {
		super();
		wette[zaehler] = Integer.parseInt(pars);
		zaehler++;
	}

	public LottoWette(int[] w) {
		wette = w;
	}

}