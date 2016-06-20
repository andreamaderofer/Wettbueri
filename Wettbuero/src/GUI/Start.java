package GUI;



import java.util.Date;

import Control.*;
public class Start {

	public static void main(String[] args) {
		LottoWettObjekt lott=new LottoWettObjekt();
		Date dat = new Date();
		lott.setStart(dat);
		ZahlenWettObjekt zahl=new ZahlenWettObjekt();
		zahl.setStart(dat);
		lott.setStart(dat);
		zahl.setStart(dat);
		lott.setEnd(dat);
		lott.end();
		zahl.end();
		zahl.setEnd(dat);		
		lott.run();
		zahl.run();
	}

}
