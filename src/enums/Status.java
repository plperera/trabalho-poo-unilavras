package src.enums;

public enum Status {
    HEALTH("Health"),
    NUTRIENTS("Nutrients"),
    HYGIENE("Hygiene"),
    HAPPINESS("Happiness"),
    SOCIALIZATION("Socialization"),
    LIFESPAN("Lifespan");

    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
