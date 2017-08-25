package Agency;

import java.util.ArrayList;
import java.util.Random;

import Agents.Agents;
import Imoti.Imoti;

public class Agency {
	private String name;
	private String addres;
	private String telNumber;
	private ArrayList<Agents> agents;
	private ArrayList<Imoti> imoti;
	private double moneyInAgency;
	
	private static int counTel = 12;
	public Agency(String name) {
		if(name != null && !name.isEmpty()){
			this.name = name;
			
		}else{
			this.name = "Agency";
		}
		this.telNumber = "08784565"+counTel++;
		String [] addres = {"Перник","София","Стара Загора","Велико Търново","Етрополе"};
		this.addres = addres[new Random().nextInt(addres.length-1)];
		this.agents = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			this.agents.add(new Agents());
		}
		this.imoti = new ArrayList<>();
	}
	
	public Agents returnAgents(){
		if(this.agents.size() == 0){
			System.out.println("Null refernce");
			return null;
		}
		return this.agents.get(new Random().nextInt(this.agents.size()));
	}
	public Imoti returnImot(){
		return this.imoti.get(new Random().nextInt(this.imoti.size()));
	}
	public void addImoti(Imoti imot){
		if(imot == null){
			System.out.println("Null reference");
			return;
		}
		this.imoti.add(imot);
	}
	public void payToAgency(Imoti imot, double money){
		imot.getAgents().payToAgents(money/2);
		this.moneyInAgency+=money/2;
	}
	public void printMoneInAgency(){
		System.out.println("<Money: "+this.moneyInAgency+">");
	}
	
	public void printAgentMoney(){
		sortAgents();
		for (Agents agents2 : agents) {
			System.out.println("<Name: "+agents2.getName()+", Money: "+agents2.getMoney()+">");
		}
	}
	private void sortAgents(){
		Agents[] agents = new Agents[this.agents.size()];
		for (int i = 0; i < agents.length; i++) {
			agents[i] = this.agents.get(i);
		}
		this.agents.clear();
		for (int i = 0; i < agents.length; i++) {
			for (int j = 1; j < agents.length-i; j++) {
				if(agents[j-1].getMoney() < agents[j].getMoney()){
					Agents temp = agents[j];
					agents[j] = agents[j-1];
					agents[j-1] = temp;
				}
			}
		}
		for (int i = 0; i < agents.length; i++) {
			this.agents.add(agents[i]);
		}
		
		
	}

}
