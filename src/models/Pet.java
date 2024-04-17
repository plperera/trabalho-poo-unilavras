package src.models;

import src.enums.Disease;
import src.enums.Stage;
import src.enums.Status;

import java.util.EnumMap;
import java.util.Map;

public class Pet {
    private String name;
    private Stage stage;
    private Disease currentDisease;
    private EnumMap<Status, Integer> statusValues;

    public Pet(String name) {
        this.name = name;
        this.stage = Stage.BABY;
        this.currentDisease = Disease.NONE;
        this.statusValues = new EnumMap<>(Status.class);
        initializeStatus();
    }

    private void initializeStatus() {
        for (Status status : Status.values()) {
            statusValues.put(status, 50);
        }
    }

    public void updateStatus(Status status, int change) {
        int currentValue = statusValues.getOrDefault(status, 0);
        int newValue = Math.max(currentValue + change, 0); // Ensure no negative values
        int maxValue = calculateMaxValue(status);
        statusValues.put(status, Math.min(newValue, maxValue)); // Ensure value does not exceed maximum

        checkForStageUpdate();
        checkForDiseaseEffects();

        // Verifica se o Pet morreu após a atualização do status
        checkForDeath();
    }

    private int calculateMaxValue(Status status) {
        return switch (status) {
            case HEALTH, NUTRIENTS -> 100 * (int) stage.getGrowthMultiplier();
            default -> 100; // All other statuses have a maximum of 100
        };
    }

    private void checkForStageUpdate() {
        int age = statusValues.getOrDefault(Status.LIFESPAN, 0);
        if (age >= 500) {
            stage = Stage.ADULT;
        } else if (age >= 100) {
            stage = Stage.TEENAGER;
        }
    }

    private void checkForDiseaseEffects() {
        if (statusValues.get(Status.HYGIENE) < 20 || statusValues.get(Status.HAPPINESS) < 20) {
            currentDisease = Disease.MILD;
        } else {
            currentDisease = Disease.NONE;
        }
        applyDiseaseEffects();
    }

    private void applyDiseaseEffects() {
        if (currentDisease != Disease.NONE) {
            int healthLoss = (int) (10 * currentDisease.getLossMultiplier());
            updateStatus(Status.HEALTH, -healthLoss);
            System.out.println("O pet adquiriu uma doença: " + currentDisease.getDescription() + "! Saúde diminuiu.");
        }
    }

    public void checkForDeath() {
        if (statusValues.get(Status.HEALTH) <= 0 || statusValues.get(Status.NUTRIENTS) <= 0 || statusValues.get(Status.HYGIENE) <= 0) {
            System.out.println("\n[+] O pet morreu... \n");
            System.out.println("Relatório final:");
            for (Status status : Status.values()) {
                System.out.println(" -" + status.getDescription() + ": " + statusValues.get(status));
            }
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - \n");
            System.out.println("O jogo terminou. Obrigado por jogar!");
            System.exit(0); // Encerra o jogo
        }
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stage getStage() {
        return stage;
    }

    public Disease getCurrentDisease() {
        return currentDisease;
    }

    public Map<Status, Integer> getStatusValues() {
        return statusValues;
    }
}
