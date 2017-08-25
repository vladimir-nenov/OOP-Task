package Imoti;

import java.util.Random;

public class Apartment extends Imoti {
	private enum typeAparments {
		студио, гарсониера, двустаен, тристаен, мезонет
	};

	public static enum typeStr {
		ЕПК, Тухла, Панел, Кирпич
	};
	private typeAparments type;
	private typeStr bilders;

	public Apartment() {
		this.imtoType = "Aparments";
		this.typeOfAparments(new Random().nextInt(5)+1);
		this.bilders = typeStr(new Random().nextInt(4)+1);
		this.price = new Random().nextInt(80000)+70000;
		
	}
	public static typeStr typeStr(int n){
		if(n == 1){
			return typeStr.Кирпич;
		}if(n == 2){
			return typeStr.Панел;
		}
		if(n == 3){
			return typeStr.Тухла;
		}
		return typeStr.ЕПК;
		
		
		
	}
	private typeAparments typeOfAparments(int n){
		if (n == 1) {
			return this.type = typeAparments.гарсониера;

		}
		if (n == 2) {
			return this.type = typeAparments.двустаен;

		}
		if (n == 3) {
			return this.type = typeAparments.мезонет;

		}
		if (n == 4) {
			return this.type = typeAparments.студио;

		}
		if (n == 5) {
			return this.type = typeAparments.тристаен;

		}
		return null;
	}

}
