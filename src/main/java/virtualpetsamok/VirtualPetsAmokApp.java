package virtualpetsamok;

import java.util.Scanner;

public class VirtualPetsAmokApp {

	public static void main(String[] args) {
		// Create Shelter and add pets
		VirtualPetShelter shelter = new VirtualPetShelter("Ashley's Shelter for Robotic and Organic Cats and Dogs");

		VirtualPet crookshanks = new OrganicCat("Crookshanks", "an organic cat", 6, 7, 4, 5, 6, 5);
		VirtualPet spot20 = new RoboticDog("Spot 2.0", "a robotic dog", 8, 4, 4);
		VirtualPet bob = new OrganicDog("Bob", "a organic dog", 8, 7, 6, 4, 6, 4);
		VirtualPet salem = new RoboticCat("Salem", "a robotic cat", 6, 4, 3);
		VirtualPet charlie = new OrganicCat("Charlie", "an organic cat", 8, 7, 5, 5, 5, 5);
		VirtualPet rover = new RoboticDog("Rover", "a robotic dog", 8, 9, 4);
		VirtualPet fluffy = new OrganicDog("Fluffy", "an organic dog", 5, 8, 8, 6, 7, 6);
		VirtualPet oscar = new RoboticCat("Oscar", "a robotic cat", 7, 6, 3);
		VirtualPet tabitha = new OrganicCat("Tabitha", "an organic cat", 8, 8, 5, 8, 5, 9);
		VirtualPet toto = new OrganicDog("Toto", "an organic dog", 9, 8, 6, 7, 6, 9);
		VirtualPet tigger = new OrganicCat("Tigger", "an organic cat", 8, 6, 5, 7, 5, 9);
		shelter.addPet(crookshanks);
		shelter.addPet(spot20);
		shelter.addPet(bob);
		shelter.addPet(salem);
		shelter.addPet(charlie);
		shelter.addPet(rover);
		shelter.addPet(fluffy);
		shelter.addPet(oscar);
		shelter.addPet(tabitha);
		shelter.addPet(toto);
		shelter.addPet(tigger);

		// Open scanner for user input
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to " + shelter.getName());
		System.out.println("Thank you for volunteering!");
		System.out.println();

		String userSelection = "";
		while (!userSelection.equals("9")) {

			// Print all the pets stats
			System.out.println("Here are your pets:");
			System.out.println();
			System.out.println(shelter.printStats());
			System.out.println("Communal Litterbox Waste Level: " + shelter.getLitterBoxWasteLevel());
			System.out.println();

			// List options and ask user to select one
			System.out.println("1. Feed the organic pets");
			System.out.println("2. Water the organic pets");
			System.out.println("3. Play with a pet");
			System.out.println("4. Walk the dogs");
			System.out.println("5. Oil the robotic pets");
			System.out.println("6. Clean the dog cages");
			System.out.println("7. Clean the communal litterbox");
			System.out.println("8. Do nothing.");
			System.out.println("9. Quit the game.");
			System.out.println("What number do you want to select?");
			userSelection = input.nextLine();

			// Take action depending on user selection

			// Feed all pets
			if (userSelection.equals("1")) {
				shelter.feedAllPets(1);
				System.out.println("You fed the organic pets.");
				System.out.println("Press enter to continue");
				input.nextLine();

				// Water all pets
			} else if (userSelection.equals("2")) {
				shelter.waterAllPets();
				System.out.println("You've watered all the organic pets.");
				System.out.println("Press enter to continue");
				input.nextLine();

				// Play with a pet
			} else if (userSelection.equals("3")) {
				System.out.println(shelter.printNamesAndDescriptions());
				System.out.println("Enter the name of the pet you'd like to play with.");
				String petToPlayWith = input.nextLine();
				if (shelter.hasPet(petToPlayWith)) {
					shelter.playWithPet(petToPlayWith);
					System.out.println("You played with " + petToPlayWith + ". " + petToPlayWith
							+ " is happier.");
				} else {
					System.out.println("That pet is not in the shelter.");
				}
				System.out.println("Press enter to continue");
				input.nextLine();

				// Walk the organic dogs
			} else if (userSelection.equals("4")) {
				shelter.walkAllDogs();
				System.out.println("You walked all the dogs.");
				System.out.println("Press enter to continue");
				input.nextLine();

				// Oil the robotic pets
			} else if (userSelection.equals("5")) {
				shelter.oilAllRoboticPets();
				System.out.println("You oiled all the robotic pets.");
				System.out.println("Press enter to continue");
				input.nextLine();

				// Clean a dog's cage
			} else if (userSelection.equals("6")) {
				shelter.cleanAllCages();
				System.out.println("You cleaned all the organic dog cages.");
				System.out.println("Press enter to continue");
				input.nextLine();

				// Clean the communal litterbox
			} else if (userSelection.equals("7")) {
				shelter.emptyLitterBox();
				System.out.println("You have cleaned the shelter litterbox. The organic cats will be happier and healthier now.");
			}

			// call tick method to pass time in the game
			shelter.tickAll();
		}
		System.out.println("Good bye!");
	}
}
