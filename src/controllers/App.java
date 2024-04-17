package src.controllers;

import src.models.Pet;

public class App {
    public static void main(String[] args) {
        Pet pet = new Pet("Tammy");
        new TamagotchiGUI(pet);
    }
}
