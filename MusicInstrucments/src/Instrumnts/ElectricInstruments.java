package Instrumnts;

import java.util.Random;

public class ElectricInstruments extends Instruments{
	public ElectricInstruments(String name) {
		super(name);
		this.type = "Elektronik";
	}

	@Override
	public Instruments returnInstans(String name) {
		return new ElectricInstruments(name);
	}

}
