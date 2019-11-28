package pecs.iths.java.alapok;

import java.time.LocalDate;

public class Car {
	
	//Adattagok
	private String rendszam; // "PRN-824"
	private int alvazszam; //123456789
	private double motor; //1.6
	private boolean manualisValto; // az auto manualis-e vagy automata
	private char uzemanyag;  // 'B', 'D', 'E', 'H', 'G' 
	private LocalDate gyartasiev; // 1980-febr-5
	
	
	//Konstructor
	public Car(String rendszam, int alvazszam, double motor, boolean manualisValto, char uzemanyag, LocalDate gyartasiev) {
		this.rendszam = rendszam;
		this.alvazszam = alvazszam;
		this.motor = motor;
		this.manualisValto = manualisValto;
		this.uzemanyag = uzemanyag;
		this.gyartasiev = gyartasiev;
	}
	
	
	public String getRendszam() {
		return rendszam;
	}

	public void setRendszam(String rendszam) {
		this.rendszam = rendszam;
	}

	public int getAlvazszam() {
		return alvazszam;
	}

	public void setAlvazszam(int alvazszam) {
		this.alvazszam = alvazszam;
	}

	public double getMotor() {
		return motor;
	}

	public void setMotor(double motor) {
		this.motor = motor;
	}

	public boolean isManualisValto() {
		return manualisValto;
	}

	public void setManualisValto(boolean manualisValto) {
		this.manualisValto = manualisValto;
	}

	public char getUzemanyag() {
		return uzemanyag;
	}

	public void setUzemanyag(char uzemanyag) {
		this.uzemanyag = uzemanyag;
	}


	public LocalDate getGyartasiev() {
		return gyartasiev;
	}

	public void setGyartasiev(LocalDate gyartasiev) {
		this.gyartasiev = gyartasiev;
	}
	
	
	public int howOldAmI() {
		int eletkor = 2019-gyartasiev.getYear();
		return eletkor;
	}
	
/*
	@Override
	public String toString() {
		return "Car [rendszam=" + rendszam + ", alvazszam=" + alvazszam + ", motor=" + motor + ", manualisValto="
				+ manualisValto + ", uzemanyag=" + uzemanyag + ", gyartasiev=" + gyartasiev + "]";
	}
*/
	
	
	@Override
	public String toString() {
		return   rendszam + "," 
				+ alvazszam + "," 
				+ motor + ","
				+ manualisValto + ","
				+ uzemanyag + "," 
				+ gyartasiev;
	}
	
	
}
