package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {
	private String model;
	private double speed;
	private int range;
	private long price;

	public FighterJet() {
	}

	public FighterJet(String model, double speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	@Override
	public void fly() {
		System.out.println("Model: " + model + " " + "Speed: " + speed + " " + "Range: " + range + " " + "Price: " + price);
		double flightTime = range / speed;
		System.out.println("This jet can fly for " + flightTime + " more hours.");
	}

	@Override
	public void fight() {
		System.out.println("Ready to fight, seeking targets!");
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "FighterJet [model=" + model + ", speed=" + speed + ", range=" + range + ", price=" + price + "]";
	}

}
