import Megazine.Megazine;
import Megazine.Refence;

public class Demo {
	public static void main(String[] args) {
		Megazine mag = new Megazine("MAgazine");
		mag.addInstrumts("тромпет", 14);
		mag.addInstrumts("синтезатор", 12);
		mag.addInstrumts("тарамбука", 56);
		mag.printNumberOfInstrumet();
		mag.sortByPriceWithMostExpensive(false);
		mag.sellInstrumets("тромпет", 14);
		mag.sellInstrumets("тарамбука", 24);
		mag.sellInstrumets("синтезатор", 4);
		mag.printNumberOfInstrumet();
		Refence re = mag.getRefence();
		re.printMostSellsInstrumentsByNumber();
		re.printMostNotSoldInstruments();
		re.printAllSumForSells();
		re.printMostSoldAndNonSoldInstrumet();
	}

}
