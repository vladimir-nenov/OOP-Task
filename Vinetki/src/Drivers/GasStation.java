package Drivers;

import java.util.ArrayList;
import java.util.Random;

import VEnichle.Venichle;
import Vinetki.ForBus;
import Vinetki.ForCar;
import Vinetki.ForTruck;
import Vinetki.Vinetka;

public class GasStation {
	private String name;
	private double moneyToDay;
	private ArrayList<Vinetka> vinetki;

	public GasStation(String name) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		} else {
			this.name = "Petrol";
		}
		this.vinetki = new ArrayList<>();
		String[] type = { "Day", "Month", "Year" };
		Random r = new Random();
		for (int i = 0; i < 1000; i++) {
			int n = r.nextInt(3) + 1;
			if (n == 1) {
				this.vinetki.add(new ForCar(type[new Random().nextInt(type.length )]));
			}
			if (n == 2) {
				this.vinetki.add(new ForBus(type[new Random().nextInt(type.length)]));
			}
			if (n == 3) {
				this.vinetki.add(new ForTruck(type[new Random().nextInt(type.length)]));

			}

		}
		sortByPrice();
	}

	public Vinetka sellVineka(Venichle venichle, String type) {
		if (!type.equalsIgnoreCase("Day") && !type.equalsIgnoreCase("Month") && !type.equalsIgnoreCase("Year")) {
			System.out.println("This type " + type + " is not valid type for vinetka");
			return null;
		}
		Vinetka vinetka = null;
		if (venichle.getColorForVinetka().equals("Blue")) {
			vinetka = new ForCar(type);
		}
		if (venichle.getColorForVinetka().equals("Red")) {
			vinetka = new ForBus(type);
		}
		if (venichle.getColorForVinetka().equals("Yellow")) {
			vinetka = new ForTruck(type);
		}
		for (int i = 0; i < this.vinetki.size(); i++) {
			if(this.vinetki.get(i).getColor().equals(vinetka.getColor()) && this.vinetki.get(i).getType().equalsIgnoreCase(vinetka.getType())){
				this.vinetki.remove(this.vinetki.get(i));
			}
		}

		return vinetka;

	}
	public void payToGasStation(double money){
		this.moneyToDay+= money;
	}

	private void sortByPrice() {
		this.vinetki.sort((o1, o2) -> ((int) o1.getPrice()) - ((int) o2.getPrice()));
	}
	
	public void printAllVinetki(){
		sortByPrice();
		System.out.println("=====Gasstation "+this.name+"=====");
		System.out.println("<Number of vinetki : "+this.vinetki.size()+">");
		for (int i = 0; i < this.vinetki.size(); i++) {
			System.out.println(this.vinetki.get(i));
		}
	}

}
