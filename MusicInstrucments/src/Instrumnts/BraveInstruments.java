package Instrumnts;

import java.util.Random;

public class BraveInstruments extends Instruments {

	public BraveInstruments(String name) {
		super(name);
		this.type = "BraveInstruments";
	}

	@Override
	public Instruments returnInstans(String name) {
		return new BraveInstruments(name);
	}

}
