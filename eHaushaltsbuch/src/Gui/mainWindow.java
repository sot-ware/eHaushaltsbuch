package Gui;
import java.io.File;



public class mainWindow  {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		
		//Menü zum test noch Textbasierend.
	//	System.out.println("Willkommen, drücken sie 1 für laden 2 für neuer Kalender");
		//...
		//Erstelle neuen TestKalender
	//	Datenstrukturen.kalender kalender = new Datenstrukturen.kalender();
		
		//Erstelle eine neue Einnahmme
		//Erstelle ein Datum
		String datum = new java.util.Date(System.currentTimeMillis()).toString();

	//	Datenstrukturen.einnahmen e = new Datenstrukturen.einnahmen(500.0,datum,"ALT","");
		
		//Einnahme in Kalender einfügen
	//	kalender.addEinnahme(e);
	//	File f = new File("Test.kal");
	//	Datenstrukturen.Filereadwrite.serializeKalender(f, kalender);
		//...
	
		Oberflaeche UI = new Oberflaeche();
		
		UI.setVisible(true);
		//Laden des Kalenders in eine neue variable
		File f = new File("Test.kal");
		Datenstrukturen.kalender kalender = new Datenstrukturen.kalender() ;
		kalender = Datenstrukturen.Filereadwrite.deserializeKalender(f, kalender);
		UI.kalender = kalender;
		//kalender = new Datenstrukturen.kalender();
		//datum = new java.util.Date(System.currentTimeMillis()).toString();
		//e = new Datenstrukturen.einnahmen(500.0,datum,"LUSTIG","");
//		
//		//Einnahme in Kalender einfügen
		//kalender.addEinnahme(e);
		System.out.println(kalender.list.length);
		Object[][] a = new Object [4][kalender.list.length]; 
		
		for(int i=0;i<kalender.list.length;i++){

				UI.addColumn(kalender.list[i].getReferenz(),kalender.list[i].getEinnahme(), 
						kalender.list[i].getDatum(), kalender.list[i].getArt());
				
				
				
			}
		UI.calcBilanz();
		}
	
	
//	//	UI.addColumn();
//		
//		//Erstelle neuen TestKalender
//		Datenstrukturen.kalender kalender = new Datenstrukturen.kalender();
//		
//		//Erstelle eine neue Einnahmme
//		//Erstelle ein Datum
//		java.util.Date datum = new java.util.Date(System.currentTimeMillis());
//
//		Datenstrukturen.einnahmen e = new Datenstrukturen.einnahmen(500.0,datum,0,"");
//		
//		//Einnahme in Kalender einfügen
//		kalender.addEinnahme(e);
//		
//		
//		
//	
//
//		//Speichern des Kalenders
//		File f = new File("Test.kal");
//		Datenstrukturen.Filereadwrite.serializeKalender(f, kalender);
//		
//
//		
//		//Ausgabe des neuen Kalenders
//		System.out.print(k);
//		
		
		
		
	}



	

