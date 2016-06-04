package Control;

import java.sql.Date;

/**
 * 
 * @author Andrea
 * @version 1.0
 */
public class LottoWettObjekt extends WettobjektObserveable {
	protected int zahl;

	public LottoWettObjekt(Date start, Date end, String beschreibung, String pars) { 
		super(start, end, beschreibung, pars);
		zahl = Integer.parseInt(pars);
	}

	public LottoWettObjekt(Date start, Date end, String beschreibung, int zahl) {
		super(start, end, beschreibung, zahl);
		this.zahl = zahl;
	}

	protected void start() {
		// diese Methode soll laut Greini leer sein, h�chstens den Status der
		// Wette auf gestartet setzen,
		// sprich man darf keine Tipps mehr abgeben.
	}

	protected void end() {
		this.ergebnis();
	}
	
	
	public void ergebnis() {
		System.out.println("Lasst die Ziehung beginnen!");
		System.out.println("Zufallszahl erzeugen!");
		int zufallszahl = (int) (Math.random() * 100) + 1;
		System.out.println("Die Ziehung ist beendet!");
		System.out.println("Die zu erratende Zahl lautet: " + zufallszahl);
	}

	public void Gewinnausschuetung(int zahl) {
		for (int i = 0; i < wetten.size(); i++) {
			Account account = wetten.get(i).getAccount();

			if (wetten.get(i) instanceof LottoWette) {
				LottoWette Lottow = (LottoWette) wetten.get(i);

				int tipp = wetten.get(i).getTipp();
				if (tipp == zahl) {
					account.einzahlung(account.getKontobetrag() * 10);
				}

				if (tipp > 95 || tipp < 5 && !(tipp == zahl)) {
					account.einzahlung(account.getKontobetrag() * 3);
				}

				if (tipp <= zahl + 10 && tipp >= zahl - 10) {
					account.einzahlung(account.getKontobetrag() * 4);
				}
				if (tipp <= zahl + 20 && tipp >= zahl - 20) {
					account.einzahlung(account.getKontobetrag() * 2);
				}
				if (tipp <= zahl + 30 && tipp >= zahl - 30) {
					account.einzahlung(account.getKontobetrag() * 1.5);
				} else {
					account.einzahlung(account.getKontobetrag() * 1);
				}
			}
		}
	}
}
