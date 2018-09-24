package virtualpetsamok;

import java.util.Scanner;

public class VirtualPetsAmokApp {

	public static void main(String[] args) {
		//Create Shelter and add pets
		VirtualPetShelter shelter = new VirtualPetShelter("Ashley's Shelter for Robotic and Organic Cats and Dogs");
		
		VirtualPet organicCat = new OrganicCat("Crookshanks", "a organic cat", 8, 8, 5, 5, 5, 5);
		VirtualPet roboticDog = new RoboticDog("Spot 2.0", "a robotic dog", 8, 4, 4);
		VirtualPet organicDog = new OrganicDog("Bob", "a organic dog", 8, 8, 6, 6, 6, 6);
		VirtualPet roboticCat = new RoboticCat("Salem", "a robotic cat", 8, 3, 3);
		VirtualPet organicCat2 = new OrganicCat("Charlie", "a organic cat", 8, 8, 5, 5, 5, 5);
		VirtualPet roboticDog2 = new RoboticDog("Rover", "a robotic dog", 8, 4, 4);
		VirtualPet organicDog2 = new OrganicDog("Fluffy", "a organic dog", 8, 8, 6, 6, 6, 6);
		VirtualPet roboticCat2 = new RoboticCat("Oscar", "a robotic cat", 8, 3, 3);
		VirtualPet organicCat3 = new OrganicCat("Tabitha", "a organic cat", 8, 8, 5, 5, 5, 5);
		VirtualPet organicDog3 = new OrganicDog("Toto", "a organic dog", 8, 8, 6, 6, 6, 6);
		VirtualPet organicCat4 = new OrganicCat("Tigger", "a organic cat", 8, 8, 5, 5, 5, 5);
		shelter.addPet(organicCat);
		shelter.addPet(roboticCat);
		shelter.addPet(roboticDog);
		shelter.addPet(organicDog);
		shelter.addPet(organicCat2);
		shelter.addPet(roboticCat2);
		shelter.addPet(roboticDog2);
		shelter.addPet(organicDog2);
		shelter.addPet(organicDog3);
		shelter.addPet(organicCat3);
		shelter.addPet(organicCat4);
		
	
	
	Scanner input = new Scanner(System.in);

	
	
	System.out.println("Welcome to " + shelter.getName());
	System.out.println("Thank you for volunteering!");

	String userSelection = "";
	while (!userSelection.equals("11")) {

		// Print all the pets stats
		System.out.println("Here are your pets:");
		System.out.println(shelter.printStats());
		System.out.println("Communal Litterbox Waste Level: " + shelter.getLitterBoxWasteLevel());
		System.out.println();
		
		// List options and ask user to select one
		System.out.println("1. Take in a new pet");
		System.out.println("2. Adopt out a pet");
		System.out.println("3. Feed the organic pets");
		System.out.println("4. Water the organic pets");
		System.out.println("5. Play with the organic pets");
		System.out.println("6. Walk the organic dogs");
		System.out.println("7. Oil the robotic pets");
		System.out.println("8. Clean the dog cages");
		System.out.println("9. Clean the communal litterbox");
		System.out.println("10. Do nothing.");
		System.out.println("11. Quit the game.");
		System.out.println("What number do you want to select?");
		userSelection = input.nextLine();
		
		if (userSelection.equals("1")) {
			System.out.println("Enter the new pet's name");
			String newPetName = input.nextLine();
			System.out.println("Enter a description for the new pet");
			String newPetDescription = input.nextLine();
			System.out.println("Cat or dog?");
			String newPetSpecies = input.nextLine();
			System.out.println("Robotic or Organic?");
			String newPetType = input.nextLine();
			VirtualPet newPet = null;
			if (newPetSpecies.toLowerCase().equals("cat")) {
				if (newPetType.toLowerCase().equals("robotic")) {
					newPet = new RoboticCat(newPetName, newPetDescription, 8,8,5);
					shelter.addPet(newPet);
				} else if (newPetType.toLowerCase().equals("organic")) {
					newPet = new OrganicCat(newPetName, newPetDescription, 8,8,5,5,5,5);
					shelter.addPet(newPet);
				}
			} else if (newPetSpecies.toLowerCase().equals("dog")) {
				if (newPetType.toLowerCase().equals("robotic")) {
					newPet = new RoboticDog(newPetName, newPetDescription, 8,8,5);
					shelter.addPet(newPet);
				} else if (newPetType.toLowerCase().equals("organic")) {
					newPet = new OrganicDog(newPetName, newPetDescription, 8,8,5,5,5,5);
					shelter.addPet(newPet);
				}
			}
			System.out.println(shelter.getPetName(newPet) + " is now part of the shelter.");
			System.out.println("Press enter to continue");
			input.nextLine();
	} else if (userSelection.equals("2")) {
		System.out.println(shelter.printNamesAndDescriptions());
		System.out.println("Enter the name of the pet that will be adopted out.");
		String petToBeAdoptedOut = input.nextLine();
		if (shelter.hasPet(petToBeAdoptedOut)) {
			shelter.removePet(petToBeAdoptedOut);
			System.out.println(petToBeAdoptedOut + " has been adopted.");
		} else {
			System.out.println("That pet is not in the shelter.");
		}

		System.out.println("Press enter to continue");
		input.nextLine();
	} else if (userSelection.equals("3")) {
		shelter.feedAllPets(1);
		System.out.println("You fed the organic pets.");
		System.out.println("Press enter to continue");
		input.nextLine();
	} else if (userSelection.equals("4")) {
		shelter.waterAllPets();
		System.out.println("You've watered all the organic pets.");
		System.out.println("Press enter to continue");
		input.nextLine();
	} else if (userSelection.equals("5")) {
		System.out.println(shelter.printNamesAndDescriptions());
		System.out.println("Enter the name of the pet you'd like to play with.");
		String petToPlayWith = input.nextLine();
		if (shelter.hasPet(petToPlayWith)) {
			if (shelter.getPet(petToPlayWith) instanceof Organic) {
			shelter.playWithPet(petToPlayWith);
			System.out.println("You played with " + petToPlayWith + ". " + petToPlayWith
					+ " is less bored now, but more tired.");
			} else {
				System.out.println("That pet is a robot, please choose an organic pet.");
			}
		} else {
			System.out.println("That pet is not in the shelter.");
		}
		System.out.println("Press enter to continue");
		input.nextLine();
	} else if (userSelection.equals("6")) {
		shelter.walkAllDogs();
		System.out.println("You walked all the organic dogs. They are less bored now, but more tired.");
		System.out.println("Press enter to continue");
		input.nextLine();
	} else if (userSelection.equals("7")) {
		shelter.oilAllPets();
		System.out.println("You oiled all the organic pets.");
		System.out.println("Press enter to continue");
		input.nextLine();
	} else if (userSelection.equals("8")) {
		System.out.println("Enter the name of the dog whose cage you'd like to clean.");
		String petName = input.nextLine();
		if (shelter.hasPet(petName)) {
			if (shelter.getPet(petName) instanceof OrganicDog) {
			shelter.cleanDogCage(petName);
			System.out.println("You cleaned " + petName + "'s cage. " + petName
					+ " is happier and healthier now.");
			} else {
				System.out.println("That pet does not have a cage, please choose an organic dog.");
			}
		} else {
			System.out.println("That pet is not in the shelter.");
		}
		System.out.println("Press enter to continue");
		input.nextLine();
	} else if (userSelection.equals("9")) {
		shelter.cleanLitterBox();
		System.out.println("You have cleaned the shelter litterbox. The cats will be happier and healthier now.");
	}
		// call tick method to pass time in the game
		shelter.tickAll();
		
}
}
	}
