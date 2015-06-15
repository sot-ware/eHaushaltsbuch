package Datenstrukturen;

public class kalender implements java.io.Serializable {
	public einnahmen[] list;
	
	public kalender(){
		this.list = new einnahmen[1];
		this.list[0] = null;
	}
	
	public void addEinnahme(einnahmen e){
		if(this.list.length == 1 && this.list[0] ==null){
			this.list[0] = e;
		}
		else{
		einnahmen[] kalender = new einnahmen[this.list.length+1];
		for(int i=0;i<this.list.length;i++){
			kalender[i] = this.list[i];
		}
		kalender[this.list.length] = e;
		this.list = kalender;
	}
	}
	
	public String toString(){
		String  s="";
		for(einnahmen e:list){
			if(e != null){
			s = s+e.toString();
			}
		}
		return s;
	}
			

}
