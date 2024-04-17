package src.utils;

import src.models.Pet;
import src.enums.Status;

import java.util.Random;

public class RandomEvents {
    private static final Random random = new Random();

    public static void triggerRandomEvent(Pet pet) {
        if (random.nextDouble() < 0.1) { // 10% chance of a random event
            String eventMessage = "";
            switch (random.nextInt(5)) { // Assuming 5 different types of events
                case 0:
                    increaseHealth(pet);
                    eventMessage = "Evento aleatório: O pet encontrou um lugar calmo e se sentiu muito melhor!";
                    break;
                case 1:
                    decreaseHealth(pet);
                    eventMessage = "Evento aleatório: O pet tropeçou e se machucou um pouco.";
                    break;
                case 2:
                    increaseHappiness(pet);
                    eventMessage = "Evento aleatório: O pet encontrou um novo brinquedo e está muito feliz!";
                    break;
                case 3:
                    spoilFood(pet);
                    eventMessage = "Evento aleatório: A comida do pet se estragou, e ele ficou um pouco triste.";
                    break;
                case 4:
                    findToy(pet);
                    eventMessage = "Evento aleatório: O pet encontrou um novo brinquedo!";
                    break;
                default:
                    break;
            }
            if (!eventMessage.isEmpty()) {
                System.out.println(eventMessage);
                System.out.println("Status atualizado do Pet:");
                for (Status status : Status.values()) {
                    System.out.println(" -" + status.getDescription() + ": " + pet.getStatusValues().get(status));
                }
                System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - \n");
            }
        }
    }

    private static void increaseHealth(Pet pet) {
        pet.updateStatus(Status.HEALTH, 10);
    }

    private static void decreaseHealth(Pet pet) {
        pet.updateStatus(Status.HEALTH, -15);
    }

    private static void increaseHappiness(Pet pet) {
        pet.updateStatus(Status.HAPPINESS, 10);
    }

    private static void spoilFood(Pet pet) {
        pet.updateStatus(Status.NUTRIENTS, -10);
    }

    private static void findToy(Pet pet) {
        pet.updateStatus(Status.HAPPINESS, 15);
    }
}
