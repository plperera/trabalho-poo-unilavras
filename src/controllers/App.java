package src.controllers;

import src.services.PetService;
import src.models.Pet;
import src.utils.PetClock;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pet pet = new Pet("Tammy");  // Nome do pet
        PetService petService = new PetService(pet);
        PetController petController = new PetController(petService);

        // Inicia a thread do relógio para atualizar o tempo automaticamente
        PetClock clock = new PetClock(pet);
        Thread clockThread = new Thread(clock);
        clockThread.start();

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an action:");
            System.out.println("1: Feed Pet");
            System.out.println("2: Play with Pet");
            System.out.println("3: Clean Pet");
            System.out.println("4: Rest Pet");
            System.out.println("5: Show Pet Status");
            System.out.println("0: Exit");

            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        petController.feedPet();
                        break;
                    case 2:
                        petController.playWithPet();
                        break;
                    case 3:
                        petController.cleanPet();
                        break;
                    case 4:
                        petController.restPet();
                        break;
                    case 5:
                        petController.showPetStatus();
                        break;
                    case 0:
                        System.out.println("Exiting Tamagotchi Game. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid number.");
                        scanner.nextLine();  // Limpa buffer do scanner
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();  // Limpa o buffer de entrada inválido
            }
        }

        // Finaliza a thread do relógio quando o jogo terminar
        clock.stop();
        try {
            clockThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted while waiting for clock to finish.");
        }

        scanner.close();
    }
}