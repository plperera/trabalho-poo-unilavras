package src.controllers;

import src.services.PetService;
import src.enums.Status;

public class PetController {
    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    public void feedPet() {
        System.out.println("[+] feeding pet... \n");
        petService.feedPet();
        printPetStatus();
    }

    public void playWithPet() {
        System.out.println("[+] playing with pet... \n");
        petService.playWithPet();
        printPetStatus();
    }

    public void cleanPet() {
        System.out.println("[+] cleaning pet... \n");
        petService.cleanPet();
        printPetStatus();
    }

    public void restPet() {
        System.out.println("[+] resting pet... \n");
        petService.restPet();
        printPetStatus();
    }

    public void showPetStatus() {
        System.out.println("Current Pet Status:");
        for (Status status : Status.values()) {
            System.out.println(" -"+status.getDescription() + ": " + petService.getPet().getStatusValues().get(status));
        }
        System.out.println("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n");
    }

    private void printPetStatus() {
        showPetStatus();
    }
}
