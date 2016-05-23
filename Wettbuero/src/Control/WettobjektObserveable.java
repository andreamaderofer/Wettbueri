package Control;
import GUI.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observer;

abstract class WettobjektObserveable extends TimerTask implements Observer
{
	protected int id;
	protected Date start;
	protected Date end;
	protected ArrayList<Wette> wetten=new ArrayList<Wette>();
	protected long zeit;
	protected ArrayList<Observer> observer=new ArrayList<Observer>();
	
	
	public WettobjektObserveable() 
	{
		
	}

	public void wetten (Wette wette)
	{
		if(wette instanceof ZahlenWette)
		{
			ZahlenWette zahlw=new ZahlenWette();
		}
		else
		{
			if(wette instanceof LottoWette)
			{
				LottoWette lottoWe=new LottoWette();
			}
		}
	}

	public void run ()
	{
		TimerTask timeTask=new TimerTask();
		timeTask.run();
	}

	protected abstract void start () ;
	protected abstract void end () ;

	public void alsObserveableMarkieren (Observer observer)
	{
		this.observer.add(observer);
	}

	public void alleObserverUpdateSenden () 
	{

	}
}