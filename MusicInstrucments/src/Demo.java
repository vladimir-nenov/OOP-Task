import Megazine.Megazine;
import Megazine.Refence;

public class Demo {
	public static void main(String[] args) {
		Megazine mag = new Megazine("MAgazine");
		mag.addInstrumts("�������", 14);
		mag.addInstrumts("����������", 12);
		mag.addInstrumts("���������", 56);
		mag.printNumberOfInstrumet();
		mag.sortByPriceWithMostExpensive(false);
		mag.sellInstrumets("�������", 14);
		mag.sellInstrumets("���������", 24);
		mag.sellInstrumets("����������", 4);
		mag.printNumberOfInstrumet();
		Refence re = mag.getRefence();
		re.printMostSellsInstrumentsByNumber();
		re.printMostNotSoldInstruments();
		re.printAllSumForSells();
		re.printMostSoldAndNonSoldInstrumet();
	}

}
