package VEnichle;

public class Truck extends Venichle{

	@Override
	public String getColorForVinetka() {
		return "Yellow";
	}
	@Override
	public String toString() {
		return super.toString()+"Type: Truck> ";
	}

}
