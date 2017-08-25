package Imoti;

import java.util.Random;

import Imoti.Apartment.typeStr;

public class House extends Imoti {
	private typeStr type;
	private enum typeHouse{етажоткъща, цялакъща};
	private typeHouse typeOfHouse;
	private double parkingPlace;
	
	public House() {
		this.parkingPlace = new Random().nextInt(1000);
		this.type = Apartment.typeStr(new Random().nextInt(4)+1);
		if(new Random().nextBoolean()){
			this.typeOfHouse = typeHouse.етажоткъща;
		}else{
			this.typeOfHouse = typeHouse.цялакъща;
		}
		this.price = new Random().nextInt(30000)+50000;
		this.imtoType = "House";
		
	}
	

}
