package Datenstrukturen;

public class einnahmen implements java.io.Serializable {
	private double einnahme;
	private String datum;
	private String art;
	private String referenz;
	
	//Einnahmen erstellung
	
	public einnahmen(double einnahmen,String datum, String art, String referenz){
		this.einnahme = einnahmen;
		this.datum = datum;
		this.art = art;
		this.referenz = referenz;		
	}
	
	public String toString(){
		
		if(this.referenz == null){
			
		return "null";	
	}
		else{
		return (
				"//Einnahme: "+
				this.einnahme +
				"//Datum: "+
				this.datum+
				"//Art: "+
				this.art+
				"//Referenz: "+
				this.referenz);
	}}
	
	public einnahmen(String s){
		StringBuilder sb = new StringBuilder();
		if(s.substring(0, 9).equals("//Einnahme")){
			sb.append(s);
			sb.delete(0, 9);
		}
		
	}
	
	//Getter und Setter

	public double getEinnahme() {
		return einnahme;
	}

	public void setEinnahme(double einnahme) {
		this.einnahme = einnahme;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}

	public String getReferenz() {
		return referenz;
	}

	public void setReferenz(String referenz) {
		this.referenz = referenz;
	}
	
	

}
