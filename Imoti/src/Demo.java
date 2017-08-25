import java.util.ArrayList;
import java.util.Random;

import Agency.Agency;
import Clints.Buyers;
import Clints.Sellers;
import Imoti.Apartment;
import Imoti.House;
import Imoti.Parcels;

public class Demo {
	public static void main(String[] args) {
		Agency agency = new Agency("Таланти Естейтс");
		agency.printMoneInAgency();
		ArrayList<Sellers>sellers = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			sellers.add(new Sellers());
		}
		for (int i = 0; i < sellers.size(); i++) {
			int n = new Random().nextInt(100);
			if(n >= 0 && n <= 33){
				sellers.get(i).addImot(new Apartment());
			}
			if(n> 33 && n<=66){
				sellers.get(i).addImot(new House());
			}
			if(n > 66 && n <= 99){
				sellers.get(i).addImot(new Parcels());
			}
		}
		
		for (int i = 0; i < sellers.size(); i++) {
			sellers.get(i).registrationImot(agency);
		}
		
		ArrayList<Buyers> buyers = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			buyers.add(new Buyers());
		}
		
		for (Buyers buyers2 : buyers) {
			buyers2.registrationSearchImot(agency);
		}
		for (int i = 0; i < buyers.size(); i++) {
			for (int j = 0; j < 3; j++) {
				buyers.get(i).requestViews(agency.returnImot());
			}
		}
		
		for (Buyers buyers2 : buyers) {
			buyers2.buyImot();
		}
		agency.printMoneInAgency();
		agency.printAgentMoney();
	}

}
