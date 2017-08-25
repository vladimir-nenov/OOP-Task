package Megazine;

public class Cashbox {
	private double money;
	
	
	public void addMoney(double money){
		if(money < 0){
			return;
		}
		this.money+=money;
	}
	

}
