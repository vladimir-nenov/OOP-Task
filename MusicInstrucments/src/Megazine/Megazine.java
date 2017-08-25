package Megazine;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import Instrumnts.BraveInstruments;
import Instrumnts.ElectricInstruments;
import Instrumnts.HitInstruments;
import Instrumnts.Instruments;
import Instrumnts.KeyInstruments;
import Instrumnts.Stringed;

public class Megazine {
	private Refence refence = new Refence();
	private String name;
	private Cashbox cashBox;
	private HashMap<String, Integer> couting = new HashMap<>();
	private TreeSet<Instruments> intruments = new TreeSet<>();
	

	public Megazine(String name) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		} else {
			this.name = "Музикални Таланти";
		}
		this.cashBox = new Cashbox();
	}
	
	

	public void sellInstrumets(String name, int numberOfInstrumts) {
		if (!this.couting.containsKey(name)) {
			System.out.println("Нямаме този инструмент");
			return;
		}
		if (this.couting.get(name) < numberOfInstrumts) {
			System.out.println("Нямаме толкова налични бройки от този инструмент");
			return;
		}
		Integer rezult = this.couting.get(name) - numberOfInstrumts;
		this.couting.put(name, rezult);
		double money = 0;
		String instrumetType = null;
		Instruments instruments = null;
		for(Iterator<Instruments> it = this.intruments.iterator(); it.hasNext(); ){
			 instruments = it.next();
			if(instruments.getName().equalsIgnoreCase(name)){
				if(rezult == 0){
					instruments.setAvailable(false);
				}
				this.cashBox.addMoney(instruments.getPrice()*numberOfInstrumts);
				money = instruments.getPrice();
				instrumetType = instruments.getType();
				System.out.println("Успешна продажба! ");
			}
		}
		System.out.println(instrumetType);
		this.refence.addInstruments(name, numberOfInstrumts, money, instrumetType);
		return;
	}
	
	

	public void addInstrumts(String name, int number) {
		if (this.couting.containsKey(name)) {
			Integer newNumber = this.couting.get(name) + number;
			this.couting.put(name, newNumber);
		}
		String nameOfBarave[] = { "тромпет", "тромбон", "туба", "флейта", "кларинет" };
		String nameOfElectric[] = { "синтезатор", "бас-китара", "електрическа", "цигулка" };
		String nameOfHit[] = { "барабани", "тарамбука", "тъпан", "дайре" };
		String nameOfKey[] = { "орган", "пиано", "акордеон" };
		String nameOfStringed[] = { "цигулка", "виола", "контрабас", "арфа", "китара", "гъдулка" };
		HashMap<Instruments, HashSet<String>> map = new HashMap<>();

		map.put(new BraveInstruments(null), returnName(nameOfBarave));
		map.put(new ElectricInstruments(null), returnName(nameOfElectric));
		map.put(new HitInstruments(null), returnName(nameOfHit));
		map.put(new KeyInstruments(null), returnName(nameOfKey));
		map.put(new Stringed(null), returnName(nameOfStringed));
		Instruments intrument = null;
		for(Iterator<Map.Entry<Instruments, HashSet<String>>> it = map.entrySet().iterator(); it.hasNext();){
			Map.Entry<Instruments, HashSet<String >> entry = it.next();
			if(entry.getValue().contains(name)){
				intrument = entry.getKey().returnInstans(name);
			}
		}
		intrument.setAvailable(true);
		this.intruments.add(intrument);
		this.couting.put(name, number);
		

	}
	
	public Refence getRefence() {
		return refence;
	}
	public void printNumberOfInstrumet(){
		for(Iterator <Map.Entry<String, Integer>> it = this.couting.entrySet().iterator(); it.hasNext(); ){
			Map.Entry<String, Integer> entyr = it.next();
			System.out.println("===="+entyr.getKey()+"====");
			System.out.println("        "+entyr.getValue());
		}
	}
	public void sortByType(){
		for (Instruments instruments : this.intruments) {
			System.out.println(instruments);
		}
	}
	public void sortByName(){
		System.out.println("====Sort by name====");
		TreeSet<Instruments> three = new TreeSet<>(new Comparator<Instruments>() {
			@Override
			public int compare(Instruments o1, Instruments o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		three.addAll(this.intruments);
		for (Instruments instruments : three) {
			System.out.println(instruments);
		}
	}
	
	public void sortByPriceWithMostExpensive(boolean ifYouWantToMostExpensive){
		System.out.println("===Sort by price===");
		if(ifYouWantToMostExpensive){
		TreeSet<Instruments> three = new TreeSet<>(new Comparator<Instruments>() {
			@Override
			public int compare(Instruments o1, Instruments o2) {
				return ((int)o2.getPrice()) - ((int)o1.getPrice());
			}
		});
		three.addAll(this.intruments);
		
		for (Instruments instruments : three) {
			System.out.println(instruments);
		}
		}else{
			TreeSet<Instruments> three = new TreeSet<>(new Comparator<Instruments>() {
				@Override
				public int compare(Instruments o1, Instruments o2) {
					return ((int)o1.getPrice()) - ((int)o2.getPrice());
				}
			});
			three.addAll(this.intruments);
			
			for (Instruments instruments : three) {
				System.out.println(instruments);
			}
			
		}
	}
	
	
	public void printInstrumentHasThem(){
		System.out.println("====Instrumnts is there====");
		for (Instruments instruments : this.intruments) {
			if(instruments.getAvailable()){
				System.out.println(instruments);
			}
		}
	}

	private HashSet<String> returnName(String[] names) {
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < names.length; i++) {
			set.add(names[i]);
		}
		return set;
	}

}
