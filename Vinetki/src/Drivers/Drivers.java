package Drivers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import VEnichle.Truck;
import VEnichle.Venichle;
import Vinetki.Vinetka;

public class Drivers {
	private String name;
	private ArrayList<Venichle> venichle;
	private double money;
	private GasStation gasStation;

	public Drivers() {
		String names[] = { "Иван ", "Стефан", "Генади", "Матей", "Атанас", "Георги", "Исмайл" };
		this.name = names[new Random().nextInt(names.length - 1)];
		this.money = new Random().nextInt(10000) + 1;
		this.venichle = new ArrayList<>();
	}

	public void setGasStation(GasStation gasStation) {
		this.gasStation = gasStation;
	}

	public void addVenichle(Venichle ve) {
		this.venichle.add(ve);
	}

	public int returnRandomNumberOfVenichle() {
		return new Random().nextInt(this.venichle.size());
	}

	public void bullVinetkiForAllVenichle(String issue) {
		if (!issue.equalsIgnoreCase("Day") && !issue.equalsIgnoreCase("Month") && !issue.equalsIgnoreCase("Year")) {
			System.out.println("This type " + issue + " is not valid type for vinetka");
			return;
		}
		for (int i = 0; i < venichle.size(); i++) {
			this.venichle.get(i).stickVinetka(gasStation.sellVineka(this.venichle.get(i), issue));
		}
		double allPriceForVinetki = 0;
		for (int i = 0; i < this.venichle.size(); i++) {
			allPriceForVinetki += this.venichle.get(i).getVinetka().getPrice();
		}
		if (allPriceForVinetki > this.money) {
			System.out.println("You dont have money, to bull vinetki for all your venichle");
			for (int i = 0; i < this.venichle.size(); i++) {
				this.venichle.get(i).removeVinetka();
			}
			return;
		}
		this.money -= allPriceForVinetki;
		this.gasStation.payToGasStation(allPriceForVinetki);
		System.out.println(this.name + " bull vinetki for all venichle");
		return;

	}

	public void bullVinetkaForVenichle(int numberOfVenichle, String issue) {
		if (!issue.equalsIgnoreCase("Day") && !issue.equalsIgnoreCase("Month") && !issue.equalsIgnoreCase("Year")) {
			System.out.println("This type " + issue + " is not valid type for vinetka");
			return;
		}
		if (numberOfVenichle > this.venichle.size() || numberOfVenichle < 0) {
			System.out.println("Invalid number of venichle");
			return;
		}
		Vinetka vinetka = gasStation.sellVineka(this.venichle.get(numberOfVenichle), issue);

		if (vinetka.getPrice() > this.money) {
			System.out.println("Dont have money to bull vinetka ");
			return;
		}
		this.money -= vinetka.getPrice();
		this.gasStation.payToGasStation(vinetka.getPrice());

		this.venichle.get(numberOfVenichle).stickVinetka(vinetka);
		System.out.println(this.name + " bull vinetka for " + this.venichle.get(numberOfVenichle).getModel());
		System.out.println("Vinetka type " + vinetka.getType());

	}

	public void printCarWithexpiryDateVinetka(LocalDate date) {
		System.out.println("Date to addet <" + date + ">");
		System.out.println("<Name: " + this.name + ">");
		System.out.println("<Number of venichle is: " + this.venichle.size() + ">");
		System.out.println("<Money: " + this.money + ">");
		for (int i = 0; i < this.venichle.size(); i++) {
			Venichle ve = this.venichle.get(i);
			if (ve.getVinetka() != null) {
				if (!contensDate(ve.getVinetka().getExpiryDate(), date)) {
					System.out.println(ve + " vinekta has expired: <Vinetka: " + ve.getVinetka().getExpiryDate() + ">");

				}
			}else{
				System.out.println(this.name + " do not have vinetka in venichle " + ve);
				
			}

		}

	}

	public void printAllTruck(LocalDate date) {
		System.out.println("<Name: " + this.name + ">");
		System.out.println("Date to addet <" + date + ">");
		for (int i = 0; i < this.venichle.size(); i++) {
			if (this.venichle.get(i) instanceof Truck) {
				Venichle ve = this.venichle.get(i);
				if (ve.getVinetka() != null) {

					if (!contensDate(ve.getVinetka().getExpiryDate(), date)) {
						System.out.println(
								ve + " vinekta has expired: <Vinetka: " + ve.getVinetka().getExpiryDate() + ">");
					}
				} else {
					System.out.println(this.name + " do not have vinetka in venichle " + ve);
				}

			}
		}

	}

	private boolean contensDate(LocalDate date1, LocalDate date2) {
		if (date1.getYear() < date2.getYear()) {
			return false;
		} else if (date1.getYear() == date2.getYear()) {
			if (date1.getMonthValue() < date2.getMonthValue()) {
				return false;
			} else if (date1.getMonthValue() == date2.getMonthValue()) {
				if (date1.getDayOfMonth() < date2.getDayOfMonth()) {
					return false;
				}
			}
		}
		return true;

	}

}
