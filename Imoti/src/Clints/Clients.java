package Clints;

import java.util.Random;

import Agency.Agency;
import Agents.Agents;

public abstract class Clients {
	protected double money;
	protected String telNumber;
	protected String name;
	protected Agents agents;
	private static int countNulber = 13;
	public Clients() {
		String  name[] = {"Петър","Иван","Атанас","Георги","Стеган","Николай","Петър"};
		this.name = name[new Random().nextInt(name.length-1)];
		this.telNumber = "08781235"+countNulber++;
		
	}
	
	
	
	

	

}
