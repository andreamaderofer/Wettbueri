package Control;

/**
 * 
 * @author Tobias
 * @version 1.0
 */

class ZahlenWette extends Wette {
	protected int wette;
	protected String pars;
	
	public ZahlenWette() 
	{
		
	}

	public ZahlenWette (String parsi)
	{
		pars = parsi;
	}

	public ZahlenWette (int wetti) 
	{
		wette = wetti;
	}
}