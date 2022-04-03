package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.CargoCarrier;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.CombatReady;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.PassengerJet;

public class JetsApplication {
	private AirField airfield;

	public static void main(String[] args) {

		JetsApplication jetApp = new JetsApplication();
		jetApp.run();
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		createAirField();
		menuChoice(sc);
	}

	public void displayMenu() {
		System.out.println("------------------------------------------");
		System.out.println("|             Menu                       |");
		System.out.println("|       1: List all jets                 |");
		System.out.println("|       2: Fly all jets                  |");
		System.out.println("|       3: View fastest jet              |");
		System.out.println("|       4: View jet with longest range   |");
		System.out.println("|       5: Load all Cargo Jets           |");
		System.out.println("|       6: Dogfight!                     |");
		System.out.println("|       7: Add a jet to Fleet            |");
		System.out.println("|       8: Remove jet from Fleet         |");
		System.out.println("|       9: Quit                          |");
		System.out.println("------------------------------------------");

	}

	public void createAirField() {
		this.airfield = new AirField();
		String line;
		try {
			BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"));
			{
				while ((line = bufIn.readLine()) != null) {
					String[] jetInfo = line.split(",");
					Jet jet = jetBuilder(jetInfo);
					if (jet != null) {
						this.airfield.addJet(jet);
					}

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Jet jetBuilder(String[] jetInfo) {
		String typeOfJet = jetInfo[0];
		String modelOfJet = jetInfo[1];
		double speedOfJet = Double.parseDouble(jetInfo[2]);
		int rangeOfJet = Integer.parseInt(jetInfo[3]);
		long priceOfJet = Long.parseLong(jetInfo[4]);
		if (typeOfJet.equals("Cargo")) {
			CargoPlane jet = new CargoPlane(modelOfJet, speedOfJet, rangeOfJet, priceOfJet);
			return jet;
		} else if (typeOfJet.equals("FighterJet")) {
			FighterJet jet = new FighterJet(modelOfJet, speedOfJet, rangeOfJet, priceOfJet);
			return jet;
		} else if (typeOfJet.equals("PassengerJet")) {
			PassengerJet jet = new PassengerJet(modelOfJet, speedOfJet, rangeOfJet, priceOfJet);
			return jet;
		} else {
			Jet jet = null;
			return jet;
		}
	}

	private void placeJetInAirField() {

	}

	private boolean menuChoice(Scanner input) {
		Scanner menuInput = input;
		boolean keepDisplaying = true;
		while (keepDisplaying) {
			displayMenu();
			int selection = menuInput.nextInt();
			switch (selection) {
			case 1:
				allJets();
				break;
			case 2:
				flyAllJets();
				break;
			case 3:
				viewFastest();
				break;
			case 4:
				viewLongestRange();
				break;
			case 5:
				loadCargo();
				break;
			case 6:
				dogFight();
				break;
			case 7:
				addCustomJet();
				break;
			case 8:
				removeJet();
				break;
			case 9:
				System.out.println("Exiting, Thank you!");
				return false;
			default:
				System.out.println("Please enter a valid option. Enter 1-9");
				break;
			}
		}
		return keepDisplaying;
	}

	public void allJets() {
		for (Jet jet : this.airfield.getJets()) {
			System.out.println(jet.toString());
		}
	}

	public void flyAllJets() {
		for (Jet jet : this.airfield.getJets()) {
			jet.fly();
		}
	}

	public void viewFastest() {
		double maxSpeed = 0;
		Jet fastestJet = null;
		for (Jet jet : this.airfield.getJets()) {
			if (jet.getSpeed() > maxSpeed) {
				maxSpeed = jet.getSpeed();
				fastestJet = jet;
			}
		}
		if (fastestJet != null) {
			System.out.println("The fastest jet is: " + fastestJet.toString());
		} else {
			System.out.println("Cant find the fastest jet");
		}
	}

	public void viewLongestRange() {
		int maxRange = 0;
		Jet longestRange = null;
		for (Jet jet : this.airfield.getJets()) {
			if (jet.getRange() > maxRange) {
				maxRange = jet.getRange();
				longestRange = jet;
			}
		}
		if (longestRange != null) {
			System.out.println("The jet with the longest range: " + longestRange.toString());
		} else {
			System.out.println("Cant find jet with longest range");
		}
	}

	public void loadCargo() {
		for (Jet jet : this.airfield.getJets()) {
			if (jet instanceof CargoCarrier) {
				System.out.println(jet.toString());
				((CargoCarrier) jet).loadCargo();
			}

		}
	}

	public void dogFight() {
		for (Jet jet : this.airfield.getJets()) {
			if (jet instanceof CombatReady) {
				System.out.println(jet.toString());
				((CombatReady) jet).fight();
			}
		}
	}

	public void addCustomJet() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter a jet type: Cargo, FighterJet, or PassengerJet.");
		String type = sc.nextLine();
		if (type.equals("Cargo")) {
			System.out.println("Enter jet model: ");
			String model = sc.nextLine();

			System.out.println("Enter jet speed: ");
			double speed = sc.nextDouble();

			System.out.println("Enter jet range: ");
			int range = sc.nextInt();

			System.out.println("Enter jet price: ");
			long price = sc.nextLong();
			airfield.addJet(new CargoPlane(model, speed, range, price));
			System.out.println("Jet created: " + "Model: " + model + " " + "Speed: " + speed + " " + "Range: " + range
					+ " " + "Price: " + price);

		} else if (type.equals("FighterJet")) {
			System.out.println("Enter jet model: ");
			String model = sc.nextLine();

			System.out.println("Enter jet speed: ");
			double speed = sc.nextDouble();

			System.out.println("Enter jet range: ");
			int range = sc.nextInt();

			System.out.println("Enter jet price: ");
			long price = sc.nextLong();
			airfield.addJet(new FighterJet(model, speed, range, price));
			System.out.println("Jet created: " + "Model: " + model + " " + "Speed: " + speed + " " + "Range: " + range
					+ " " + "Price: " + price);

		} else if (type.equals("PassengerJet")) {
			System.out.println("Enter jet model: ");
			String model = sc.nextLine();

			System.out.println("Enter jet speed: ");
			double speed = sc.nextDouble();

			System.out.println("Enter jet range: ");
			int range = sc.nextInt();

			System.out.println("Enter jet price: ");
			long price = sc.nextLong();
			airfield.addJet(new PassengerJet(model, speed, range, price));
			System.out.println("Jet created: " + "Model: " + model + " " + "Speed: " + speed + " " + "Range: " + range
					+ " " + "Price: " + price);

		}

	}

	public void removeJet() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Which jet do you want to delete?");
		int index = 1;
		for (Jet jet : this.airfield.getJets()) {
			System.out.println(index++ + ": " + jet.toString());
		}
		System.out.println("Select a jet number to remove from the list");
		index = sc.nextInt();
		airfield.getJets().remove(index - 1);
		System.out.println("Jet has been removed");
}
	
}
