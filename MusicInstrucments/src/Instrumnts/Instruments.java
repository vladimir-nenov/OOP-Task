package Instrumnts;

import java.util.Random;

import javax.xml.crypto.dsig.CanonicalizationMethod;

public abstract class Instruments implements Comparable<Instruments> {
	protected String name;
	protected double price;
	protected boolean isAvailable;
	protected String type;

	public Instruments(String name){
		if(name == null){
			this.name = "";
		}else{
		this.name = name;
		}
		this.price = new Random().nextInt(1000);
	}
	
	public double getPrice() {
		return price;
	}
	public abstract Instruments returnInstans(String name);
	
	public String getType() {
		return type;
	}
	public boolean getAvailable(){
		return this.isAvailable;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public int compareTo(Instruments o) {
		return this.type.compareTo(o.type);
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "<Name: "+this.name+"|Price: "+this.price+"|Type: "+this.type+">";
	}

}
