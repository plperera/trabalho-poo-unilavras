package src.enums;

public enum Disease {
    NONE("None", 1),
    MILD("Mild Disease", 2),
    SEVERE("Severe Disease", 4);

    private final String description;
    private final int lossMultiplier;

    Disease(String description, int lossMultiplier) {
        this.description = description;
        this.lossMultiplier = lossMultiplier;
    }

    public String getDescription() {
        return description;
    }

    public int getLossMultiplier() {
        return lossMultiplier;
    }
}
