package Gui;
import java.io.File;



public class mainWindow  {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		
		//Men� zum test noch Textbasierend.
		System.out.println("Willkommen, dr�cken sie 1 f�r laden 2 f�r neuer Kalender");
		//...
		//...
	
		Oberflaeche UI = new Oberflaeche();
		UI.setVisible(true);
	
		UI.addColumn();
		
		//Erstelle neuen TestKalender
		Datenstrukturen.kalender kalender = new Datenstrukturen.kalender();
		
		//Erstelle eine neue Einnahmme
		//Erstelle ein Datum
		java.util.Date datum = new java.util.Date(System.currentTimeMillis());

		Datenstrukturen.einnahmen e = new Datenstrukturen.einnahmen(500.0,datum,0,"");
		
		//Einnahme in Kalender einf�gen
		kalender.addEinnahme(e);
		
		
		
	

		//Speichern des Kalenders
		File f = new File("Test.kal");
		Datenstrukturen.Filereadwrite.serializeKalender(f, kalender);
		
		//Laden des Kalenders in eine neue variable
		f = new File("Test.kal");
		Datenstrukturen.kalender k = new Datenstrukturen.kalender() ;
		Datenstrukturen.Filereadwrite.deserializeKalender(f, k);
		
		//Ausgabe des neuen Kalenders
		System.out.print(k);
		
		
		
		
	}



	
}
