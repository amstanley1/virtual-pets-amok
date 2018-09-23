package virtualpetsamok;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {
	int STARTING_WASTE_LEVEL = 0;
	String name;
	int litterBoxWasteLevel = STARTING_WASTE_LEVEL;
	
	Map<String, VirtualPet> pets;

	// Accessors
	public Collection<VirtualPet> getAllPets() {
		return pets.values();
	}

	public String getName() {
		return name;
	}

	public VirtualPet getPet(String name) {
		return pets.get(name);
	}
	
	public int getPetHungerLevel(VirtualPet pet) {
		if (pet instanceof Organic) {
			return ((Organic) pet).getHungerLevel();
		}
		return -1;
	}
	
	public int getPetThirstLevel(VirtualPet pet) {
		if (pet instanceof Organic) {
			return ((Organic) pet).getThirstLevel();
		}
		return -1;
	}
	
	public int getPetBoredomLevel(VirtualPet pet) {
		if (pet instanceof Organic) {
			return ((Organic) pet).getBoredomLevel();
		}
		return -1;
	}
	
	public int getPetSleepinessLevel(VirtualPet pet) {
		if (pet instanceof Organic) {
			return ((Organic) pet).getSleepinessLevel();
		}
		return -1;
	}
	
	public int getPetOilLevel(VirtualPet pet) {
		if (pet instanceof Robotic) {
			return ((Robotic) pet).getOilLevel();
		}
		return -1;
	}
	
	public int getLitterBoxWasteLevel() {
		return litterBoxWasteLevel;
	}
	
	public int getCageWasteLevel(VirtualPet pet) {
		if (pet instanceof OrganicDog) {
			return ((OrganicDog) pet).getCageWasteLevel();
		}
		return -1;
	}

	// Constructor
	public VirtualPetShelter(String name) {
		this.name = name;
		pets = new HashMap<String, VirtualPet>();
	}

	// Add pet
	public void addPet(VirtualPet pet) {
		pets.put(pet.getName(), pet);
	}


	// Remove pet
	public void removePet(String name) {
		pets.remove(name);
	}
	

	// feed all pets
	public void feedAllPets(int userSelectedFood) {
		Collection<VirtualPet> petsCollection = pets.values();
		for (VirtualPet pet : petsCollection) {
			if(pet instanceof Organic) {
				((Organic)pet).feed(userSelectedFood);
			}
		}
	}

	// water all pets
	public void waterAllPets() {
		Collection<VirtualPet> petsCollection = pets.values();
		for (VirtualPet pet : petsCollection) {
			if(pet instanceof Organic) {
				((Organic)pet).water();
			}
		}
	}

	// Play with specific pet
	public void playWithPet(String name) {
		VirtualPet pet = this.getPet(name);
		if(pet instanceof Organic) {
			((Organic)pet).playWith();
		}
	}
	
	// Oil specific pet
		public void oilPet(String name) {
			VirtualPet pet = this.getPet(name);
			if(pet instanceof Robotic) {
				((Robotic)pet).oil();
			}
		}
		
	//Clean litterbox
		public void cleanLitterBox() {
			litterBoxWasteLevel = 0;
		}
		
	//Clean a dog's cage
		public void cleanDogCage(String name) {
			VirtualPet pet = this.getPet(name);
			if(pet instanceof OrganicDog) {
				((OrganicDog)pet).cleanCage();
			}
		}
	
	//walk dogs
		public void walkAllDogs() {
			Collection<VirtualPet> petsCollection = pets.values();
			for (VirtualPet pet : petsCollection) {
				if(pet instanceof OrganicDog) {
					((OrganicDog)pet).walk();
				}
			}
		}

	// call tick on all pets to move time in game
	public void tickAll() {
		Collection<VirtualPet> petsCollection = pets.values();
		for (VirtualPet pet : petsCollection) {
			pet.tick();
			if (pet instanceof Organic) {
				litterBoxWasteLevel += 1;
			}
		}
	}
	
/*
	// Return stats for each pet as a formatted String
	public String printStats() {
		String statsString = String.format("%-10s%-10s%-10s%-10s%-12s%-10s%-10s%n", "Name", "|Hunger", "|Thirst",
				"|Boredom", "|Sleepiness", "|Location", "|State");
		statsString += String.format("%-10s%-10s%-10s%-10s%-12s%-10s%-10s%n", "----------", "|---------", "|---------",
				"|---------", "|-----------", "|---------", "|---------");

		Collection<VirtualPet> petsCollection = pets.values();
		for (VirtualPet pet : petsCollection) {
			statsString += String.format("%-10s%-10s%-10s%-10s%-12s", pet.getName(), "|" + pet.getHungerLevel(),
					"|" + pet.getThirstLevel(), "|" + pet.getBoredomLevel(), "|" + pet.getSleepinessLevel());

			if (pet.getIsInPasture()) {
				statsString += String.format("%-10s", "|Pasture");
			} else {
				statsString += String.format("%-10s", "|Barn");
			}
			if (pet.getIsAsleep()) {
				statsString += String.format("%-10s%n", "|Asleep");
			} else {
				statsString += String.format("%-10s%n", "|Awake");
			}
		}
		return statsString;
	}
*/
	// Return name and description for each pet as formatted String
	public String printNamesAndDescriptions() {
		Collection<VirtualPet> petsCollection = pets.values();
		String petsString = String.format("%-10s%-50s%n", "Name", "Description");
		for (VirtualPet pet : petsCollection) {
			petsString += String.format("%-10s%-50s%n", pet.getName(), "|" + pet.getDescription());
		}
		return petsString;
	}

	
	// Check if Map has specific pet
	public boolean hasPet(String name) {
		VirtualPet pet = pets.get(name);
		boolean hasPet;
		if (pet == null) {
			hasPet = false;
		} else {
			hasPet = true;
		}
		return hasPet;
	}
}
