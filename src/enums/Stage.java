package src.enums;

public enum Stage {
    BABY("Baby", 1.0),
    TEENAGER("Teenager", 1.5),
    ADULT("Adult", 2.0);

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
