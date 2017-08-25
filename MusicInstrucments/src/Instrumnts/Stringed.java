package Instrumnts;

import java.util.Random;

public class Stringed extends Instruments{
	public Stringed(String name) {
		super(name);
		this.type = "StringetInstruments";
		
	}

	@Override
	public Instruments returnInstans(String name) {
		return new Stringed(name);
	}

}
