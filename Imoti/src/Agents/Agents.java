package Agents;

import java.util.ArrayList;
import java.util.Random;

import Clints.Buyers;
import Clints.Sellers;

public class Agents {
	private String name;
	private String telNumber;
	private double money;
	private ArrayList<Sellers> seller;
	private ArrayList<Buyers> buyers;
	private ArrayList<Views> views;
	
	public Agents() {
		String name[] = {"Иван ","Стоян","Петър","Георги","Марин","Лазар"};
		this.name = name[new Random().nextInt(name.length-1)];
		this.seller = new ArrayList<>();
		this.buyers = new ArrayList<>();
		this.views = new ArrayList<>();
	}
	public void payToAgents(double money){
		this.money+=money;
	}
	public void addSellers(Sellers seller){
		if(seller != null){
			this.seller.add(seller);
			return;
		}
		System.out.println("Null reference");
	}
	
	public String getName() {
		return name;
	}
	
	public void addBuyers(Buyers buyers){
		if(buyers != null){
			this.buyers.add(buyers);
		}
	}
	
	public ArrayList<Sellers> getSeller() {
		return seller;
	}
	
	public void addViews(Views views){
		if(views != null){
			this.views.add(views);
		}
	}
	
	public double getMoney() {
		return money;
	}

}
