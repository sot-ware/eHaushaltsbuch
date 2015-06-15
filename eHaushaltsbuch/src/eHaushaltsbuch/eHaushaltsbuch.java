package eHaushaltsbuch;

import java.io.File;

import Datenstrukturen.Filereadwrite;

public class eHaushaltsbuch {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Willkommen, drücken sie 1 für laden 2 für neuer Kalender");
		//Erstelle neuen TestKalender
		Datenstrukturen.kalender kalender = new Datenstrukturen.kalender();
		//Erstelle eine neue Einnahmme;
		//erstelle ein datum
		java.util.Date datum = new java.util.Date(System.currentTimeMillis());
		Datenstrukturen.einnahmen e = new Datenstrukturen.einnahmen(500.0,datum,0,"");
		
		//Einnahme in Kalender einfügen
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
