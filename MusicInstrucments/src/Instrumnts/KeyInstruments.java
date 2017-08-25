package Instrumnts;

import java.util.Random;

public class KeyInstruments extends Instruments{
	public KeyInstruments(String name) {
		super(name);
		this.type = "Keybort";
	}

	@Override
	public Instruments returnInstans(String name) {
		return new KeyInstruments(name);
	}

}
