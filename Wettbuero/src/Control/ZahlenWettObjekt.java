package Control;
import java.sql.Date;
/**
 * @author andrea
 *  @version 1.0
 */
import java.util.Observable;

public class ZahlenWettObjekt extends WettobjektObserveable {
	private int zahl;
	
	
	public ZahlenWettObjekt(Date start, Date end, String beschreibung, String pars) {
		super(start, end, beschreibung,pars);
		this.zahl = Integer.parseInt(pars);		
	}

	public ZahlenWettObjekt(Date start, Date end, String beschreibung, int zahl) {
		super(start,end,beschreibung,zahl);
		this.zahl=zahl;
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
	
	public void ergebnis(){
		System.out.println("Lasst die Ziehung beginnen!");
		System.out.println("Zufallszahl erzeugen!");
		int zufallszahl= (int) (Math.random()*100)+1;
		System.out.println("Die Ziehung ist beendet!");
		System.out.println("Die zu erratende Zahl lautet: "+zufallszahl);		
	}
	
	public void Gewinnausschuetung(int zahl){
		for(int i=0;i<wetten.size();i++){
			Account account=wetten.get(i).getAccount();
			
			if(wetten.get(i) instanceof ZahlenWette){
				ZahlenWette zwette=(ZahlenWette)wetten.get(i);
				
				int tipp=wetten.get(i).getTipp();
				
				
				if(tipp<=zahl+10 && tipp>=zahl-10){
					account.einzahlung(account.getKontobetrag()*4);
				}
				if(tipp<=zahl+20 && tipp>=zahl-20){
					account.einzahlung(account.getKontobetrag()*2);
				}
				if(tipp<=zahl+30 && tipp>=zahl-30){
					account.einzahlung(account.getKontobetrag()*1.5);
				}
				else{
					account.einzahlung(account.getKontobetrag()*1);
				}
			}			
		}
	}
	
	/*
	 * if(gerateneZahl<=zufallszahl+10 && gerateneZahl>=zufallszahl-10)
	 * Account account=wette.getAccount(); 
46 			Zahlenwette wette_1=(Zahlenwette)wette; 
47 			 
48 			if(wette instanceof Zahlenwette){ 
49 				 
50 				int tipp=wette_1.getWette(); 
51 				if(tipp>95 && zufallszahl<4){ 
52 					int zahl=100+zufallszahl; 
53 					if((zahl-tipp)<=2){account.einzahlung(account.getKontobetrag()*5); continue;} 
54 					if((zahl-tipp)<=5){account.einzahlung(account.getKontobetrag()*2); continue;} 
55 				} 
56 				if(zufallszahl>95 && tipp<4){ 
57 					int zahl=100+tipp; 
58 					if((zahl-zufallszahl)<=2){account.einzahlung(account.getKontobetrag()*5); continue;} 
59 					if((zahl-zufallszahl)<=5){account.einzahlung(account.getKontobetrag()*2); continue;} 
60 				} 
61 			 
62 				if(zufallszahl<10) 
63 				if(tipp < (zufallszahl % 100) +2  && tipp > (zufallszahl % 100)-2) { 
64 					{account.einzahlung(account.getKontobetrag()*5); continue;} 
65 				} 
66 				if(tipp < (zufallszahl % 100)+5 && tipp > (zufallszahl % 100)-5){ 
67 					{account.einzahlung(account.getKontobetrag()*2); continue;} 
68 				}			 
69 			} 

	 */
}