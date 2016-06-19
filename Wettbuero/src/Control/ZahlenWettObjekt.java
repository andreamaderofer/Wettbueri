package Control;
import java.sql.Date;

/**
 * @author andrea
 *  @version 1.0
 */
import java.util.Observable;

import GUI.Endergebnis;

public class ZahlenWettObjekt extends WettobjektObserveable {
	private int zahl;

	public ZahlenWettObjekt(Date start, Date end, String beschreibung, String pars) {
		super(start, end, beschreibung, pars);
		this.zahl = Integer.parseInt(pars);
	}

	public ZahlenWettObjekt(Date start, Date end, String beschreibung, int zahl) {
		super(start, end, beschreibung, zahl);
		this.zahl = zahl;
	}

	public ZahlenWettObjekt() {
	}

	protected void start() {
	}

	protected void end() {
		ergebnis();
	}

	public void update(Observable o, Object arg) {
		if (this.hasChanged()) {
			this.notifyObservers(this);
			this.clearChanged();
		}
	}

	public double ergebnis() {
		int zufallszahl = (int) (Math.random() * 100) + 1;
		System.out.println("Lasst die Ziehung beginnen!");
		System.out.println("Zufallszahl erzeugen!");
		System.out.println("Die Ziehung ist beendet!");
		System.out.println("Die zu erratende Zahl lautet: " + zufallszahl);
		Endergebnis erg = new Endergebnis(zufallszahl, zahl, Gewinnausschuetung(this.zahl));
		return Gewinnausschuetung(this.zahl);
	}

	public double Gewinnausschuetung(int zahl) {
		for (int i = 0; i < wetten.size(); i++) {
			Account account = wetten.get(i).getAccount();

			if (wetten.get(i) instanceof ZahlenWette) {
				ZahlenWette zwette = (ZahlenWette) wetten.get(i);

				int tipp = wetten.get(i).getTipp();
				if (tipp == zahl) {
					account.einzahlung(account.getKontobetrag() * 10);
					return account.getKontobetrag();
				}

				if (tipp > 95 || tipp < 5 && !(tipp == zahl)) {
					account.einzahlung(account.getKontobetrag() * 3);
					return account.getKontobetrag();
				}

				if (tipp <= zahl + 10 && tipp >= zahl - 10) {
					account.einzahlung(account.getKontobetrag() * 4);
					return account.getKontobetrag();
				}
				if (tipp <= zahl + 20 && tipp >= zahl - 20) {
					account.einzahlung(account.getKontobetrag() * 2);
					return account.getKontobetrag();
				}
				if (tipp <= zahl + 30 && tipp >= zahl - 30) {
					account.einzahlung(account.getKontobetrag() * 1.5);
					return account.getKontobetrag();
				} else {
					account.einzahlung(account.getKontobetrag() * 1);
					return account.getKontobetrag();
				}
			}
		}
		return -1;
	}
}