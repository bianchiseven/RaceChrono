package models;

public class Tire {
    private String type;
    private double wear;

    public Tire(String type) {
        this.type = type;
        this.wear = 0;
    }

    public void simulateLap() {
        double rate = switch (type) {
            case "Soft" -> 7.5;
            case "Medium" -> 5.0;
            case "Hard" -> 3.5;
            default -> 5.0;
        };
        wear += rate;
    }

    public boolean needsPitStop() {
        return wear >= 85;
    }

    public String getType() { return type; }
    public double getWear() { return wear; }
}
