package Megazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

import Instrumnts.BraveInstruments;
import Instrumnts.ElectricInstruments;
import Instrumnts.HitInstruments;
import Instrumnts.Instruments;
import Instrumnts.KeyInstruments;
import Instrumnts.Stringed;

public class Refence {
	LinkedHashMap<String, Integer> refernce = new LinkedHashMap<>();
	HashMap <String, Integer> map = new HashMap<>();
	
	private double money;

	public void addInstruments(String name, int number, double money, String instruments) {
		if(map.containsKey(instruments)){
			Integer rezut = map.get(instruments) + number;
			map.put(instruments, rezut);
		}
		map.put(instruments, number);
		
		
		this.money += money;
		if (this.refernce.containsKey(name)) {
			Integer rezult = this.refernce.get(name) + number;
			this.refernce.put(name, rezult);
			sort();
			return;
		}
		this.refernce.put(name, number);
		sort();

	}

	public void printMostSoldAndNonSoldInstrumet() {
		TreeMap<Integer, String> newMap = new TreeMap<>((o1 , o2 )-> o2-o1);
		for (Iterator <Entry<String,Integer>> it = map.entrySet().iterator(); it.hasNext();){
			Entry<String, Integer> entry = it.next();
			newMap.put(entry.getValue(), entry.getKey());
		}
		LinkedList<String> list = new LinkedList<>();
		for (Iterator <Entry<Integer, String>> it = newMap.entrySet().iterator(); it.hasNext(); ) {
			Entry<Integer, String> entry = it.next();
			list.add(entry.getValue());
		}
		System.out.println("=================================================");
		System.out.println("Най - продавания тип инструменти е "+list.getFirst());
		System.out.println("Най - непродавания тип инструменти е "+list.getLast());
		System.out.println("=================================================");
		
		
		
		

	}

	private HashSet<String> returnName(String[] names) {
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < names.length; i++) {
			set.add(names[i]);
		}
		return set;
	}

	public void printMostNotSoldInstruments() {
		int number = 0;
		String name = null;
		for (Iterator<Map.Entry<String, Integer>> it = this.refernce.entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, Integer> entry = it.next();
			number = entry.getValue();
			name = entry.getKey();
			break;
		}
		for (Iterator<Map.Entry<String, Integer>> it = this.refernce.entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, Integer> entry = it.next();
			if (number > entry.getValue()) {
				
				number = entry.getValue();
				name = entry.getKey();
			}
		}
		System.out
				.println("Най - непродавания инстромет по броика е " + name + " ,броя продажби " + number);
	}

	public void printMostSellsInstrumentsByNumber() {
		int number = 1;
		String name = "";
		for (Iterator<Map.Entry<String, Integer>> it = this.refernce.entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, Integer> entry = it.next();
			if (number < entry.getValue()) {
				number = entry.getValue();
				name = entry.getKey();
			}
		}
		System.out.println("Най - продавания инстромет по броика е  " + name + " ,броя продажби " + number);

	}

	private void sort() {
		TreeMap<Integer, String> three = new TreeMap<>();
		for (Iterator<Map.Entry<String, Integer>> it = this.refernce.entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, Integer> entry = it.next();
			three.put(entry.getValue(), entry.getKey());
		}
		this.refernce.clear();

		for (Iterator<Map.Entry<Integer, String>> it = three.entrySet().iterator(); it.hasNext();) {
			Map.Entry<Integer, String> entry = it.next();
			this.refernce.put(entry.getValue(), entry.getKey());
		}
	}

	public void printAllSumForSells() {
		System.out.println("===Сумата от всички продажби " + this.money + " лв. ===");
	}

}
