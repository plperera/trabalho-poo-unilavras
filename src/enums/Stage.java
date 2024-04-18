package src.enums;

public enum Stage {
    BABY("Bebê", 1.0),
    TEENAGER("Adolescente", 1.5),
    ADULT("Adulto", 2.0);

    private final String description;
    private final double growthMultiplier;

    Stage(String description, double growthMultiplier) {
        this.description = description;
        this.growthMultiplier = growthMultiplier;
    }

    public String getDescription() {
        return description;
    }

    public double getGrowthMultiplier() {
        return growthMultiplier;
    }
}
