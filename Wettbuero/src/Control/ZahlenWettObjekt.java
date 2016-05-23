package Control;

import java.util.Observable;

public class ZahlenWettObjekt extends WettobjektObserveable
{
	protected int zahl;
	protected String pars;
	
	public ZahlenWettObjekt() 
	{
		
	}

	public ZahlenWettObjekt (String pars) 
	{
		this.pars=pars;
	}

	public ZahlenWettObjekt (int zahl) 
	{
		this.zahl=zahl;
	}

	protected void start () 
	{		
		
	}

	protected void end () 
	{		
	}

	public void update(Observable o, Object arg) 
	{
		
	}
}