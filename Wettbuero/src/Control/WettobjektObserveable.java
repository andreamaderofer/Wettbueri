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
	public static final String wette = null;
	protected int id;
	protected Date start;
	protected Date end;
	protected String beschreibung;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public ArrayList<Wette> getWetten() {
		return wetten;
	}

	public void setWetten(ArrayList<Wette> wetten) {
		this.wetten = wetten;
	}

	public ArrayList<Observer> getObserver() {
		return observer;
	}

	public void setObserver(ArrayList<Observer> observer) {
		this.observer = observer;
	}

	public static String getWette() {
		return wette;
	}

	protected ArrayList<Wette> wetten;
	public ArrayList<Observer> observer;

	public WettobjektObserveable(Date start, Date end, String beschreibung, String pars) {
		this.start = start;
		this.end = end;
		this.beschreibung = beschreibung;

		Timer t = WettTimerSingleton.getInstance();
		TimerTask timer = null;
		t.schedule(timer, end);
		t.schedule(timer, start);
	}

	public WettobjektObserveable(Date start, Date end, String beschreibung, int zahl) {
		this.start = start;
		this.end = end;
		this.beschreibung = beschreibung;

		Timer t = WettTimerSingleton.getInstance();
		TimerTask timer = null;
		t.schedule(timer, end);
		t.schedule(timer, start);
	}

	public WettobjektObserveable() {
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

	public java.sql.Date getEndDate() {
		return (java.sql.Date) end;
	}

	public java.sql.Date getStartDate() {
		return (java.sql.Date) start;
	}

}