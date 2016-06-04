package Control;
/**
 * 
 * @author Andrea
 * @version 1.0
 */
public class LottoWettObjekt {
	protected int[] zahlen = new int[500];
	
	public LottoWettObjekt() 
	{
	}

	public LottoWettObjekt(String pars) 
	{
		for(int i=0; i<=zahlen.length;i++)
		{
			zahlen[i] = Integer.parseInt(pars.split(" ").toString());
		}
	}

	public LottoWettObjekt(int[] zahlen) 
	{
		this.zahlen = zahlen;
	}

	protected void start() 
	{
		//diese Methode soll laut Greini leer sein, höchstens den Status der Wette auf gestartet setzen,
		//sprich man darf keine Tipps mehr abgeben.
	}

	protected void end() 
	{
		//Hier soll die Ziehung stattfinden
	}
}
