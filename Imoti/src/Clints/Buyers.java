package Clints;

import java.util.ArrayList;
import java.util.Random;

import Agency.Agency;
import Agents.Agents;
import Agents.Views;
import Imoti.Imoti;

public class Buyers extends Clients {
	
	private double priceForImot;
	private ArrayList<Views> views = new ArrayList<>();
	public Buyers() {
		this.priceForImot = new Random().nextInt(120000) + 30000;
	}

	public void addViews(Views views) {
	
		if (views != null) {
			System.out.println("Вие направихте оглед на имот " + views.getImot());
			this.views.add(views);
		}
	}

	public void registrationSearchImot(Agency agency) {
		if (agency == null) {
			System.out.println("Null reference in Buyers");
			return;
		}
		Agents agents = agency.returnAgents();
		this.agents = agents;
		this.agents.addBuyers(this);
		System.out.println("Успешна регистрация за търсена на имот");
		System.out.println("Вашият агент е " + this.agents.getName());
	}

	public void requestViews(Imoti imot) {
		if (imot.getPrice() >= this.priceForImot) {
			System.out.println("Няма толкова пари в начност за да заявите оглет на този имота");
			System.out.println("<" + imot + ">");
			System.out.println("Цена на имота: "+imot.getPrice());
			System.out.println("Вашия биуджет: "+this.priceForImot);
			return;
		}
		Views views = new Views(imot, this);
		this.views.add(views);
		views.getImot().getAgents().addViews(views);
		System.out.println("Успешна регистрация за оглед на имот");

	}

	public void buyImot() {
		System.out.println("===Покупка на имот===");
		if(this.views.size() == 0){
			System.out.println("Нямате огледани имоти");
			return;
		}
		Imoti imot = this.views.get(new Random().nextInt(this.views.size())).getImot();
		Agency agency = imot.getAgency();
		agency.payToAgency(imot, 3 * imot.getPrice() / 100);
		System.out.println("Куповача плати кумисионната на агенцията");
		ArrayList<Sellers> sellers = imot.getAgents().getSeller();
		Sellers seller = null;
		for (int i = 0; i < sellers.size(); i++) {
			if(sellers.get(i).getImot() == imot){
				seller = sellers.get(i);
				break;
			}
		}
		
		if(seller == null){
			System.out.println("Null regence in buyer - is not seller to sell imot ");
			return;
		}
		
		this.money -= imot.getPrice()+(3*imot.getPrice()/100);
		System.out.println("Куповача плати сумата нужна за покупка на имота");
		seller.getMoneyImot(imot.getPrice()-(3*imot.getPrice()/100));
		agency.payToAgency(seller.getImot(), 3*seller.getImot().getPrice()/100);
		System.out.println("Продавача плати комисионната на агенцията");
	}

}
