package Control;

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
	protected ArrayList<Wette> wetten;
	public ArrayList<Observer> observer;

	public WettobjektObserveable() {
		Timer t = WettTimerSingleton.getInstance();
		TimerTask timer = null;
		t.schedule(timer, end);
		t.schedule(timer, start);
	}

	public void wetten(Wette wette) {

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
		this.addObserver(observer);
	}

	public void alleObserverUpdateSenden() {
		if (this.hasChanged()) {
			this.notifyObservers(this);
			this.clearChanged();
		}
	}
}