package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;

public class JetsApplication {
	private AirField airfield;
	
	
	
	public static void main(String[] args) {
		JetsApplication jetApp = new JetsApplication();
		jetApp.run();
	}
		
		
		
		jetApp.readFromFile("jets.txt", ArrayList<String>jetsList);

	public void readFromFile(String fn, List<String> jetsList) {
		try {
			BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"));
			String line;
			while ((line = bufIn.readLine()) != null) {
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		System.out.println("|       8: Remove jett from Fleet        |");
		System.out.println("|       9: Quit                          |");
		System.out.println("------------------------------------------");

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
				addJet();
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
			for(Jet ) {
				
			}
		}

	public void flyAllJets() {
			for(Jet) {
			
		}
	}

	public void viewFastest() {
		for(Jet) {
		
	}
}
	
	public void viewLongestRange() {
		for(Jet) {
		
	}
}
	
	public void loadCargo() {
		for(Jet) {
		
	}
}
	
	public void dogFight() {
		for(Jet) {
		
	}
}
	
	public void addJet() {
		for(Jet) {
		
	}
}
	public void removeJet() {
		for(Jet) {
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
