package src.services;

import src.models.Pet;
import src.enums.Status;
import src.utils.RandomEvents;

public class PetService {
    private Pet pet;

    public PetService(Pet pet) {
        this.pet = pet;
    }

    public void feedPet() {
        pet.updateStatus(Status.NUTRIENTS, 10);
        pet.updateStatus(Status.HEALTH, 5);
        pet.updateStatus(Status.HYGIENE, -2);
        pet.updateStatus(Status.LIFESPAN, 1);
        RandomEvents.triggerRandomEvent(pet);
    }

    public void playWithPet() {
        pet.updateStatus(Status.HAPPINESS, 15);
        pet.updateStatus(Status.SOCIALIZATION, 10);
        pet.updateStatus(Status.HEALTH, -5);
        pet.updateStatus(Status.HYGIENE, -5);
        pet.updateStatus(Status.LIFESPAN, 1);
        RandomEvents.triggerRandomEvent(pet);
    }

    public void cleanPet() {
        pet.updateStatus(Status.HYGIENE, 20);
        pet.updateStatus(Status.SOCIALIZATION, -5);
        pet.updateStatus(Status.HEALTH, -5);
        pet.updateStatus(Status.HAPPINESS, -5);
        pet.updateStatus(Status.LIFESPAN, 1);
        RandomEvents.triggerRandomEvent(pet);
    }

    public void restPet() {
        pet.updateStatus(Status.HEALTH, 10);
        pet.updateStatus(Status.HAPPINESS, 5);
        pet.updateStatus(Status.SOCIALIZATION, -5);
        pet.updateStatus(Status.LIFESPAN, 2);
        RandomEvents.triggerRandomEvent(pet);
    }

    public void printPetStatus() {
        System.out.println("Pet Status:");
        for (Status status : Status.values()) {
            System.out.println(status.getDescription() + ": " + pet.getStatusValues().get(status));
        }
    }

    public void updateStatusAutomatically() {
        pet.updateStatus(Status.NUTRIENTS, -1);
        pet.updateStatus(Status.HAPPINESS, -1);
        pet.updateStatus(Status.HEALTH, -1);
        pet.updateStatus(Status.HYGIENE, -1);
        pet.updateStatus(Status.SOCIALIZATION, -1);
        pet.updateStatus(Status.LIFESPAN, 1);
        RandomEvents.triggerRandomEvent(pet);
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
