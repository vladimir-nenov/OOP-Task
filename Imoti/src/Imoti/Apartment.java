package Imoti;

import java.util.Random;

public class Apartment extends Imoti {
	private enum typeAparments {
		������, ����������, ��������, ��������, �������
	};

	public static enum typeStr {
		���, �����, �����, ������
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
			return typeStr.������;
		}if(n == 2){
			return typeStr.�����;
		}
		if(n == 3){
			return typeStr.�����;
		}
		return typeStr.���;
		
		
		
	}
	private typeAparments typeOfAparments(int n){
		if (n == 1) {
			return this.type = typeAparments.����������;

		}
		if (n == 2) {
			return this.type = typeAparments.��������;

		}
		if (n == 3) {
			return this.type = typeAparments.�������;

		}
		if (n == 4) {
			return this.type = typeAparments.������;

		}
		if (n == 5) {
			return this.type = typeAparments.��������;

		}
		return null;
	}

}
