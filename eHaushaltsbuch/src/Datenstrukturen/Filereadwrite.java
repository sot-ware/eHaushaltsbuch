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
	
	public static boolean deserializeKalender(File file,kalender zubefuellenderKalender)
    {
        ObjectInputStream is;
        try {
            is = new ObjectInputStream(new FileInputStream(file));
            
            int length = is.readInt();
            zubefuellenderKalender = new kalender();
            zubefuellenderKalender.list = new einnahmen[length];
            for(int i = 0;i<length;i++){
            zubefuellenderKalender.list[i] = (einnahmen) is.readObject();
            }
            System.out.println(zubefuellenderKalender.list[0]);
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
