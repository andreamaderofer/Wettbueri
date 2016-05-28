package Control;

import java.util.Observable;

public class ZahlenWettObjekt extends WettobjektObserveable {
	protected int [] zahl=new int[500];
	protected int zaehlen=0;
	protected String pars;
	

	public ZahlenWettObjekt() {
		super.run();
	}

	public ZahlenWettObjekt(String pars) {
		this.pars = pars;
		
	}

	public ZahlenWettObjekt(int zahl) {
		this.zahl[zaehlen]=zahl;
		zaehlen++;
	}

	protected void start() {

	}

	protected void end() {

	}

	public void update(Observable o, Object arg) {
	}
}