package Imoti;

import java.util.Random;

public class Parcels extends Imoti {
	public enum typeOfParce {����, ������, ����};
	private typeOfParce type;
	private boolean isRegular;
	 public Parcels() {
		this.price = new Random().nextInt(55000)+30000;
		if(new Random().nextBoolean()){
			this.isRegular = true;
		}else{
			this.isRegular = false;
		}
		this.type = typeOfParce(new Random().nextInt(3)+1);
		
		
	}
	 
	 private typeOfParce typeOfParce(int n){
		 if(n == 1){
			 return typeOfParce.����;
			 
		 }
		 if(n == 2){
			 return typeOfParce.����;
		 }
		 return typeOfParce.������;
	 }

}
