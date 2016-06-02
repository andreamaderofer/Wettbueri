package Control;

/**
 * 
 * @author Tobias
 * @version 1.0
 */

class Wette 
{
	protected Account account;
	protected Wette einsatz;
	private int ID = -1;

	public Wette(Account acc, Wette eins) 
	{
		ID++;
		account = acc;
		einsatz = eins;
	}

	public Wette() 
	{
		
	}
	
	public int getID()
	{
		return ID;
	}
}



