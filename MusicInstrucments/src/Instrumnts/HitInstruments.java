package Instrumnts;

import java.util.Random;

public class HitInstruments extends Instruments{
	public HitInstruments(String name) {
		super(name);
		this.type = "HitInstruments";
		
	}

	@Override
	public Instruments returnInstans(String name) {
		return new HitInstruments(name);
	}

}
