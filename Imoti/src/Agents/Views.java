package Agents;

import Clints.Buyers;
import Imoti.Imoti;

public class Views {
	private Imoti imot;
	private Agents agents;
	private Buyers buyers;
	private String date;
	
	
	public Views(Imoti imot,Buyers buyer) {
		this.imot = imot;
		this.agents = imot.getAgents();
		this.buyers = buyer;
	}
	
	
	public Imoti getImot() {
		return imot;
	}
	

}
