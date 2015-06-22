package Datenstrukturen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Filereadwrite {
	
	//Speichern des Kalenders
	public static void serializeKalender(File file, kalender kal)
    {
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream(file));
           os.writeInt(kal.list.length);
           System.out.println(kal.list.length);
           
           for(int i = 0;i<kal.list.length;i++){
           	os.writeObject(kal.list[i]);
            	//System.out.println(kal.kalender[i]);
            }
//Achtung: Objekte k�nnen nur dann serialisiert werden wenn sie das Interface "Serializable" implementieren
            os.flush();
            os.close();
        }
        catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }
    }
	
	public static kalender deserializeKalender(File file,kalender zubefuellenderKalender)
    {
        ObjectInputStream is;
        try {
            is = new ObjectInputStream(new FileInputStream(file));
            
            int length = is.readInt();
            
            zubefuellenderKalender = new kalender();
            zubefuellenderKalender.list = new einnahmen[length];
            for(int i = 0;i<length;i++){
            	System.out.println("A+"+i);
            einnahmen temp = (einnahmen) is.readObject();
            zubefuellenderKalender.list[i] = temp;
            if((temp).getArt() != null){
            zubefuellenderKalender.list[i].setArt((temp).getArt());
            }
            zubefuellenderKalender.list[i].setEinnahme((temp).getEinnahme());
            if((temp).getReferenz() != null){
            zubefuellenderKalender.list[i].setReferenz((temp).getReferenz());
            }
            if((temp).getDatum() != null){
            zubefuellenderKalender.list[i].setDatum((temp).getDatum());
            }
            System.out.println(zubefuellenderKalender.list[i]);
            }
            
            is.close();
            return zubefuellenderKalender;
 
        }
        catch (FileNotFoundException e1) {
            e1.printStackTrace();
            return new kalender();
        }
        catch (IOException e1) {
            e1.printStackTrace();
            return new kalender();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new kalender();
        }

}
	
	
	
	//Speichern einer einnahme
	public static void serializeEinnahme(File file, einnahmen kal)
    {
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream(file));
            os.writeObject(kal);
//Achtung: Objekte k�nnen nur dann serialisiert werden wenn sie das Interface "Serializable" implementieren
            os.close();
        }
        catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }
    }
	
	public static boolean deserialize(File file,kalender zubefuellenderKalender)
    {
        ObjectInputStream is;
        try {
            is = new ObjectInputStream(new FileInputStream(file));
            zubefuellenderKalender = (kalender) is.readObject();
            is.close();
            return true;
 
        }
        catch (FileNotFoundException e1) {
            e1.printStackTrace();
            return false;
        }
        catch (IOException e1) {
            e1.printStackTrace();
            return false;
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }

}
}
