package Control;

import java.sql.Date;

import GUI.Endergebnis;

/**
 * @author Andrea
 * @version 1.0
 */
public class LottoWettObjekt extends WettobjektObserveable {
	protected int zahl;
	protected int[] zufallsZahlen=new int[20];

	public LottoWettObjekt(Date start, Date end, String beschreibung, String pars) {
		super(start, end, beschreibung, pars);
		zahl = Integer.parseInt(pars);
	}

	public LottoWettObjekt(Date start, Date end, String beschreibung, int zahl) {
		super(start, end, beschreibung, zahl);
		this.zahl = zahl;
	}

	public LottoWettObjekt() {
		super();
	}

	protected void start() {
	}

	protected void end() {
		this.ergebnis();
	}

	public double ergebnis() {
		int zufallszahl = 0;
		System.out.println("Lasst die Ziehung beginnen!");
		System.out.println("Zufallszahl erzeugen!");
		System.out.println("Die Ziehung ist beendet!");
		for (int i = 0; i < 6; i++) {
			zufallszahl = (int) (Math.random() * 100) + 1;
			zufallsZahlen[i] = zufallszahl;
		}
		System.out.println("Die zu erratende Zahl lautet: " + zufallszahl);
		Endergebnis erg = new Endergebnis(zufallsZahlen, zahl, Gewinnausschuetung());
		return Gewinnausschuetung();
	}

	public double Gewinnausschuetung() {
		for (int i = 0; i < wetten.size(); i++) {
			Account account = wetten.get(i).getAccount();

			if (wetten.get(i) instanceof LottoWette) {
				if (zahlenImTipp((LottoWette) wetten.get(i)) == 6) {
					account.einzahlung(account.getKontobetrag() * 10);
					return account.getKontobetrag();
				}

				if (zahlenImTipp((LottoWette) wetten.get(i)) >= 4) {
					account.einzahlung(account.getKontobetrag() * 4.5);
					return account.getKontobetrag();
				}

				if (zahlenImTipp((LottoWette) wetten.get(i)) == 3) {
					account.einzahlung(account.getKontobetrag() * 3);
					return account.getKontobetrag();
				}
				if (zahlenImTipp((LottoWette) wetten.get(i)) == 2) {
					account.einzahlung(account.getKontobetrag() * 2);
					return account.getKontobetrag();
				}
				if (zahlenImTipp((LottoWette) wetten.get(i)) == 1) {
					account.einzahlung(account.getKontobetrag() * 1.5);
					return account.getKontobetrag();
				} else {
					account.einzahlung(account.getKontobetrag() * 1);
					return account.getKontobetrag();
				}
			}
		}
		return zahl;
	}

	public int zahlenImTipp(LottoWette wette) {
		int passendeZahlen = 0;
		for (int i = 0; i < 6; i++) {
			int zahl = wette.getWette()[i];
			for (int z = 0; z < zufallsZahlen.length; z++) {
				if (zufallsZahlen[z] == zahl)
					passendeZahlen++;
			}
		}
		return passendeZahlen;
	}
}
