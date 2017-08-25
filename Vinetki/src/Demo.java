import java.sql.Driver;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Random;

import Drivers.Drivers;
import Drivers.GasStation;
import VEnichle.Bus;
import VEnichle.Car;
import VEnichle.Truck;

public class Demo {
	public static void main(String[] args) {
		GasStation gasStation = new GasStation("При Пешо таланта");
		gasStation.printAllVinetki();

		ArrayList<Drivers> drivers = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			Drivers dr = new Drivers();
			dr.setGasStation(gasStation);
			drivers.add(dr);
		}
		Random r = new Random();
		for (int i = 0; i < drivers.size(); i++) {
			for (int j = 0; j < 10; j++) {
				int n = r.nextInt(3) + 1;
				if (n == 1) {
					drivers.get(i).addVenichle(new Car());
				}
				if (n == 2) {
					drivers.get(i).addVenichle(new Bus());
				}
				if (n == 3) {
					drivers.get(i).addVenichle(new Truck());

				}

			}
		}
		for (int i = 0; i < drivers.size(); i += 3) {
			for (int j = 0; j < 5; j++) {
				String[] srok = { "Day", "Month", "Year" };
				Drivers dr = drivers.get(i);
				dr.bullVinetkaForVenichle(dr.returnRandomNumberOfVenichle(), srok[new Random().nextInt(srok.length)]);
			}
		}

		for (int i = 0; i < drivers.size(); i++) {

			LocalDate date = LocalDate.ofYearDay(2000 + new Random().nextInt(17) + 10, new Random().nextInt(365) + 1);
			drivers.get(i).printCarWithexpiryDateVinetka(date);
		}
		gasStation.printAllVinetki();
		
		for (int i = 0; i < drivers.size(); i++) {
			LocalDate date = LocalDate.ofYearDay(2000 + new Random().nextInt(17) + 10, new Random().nextInt(365) + 1);
			drivers.get(i).printAllTruck(date);
		}
		

	}

}
