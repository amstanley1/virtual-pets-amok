package virtualpetsamok;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class VirtualPetShelterTest {
	VirtualPetShelter petShelter;

	@Before
	public void setup() {
		petShelter = new VirtualPetShelter("My Test Pet Shelter");
	}

	@Test
	public void shouldBeAbleToCreateNewPetShelter() {
		VirtualPetShelter shelter = new VirtualPetShelter("My Test Pet Shelter");
	}

	@Test
	public void shouldBeAbleToGetAllPets() {
		Collection<VirtualPet> petsList = petShelter.getAllPets();
		assertTrue(petsList.isEmpty());
	}

	@Test
	public void shouldBeAbleToGetName() {
		assertTrue(petShelter.getName().equals("My Test Pet Shelter"));
	}

	@Test
	public void shouldBeAbleToAddPetsToVirtualPetShelter() {
		VirtualPet organicCat = new OrganicCat("Crookshanks", "a organic cat", 8, 8, 5, 5, 5, 5);
		VirtualPet roboticDog = new RoboticDog("Spot 2.0", "a robotic dog", 8, 4, 4);
		petShelter.addPet(organicCat);
		petShelter.addPet(roboticDog);
		boolean containsOrganicCat = false;
		boolean containsRoboticDog = false;
		for (VirtualPet pet : petShelter.getAllPets()) {
			if (pet.getName().equals("Crookshanks")) {
				containsOrganicCat = true;
			}
			if (pet.getName().equals("Spot 2.0")) {
				containsRoboticDog = true;
			}
		}
		assertTrue(containsOrganicCat);
		assertTrue(containsRoboticDog);
	}

	@Test
	public void shouldBeAbleToRemovePet() {
		VirtualPet organicCat = new OrganicCat("Crookshanks", "a organic cat", 8, 8, 5, 5, 5, 5);
		VirtualPet roboticDog = new RoboticDog("Spot 2.0", "a robotic dog", 8, 4, 4);
		petShelter.addPet(organicCat);
		petShelter.addPet(roboticDog);
		petShelter.removePet("Crookshanks");
		boolean containsOrganicCat = false;
		for (VirtualPet pet : petShelter.getAllPets()) {
			if (pet.getName().equals("Crookshanks")) {
				containsOrganicCat = true;
			}
		}
		assertFalse(containsOrganicCat);
	}

	@Test
	public void shouldBeAbleToGetPet() {
		VirtualPet organicCat = new OrganicCat("Crookshanks", "a organic cat", 8, 8, 5, 5, 5, 5);
		VirtualPet roboticDog = new RoboticDog("Spot 2.0", "a robotic dog", 8, 4, 4);
		petShelter.addPet(organicCat);
		petShelter.addPet(roboticDog);
		VirtualPet crookshanks = petShelter.getPet("Crookshanks");
		boolean containsPet = false;
		assertTrue(crookshanks.getName().equals("Crookshanks"));
	}

	@Test
	public void shouldBeAbleToFeedAllOrganicPets() {
		VirtualPet organicCat = new OrganicCat("Crookshanks", "a organic cat", 8, 8, 5, 5, 5, 5);
		VirtualPet roboticDog = new RoboticDog("Spot 2.0", "a robotic dog", 8, 4, 4);
		VirtualPet organicDog = new OrganicDog("Bob", "a organic dog", 8, 8, 6, 6, 6, 6);
		petShelter.addPet(organicCat);
		petShelter.addPet(roboticDog);
		petShelter.addPet(organicDog);
		int bobHungerLevelBefore = petShelter.getPetHungerLevel(petShelter.getPet("Bob"));
		int crookshanksHungerLevelBefore = petShelter.getPetHungerLevel(petShelter.getPet("Crookshanks"));
		petShelter.feedAllPets(2);
		int bobHungerLevelAfter = petShelter.getPetHungerLevel(petShelter.getPet("Bob"));
		int crookshanksHungerLevelAfter = petShelter.getPetHungerLevel(petShelter.getPet("Crookshanks"));
		assertTrue(bobHungerLevelAfter == bobHungerLevelBefore - 3);
		assertTrue(crookshanksHungerLevelAfter == crookshanksHungerLevelBefore - 3);
	}

	@Test
	public void shouldBeAbleToWaterAllOrganicPets() {
		VirtualPet organicCat = new OrganicCat("Crookshanks", "a organic cat", 8, 8, 5, 5, 5, 5);
		VirtualPet roboticDog = new RoboticDog("Spot 2.0", "a robotic dog", 8, 4, 4);
		VirtualPet organicDog = new OrganicDog("Bob", "a organic dog", 8, 8, 6, 6, 6, 6);
		petShelter.addPet(organicCat);
		petShelter.addPet(roboticDog);
		petShelter.addPet(organicDog);
		int bobThirstLevelBefore = petShelter.getPetThirstLevel(petShelter.getPet("Bob"));
		int crookshanksThirstLevelBefore = petShelter.getPetThirstLevel(petShelter.getPet("Crookshanks"));
		petShelter.waterAllPets();
		int bobThirstLevelAfter = petShelter.getPetThirstLevel(petShelter.getPet("Bob"));
		int crookshanksThirstLevelAfter = petShelter.getPetThirstLevel(petShelter.getPet("Crookshanks"));
		assertTrue(bobThirstLevelAfter == bobThirstLevelBefore - 3);
		assertTrue(crookshanksThirstLevelAfter == crookshanksThirstLevelBefore - 3);
	}

	@Test
	public void shouldBeAbleToPlayWithOrganicPet() {
		VirtualPet organicCat = new OrganicCat("Crookshanks", "a organic cat", 8, 8, 5, 5, 5, 5);
		VirtualPet roboticDog = new RoboticDog("Spot 2.0", "a robotic dog", 8, 4, 4);
		VirtualPet organicDog = new OrganicDog("Bob", "a organic dog", 8, 8, 6, 6, 6, 6);
		petShelter.addPet(organicCat);
		petShelter.addPet(roboticDog);
		petShelter.addPet(organicDog);
		int bobBoredomLevelBefore = petShelter.getPetBoredomLevel(petShelter.getPet("Bob"));
		int bobSleepinessLevelBefore = petShelter.getPetSleepinessLevel(petShelter.getPet("Bob"));
		petShelter.playWithPet("Bob");
		int bobBoredomLevelAfter = petShelter.getPetBoredomLevel(petShelter.getPet("Bob"));
		int bobSleepinessLevelAfter = petShelter.getPetSleepinessLevel(petShelter.getPet("Bob"));
		assertTrue(bobBoredomLevelAfter == bobBoredomLevelBefore - 5);
		assertTrue(bobSleepinessLevelAfter == bobSleepinessLevelBefore + 2);
	}

	@Test
	public void shouldBeAbleToOilAllRoboticPets() {
		VirtualPet organicCat = new OrganicCat("Crookshanks", "a organic cat", 8, 8, 5, 5, 5, 5);
		VirtualPet roboticDog = new RoboticDog("Spot 2.0", "a robotic dog", 8, 4, 4);
		VirtualPet organicDog = new OrganicDog("Bob", "a organic dog", 8, 8, 6, 6, 6, 6);
		VirtualPet roboticCat = new RoboticCat("Salem", "a robotic cat", 8, 3, 6);
		petShelter.addPet(organicCat);
		petShelter.addPet(roboticCat);
		petShelter.addPet(roboticDog);
		petShelter.addPet(organicDog);
		int spot20RustLevelBefore = petShelter.getPetRustLevel(petShelter.getPet("Spot 2.0"));
		int salemRustLevelBefore = petShelter.getPetRustLevel(petShelter.getPet("Salem"));
		petShelter.oilAllRoboticPets();
		int spot20RustLevelAfter = petShelter.getPetRustLevel(petShelter.getPet("Spot 2.0"));
		int salemRustLevelAfter = petShelter.getPetRustLevel(petShelter.getPet("Salem"));
		assertTrue(spot20RustLevelAfter == spot20RustLevelBefore - 4);
		assertTrue(salemRustLevelAfter == salemRustLevelBefore - 4);
	}

	@Test
	public void tickMethodShouldIncrementAndDecrementPropertiesForAllPets() {
		VirtualPet organicCat = new OrganicCat("Crookshanks", "a organic cat", 8, 8, 5, 5, 5, 5);
		VirtualPet roboticDog = new RoboticDog("Spot 2.0", "a robotic dog", 8, 4, 4);
		VirtualPet organicDog = new OrganicDog("Bob", "a organic dog", 8, 8, 6, 6, 6, 6);
		VirtualPet roboticCat = new RoboticCat("Salem", "a robotic cat", 8, 3, 3);
		petShelter.addPet(organicCat);
		petShelter.addPet(roboticCat);
		petShelter.addPet(roboticDog);
		petShelter.addPet(organicDog);
		int bobHungerLevelBefore = petShelter.getPetHungerLevel(petShelter.getPet("Bob"));
		int crookshanksHungerLevelBefore = petShelter.getPetHungerLevel(petShelter.getPet("Crookshanks"));
		int bobThirstLevelBefore = petShelter.getPetThirstLevel(petShelter.getPet("Bob"));
		int crookshanksThirstLevelBefore = petShelter.getPetThirstLevel(petShelter.getPet("Crookshanks"));
		int bobBoredomLevelBefore = petShelter.getPetBoredomLevel(petShelter.getPet("Bob"));
		int crookshanksBoredomLevelBefore = petShelter.getPetBoredomLevel(petShelter.getPet("Crookshanks"));
		int bobSleepinessLevelBefore = petShelter.getPetSleepinessLevel(petShelter.getPet("Bob"));
		int crookshanksSleepinessLevelBefore = petShelter.getPetSleepinessLevel(petShelter.getPet("Crookshanks"));
		int spot20RustLevelBefore = petShelter.getPetRustLevel(petShelter.getPet("Spot 2.0"));
		int salemRustLevelBefore = petShelter.getPetRustLevel(petShelter.getPet("Salem"));
		petShelter.tickAll();
		int bobHungerLevelAfter = petShelter.getPetHungerLevel(petShelter.getPet("Bob"));
		int crookshanksHungerLevelAfter = petShelter.getPetHungerLevel(petShelter.getPet("Crookshanks"));
		int bobThirstLevelAfter = petShelter.getPetThirstLevel(petShelter.getPet("Bob"));
		int crookshanksThirstLevelAfter = petShelter.getPetThirstLevel(petShelter.getPet("Crookshanks"));
		int bobBoredomLevelAfter = petShelter.getPetBoredomLevel(petShelter.getPet("Bob"));
		int crookshanksBoredomLevelAfter = petShelter.getPetBoredomLevel(petShelter.getPet("Crookshanks"));
		int bobSleepinessLevelAfter = petShelter.getPetSleepinessLevel(petShelter.getPet("Bob"));
		int crookshanksSleepinessLevelAfter = petShelter.getPetSleepinessLevel(petShelter.getPet("Crookshanks"));
		int spot20RustLevelAfter = petShelter.getPetRustLevel(petShelter.getPet("Spot 2.0"));
		int salemRustLevelAfter = petShelter.getPetRustLevel(petShelter.getPet("Salem"));
		assertTrue(bobThirstLevelAfter == bobThirstLevelBefore + 1);
		assertTrue(crookshanksThirstLevelAfter == crookshanksThirstLevelBefore + 1);
		assertTrue(bobHungerLevelAfter == bobHungerLevelBefore + 1);
		assertTrue(crookshanksHungerLevelAfter == crookshanksHungerLevelBefore + 1);
		assertTrue(bobBoredomLevelAfter == bobBoredomLevelBefore + 1);
		assertTrue(crookshanksBoredomLevelAfter == crookshanksBoredomLevelBefore + 1);
		assertTrue(bobSleepinessLevelAfter == bobSleepinessLevelBefore + 1);
		assertTrue(crookshanksSleepinessLevelAfter == crookshanksSleepinessLevelBefore + 1);
		assertTrue(spot20RustLevelAfter == spot20RustLevelBefore + 1);
		assertTrue(salemRustLevelAfter == salemRustLevelBefore + 1);
	}

	@Test
	public void shouldBeAbleToCheckIfHasPet() {
		VirtualPet organicCat = new OrganicCat("Crookshanks", "a organic cat", 8, 8, 5, 5, 5, 5);
		VirtualPet roboticDog = new RoboticDog("Spot 2.0", "a robotic dog", 8, 4, 4);
		VirtualPet organicDog = new OrganicDog("Bob", "a organic dog", 8, 8, 6, 6, 6, 6);
		petShelter.addPet(organicCat);
		petShelter.addPet(roboticDog);
		petShelter.addPet(organicDog);
		assertTrue(petShelter.hasPet("Bob"));
		assertTrue(petShelter.hasPet("Crookshanks"));
		assertTrue(petShelter.hasPet("Spot 2.0"));
		assertFalse(petShelter.hasPet("Spot"));
	}

	@Test
	public void shouldBeAbleToGetLitterBoxWasteLevel() {
		VirtualPet organicCat = new OrganicCat("Crookshanks", "a organic cat", 8, 8, 5, 5, 5, 5);
		VirtualPet roboticDog = new RoboticDog("Spot 2.0", "a robotic dog", 8, 4, 4);
		petShelter.addPet(organicCat);
		petShelter.addPet(roboticDog);
		int litterBoxBefore = petShelter.getLitterBoxWasteLevel();
		petShelter.tickAll();
		int litterBoxAfter = petShelter.getLitterBoxWasteLevel();
		assertTrue(litterBoxAfter == litterBoxBefore + 1);
	}

	@Test
	public void shouldBeAbleToCleanLitterBox() {
		VirtualPet organicCat = new OrganicCat("Crookshanks", "a organic cat", 8, 8, 5, 5, 5, 5);
		VirtualPet roboticDog = new RoboticDog("Spot 2.0", "a robotic dog", 8, 4, 4);
		petShelter.addPet(organicCat);
		petShelter.addPet(roboticDog);
		int litterBoxBefore = petShelter.getLitterBoxWasteLevel();
		petShelter.tickAll();
		int litterBoxAfter = petShelter.getLitterBoxWasteLevel();
		assertTrue(litterBoxAfter == litterBoxBefore + 1);
		petShelter.emptyLitterBox();
		int cleanLitterBox = petShelter.getLitterBoxWasteLevel();
		assertTrue(cleanLitterBox == 0);
	}

	@Test
	public void shouldBeAbleToCleanCages() {
		VirtualPet organicCat = new OrganicCat("Crookshanks", "a organic cat", 8, 8, 5, 5, 5, 5);
		VirtualPet roboticDog = new RoboticDog("Spot 2.0", "a robotic dog", 8, 4, 4);
		VirtualPet organicDog = new OrganicDog("Bob", "a organic dog", 8, 8, 6, 6, 6, 6);
		petShelter.addPet(organicCat);
		petShelter.addPet(roboticDog);
		petShelter.addPet(organicDog);
		int cageWasteLevelBefore = petShelter.getCageWasteLevel(petShelter.getPet("Bob"));
		petShelter.tickAll();
		int cageWasteLevelAfter = petShelter.getCageWasteLevel(petShelter.getPet("Bob"));
		assertTrue(cageWasteLevelAfter == cageWasteLevelBefore + 1);
		petShelter.cleanAllCages();
		int cleanCage = petShelter.getCageWasteLevel(petShelter.getPet("Bob"));
		assertTrue(cleanCage == 0);
	}

	@Test
	public void shouldBeAbleToWalkDogs() {
		VirtualPet crookshanks = new OrganicCat("Crookshanks", "a organic cat", 8, 8, 5, 5, 5, 5);
		VirtualPet fluffy = new OrganicDog("Fluffy", "a organic dog", 8, 8, 3, 3, 3, 3);
		VirtualPet spot = new RoboticDog("Spot 2.0", "a robotic dog", 8, 4, 4);
		VirtualPet bob = new OrganicDog("Bob", "another organic dog", 8, 8, 6, 6, 6, 6);
		petShelter.addPet(crookshanks);
		petShelter.addPet(fluffy);
		petShelter.addPet(spot);
		petShelter.addPet(bob);
		int fluffySleepinessLevelBefore = petShelter.getPetSleepinessLevel(petShelter.getPet("Fluffy"));
		int bobSleepinessLevelBefore = petShelter.getPetSleepinessLevel(petShelter.getPet("Bob"));
		petShelter.walkAllDogs();
		int fluffyBoredomLevelAfter = petShelter.getPetBoredomLevel(petShelter.getPet("Fluffy"));
		int bobBoredomLevelAfter = petShelter.getPetBoredomLevel(petShelter.getPet("Bob"));
		int fluffySleepinessLevelAfter = petShelter.getPetSleepinessLevel(petShelter.getPet("Fluffy"));
		int bobSleepinessLevelAfter = petShelter.getPetSleepinessLevel(petShelter.getPet("Bob"));
		assertTrue(fluffyBoredomLevelAfter == 0);
		assertTrue(bobBoredomLevelAfter == 0);
		assertTrue(fluffySleepinessLevelAfter == fluffySleepinessLevelBefore + 2);
		assertTrue(bobSleepinessLevelAfter == bobSleepinessLevelBefore + 2);
	}
}
