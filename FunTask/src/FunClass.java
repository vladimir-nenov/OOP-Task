import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class FunClass {
	private String text;
	Scanner sc = new Scanner(System.in);
	private HashMap<Character, Integer> map = new HashMap<>();
	private LinkedHashMap<Character, Integer> sort = new LinkedHashMap<>();
	
	
	public void start(){
		System.out.println("====Enter some text====");
		String text = sc.nextLine();
		text = converString(text);
		addInHashMap(text);
		sorByValue();
		printRezutl();
	}
	private void printRezutl(){
		int bigValue = 0;
		for(Entry<Character, Integer> entry : sort.entrySet()){
			bigValue = entry.getValue();
			break;
		}
		for (Entry<Character, Integer> entry : sort.entrySet()) {
			System.out.print(entry.getKey()+": " + entry.getValue()+" ");
			for (int i = 0; i < bigValue * entry.getValue(); i++) {
				System.out.print("#");
			}
			System.out.println();
			
		}
	}
	private void sorByValue(){
		for (int i = 0; i < map.size(); i++) {
			char key = 'a';
			int value = 0;
			for(Iterator<Entry<Character, Integer>> it = map.entrySet().iterator(); it.hasNext();){
				Entry<Character, Integer> entry = it.next();
				if(entry.getValue() > value){
					value = entry.getValue();
					
					key = entry.getKey();
				}
			}
		
			sort.put(key, value);
			map.put(key, 0);
			
		}
	}
	
	private void addInHashMap(String text){
		if(text.length()<1 && text == null){
			return;
		}
		for (int i = 0; i < text.length(); i++) {
			if(map.containsKey(text.charAt(i))){
				map.put(text.charAt(i), map.get(text.charAt(i)) + 1);
				continue;
			}
			map.put(text.charAt(i), 1);
		}
		
	}
	private String converString(String text){
		text = text.toUpperCase();
		text = text.replace(".", "");
		text = text.replace("!", "");
		text = text.replace("?", "");
		text = text.replace(" ", "");
		return text;
		
	}

}
