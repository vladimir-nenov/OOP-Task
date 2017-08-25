package Vinetki;

import VEnichle.Venichle;

public class ForTruck extends Vinetka{

	public ForTruck(String type) {
		super(type);
		this.color = "Yellow";
		this.price = super.createPrice(9);
	}

}
