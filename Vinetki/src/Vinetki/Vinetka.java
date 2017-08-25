package Vinetki;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.Year;



public abstract class Vinetka {
	protected LocalDate issue;
	protected String color;
	protected String type;
	protected LocalDate expiryDate;
	protected double price;

	public Vinetka(String type) {
		if(!type.equalsIgnoreCase("Day") || !type.equalsIgnoreCase("Month") || !type.equalsIgnoreCase("Year")){
			this.type = "Day";
		}else{
			this.type = type;
		}

		this.type = type;
		this.issue = LocalDate.now();
		if (this.type.equals("Day")) {
			Period oneDay = Period.ofDays(1);
			this.expiryDate = this.issue.plus(oneDay);
		}
		if (this.type.equals("Month")) {
			Period oneMonth = Period.ofMonths(1);
			this.expiryDate = this.issue.plus(oneMonth);
		}
		if (this.type.equals("Year")) {
			Period yaer = Period.ofYears(1);
			this.expiryDate = this.issue.plus(yaer);
		}

	}
	public String getColor() {
		return color;
	}
	public String getType() {
		return type;
	}
	public LocalDate getIssue() {
		return issue;
	}
	
	protected double createPrice(double dayPrice){
		if(type.equalsIgnoreCase("Day")){
			return dayPrice;
		}
		if(type.equalsIgnoreCase("Month")){
			return dayPrice*10;
		}
		return (dayPrice*10)*6;
		
		
	}
	public double getPrice() {
		return price;
	}
	
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "<Color: "+this.color+"| Price: "+this.price+"| Date to create: "+this.issue+"|Expiry Date: "+this.expiryDate+">";
	}
	
	

}
