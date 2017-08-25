package Imoti;

import java.util.Random;

import Agency.Agency;
import Agents.Agents;

public abstract class Imoti {
	protected String imtoType;
	protected double price;
	protected String addres;
	protected Agents agents;
	protected double place;
	protected String text;
	protected Agency agency;
	public Imoti() {
		String [] adres = {"Монтана","Враца","Перник","Варна","Бургас","Кърджали","Асеновград"};
		this.addres = adres[new Random().nextInt(adres.length-1)];
		this.place = new Random().nextInt(240);
		this.text = "Много добър имот";
	}
	public void setAgency(Agency agency) {
		this.agency = agency;
	}
	public void setAgents(Agents agents) {
		if(agents != null){
		this.agents = agents;
		}
	}
	public Agency getAgency() {
		return agency;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{Type: "+this.imtoType+": Adres: "+this.addres+"}";
	}
	
	public Agents getAgents() {
		return agents;
	}
	
	public double getPrice() {
		return price;
	}

}
