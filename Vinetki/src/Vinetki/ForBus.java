package Vinetki;

public class ForBus extends Vinetka {

	public ForBus(String type) {
		super(type);
		this.color = "Red";
		this.price = super.createPrice(7);
	}
	

}
