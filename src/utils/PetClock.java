package src.utils;

import src.enums.Status;
import src.models.Pet;

public class PetClock implements Runnable {
    private Pet pet;
    private boolean running = true;

    public PetClock(Pet pet) {
        this.pet = pet;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(5000);  // 1000 ms = 1 segundo
                System.out.println("\n[+] tempo passando... \n");
                pet.updateStatus(Status.NUTRIENTS, -1);
                pet.updateStatus(Status.HAPPINESS, -1);
                pet.updateStatus(Status.HEALTH, -1);
                pet.updateStatus(Status.HYGIENE, -1);
                pet.updateStatus(Status.SOCIALIZATION, -1);
                pet.updateStatus(Status.LIFESPAN, 1);
                System.out.println("Current Pet Status:");
                for (Status status : Status.values()) {
                    System.out.println(" -"+status.getDescription() + ": " + pet.getStatusValues().get(status));
                }
                System.out.println("-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  \n");
                System.out.println("\nChoose an action:");
                System.out.println("1: Feed Pet");
                System.out.println("2: Play with Pet");
                System.out.println("3: Clean Pet");
                System.out.println("4: Rest Pet");
                System.out.println("5: Show Pet Status");
                System.out.println("0: Exit");

                System.out.print("Enter your choice: ");
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Clock was interrupted.");
            }
        }
    }

    public void stop() {
        running = false;
    }
}
