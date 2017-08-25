package Clints;

import Agency.Agency;
import Agents.Agents;
import Imoti.Imoti;

public class Sellers extends Clients {
	private Imoti imot;
	
	
	public void addImot(Imoti imto){
		if(imto!=null){
			this.imot = imto;
		}
	}
	
	public void registrationImot(Agency agency){
		if(this.imot == null){
			System.out.println("��� ������ ���� ����� �� ������������");
			return;
		} 
		Agents agents = agency.returnAgents();
		this.imot.setAgency(agency);
		this.agents = agents;
		this.imot.setAgents(agents);
		agency.addImoti(this.imot);
		agents.addSellers(this);
		System.out.println("��� ������� ������������� ����.");
		System.out.println("������ ����� � "+this.imot.getAgents().getName());
		
		
	}
	
	public Imoti getImot() {
		return imot;
	}
	public void getMoneyImot(double money){
		this.money+=money;
	}
	

}
