package Control;
/**
 * @author andrea
 * @version 1.0
 */
import GUI.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import javax.print.attribute.DateTimeSyntax;

abstract class WettobjektObserveable extends Observable {
	protected int id;
	protected Date start;
	protected Date end;
	protected String beschreibung;
	protected ArrayList<Wette> wetten;
	public ArrayList<Observer> observer;

	public WettobjektObserveable(Date start, Date end, String beschreibung, String pars) {
		this.start=start;
		this.end=end;
		this.beschreibung=beschreibung;
		
		Timer t = WettTimerSingleton.getInstance();
		TimerTask timer = null;
		t.schedule(timer, end);
		t.schedule(timer, start);
	}

	public WettobjektObserveable(Date start, Date end, String beschreibung, int zahl) {
		this.start=start;
		this.end=end;
		this.beschreibung=beschreibung;
		
		Timer t = WettTimerSingleton.getInstance();
		TimerTask timer = null;
		t.schedule(timer, end);
		t.schedule(timer, start);
	}

	public void wetten(Wette wette) {
		wetten.add(wette);
	}

	public void run() {
		if (start.getTime() < end.getTime()) {
			start();
		} else {
			end();
		}
	}

	abstract void start();

	abstract void end();

	public void alsObserveableMarkieren(Observer observer) {
		this.observer.add(observer);
	}

	public void alleObserverUpdateSenden() {
		if (this.hasChanged()) {
			this.notifyObservers(this);
			this.clearChanged();
		}
	}
	
	public Date getEndDate(){
		return end;
	}
	
	public Date getStartDate(){
		return start;
	}
}