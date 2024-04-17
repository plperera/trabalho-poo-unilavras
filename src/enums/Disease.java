package src.enums;

public enum Disease {
    NONE("None", 1.0),
    MILD("Mild Disease", 2.0),
    SEVERE("Severe Disease", 4.0);

    private final String description;
    private final double lossMultiplier;

    Disease(String description, double lossMultiplier) {
        this.description = description;
        this.lossMultiplier = lossMultiplier;
    }

    public String getDescription() {
        return description;
    }

    public double getLossMultiplier() {
        return lossMultiplier;
    }
}
