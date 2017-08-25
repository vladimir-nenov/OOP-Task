package VEnichle;

import java.time.LocalDate;
import java.util.Random;

import Vinetki.Vinetka;

public abstract class Venichle {
	protected String model;
	protected Vinetka vinetka;
	protected LocalDate dateTocreate;
	
	public Venichle() {
	   String model[] = {"Ford","Renault","Mercedes","Pegeut","VW","KingLong","Setra"};
	   this.model = model[new Random().nextInt(model.length-1)];
	   this.dateTocreate = LocalDate.now();
	   
	}
	
	public abstract String getColorForVinetka();
	
	public void stickVinetka(Vinetka vinetka) {
		this.vinetka = vinetka;
	}
	
	public Vinetka getVinetka() {
		return vinetka;
	}
	public void removeVinetka(){
		this.vinetka = null;
	}
	
	public String getModel() {
		return model;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "<Model: "+this.model+"|Date to create: "+this.dateTocreate+"|";
	}

}
