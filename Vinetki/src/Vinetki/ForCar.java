package Vinetki;

public class ForCar extends Vinetka{

	public ForCar(String type) {
		super(type);
		this.color = "Blue";
		this.price = super.createPrice(5);
	}
	
	
}
