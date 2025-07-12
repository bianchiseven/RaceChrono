package models;

public class Driver {
    private String name;
    private int skill;
    private double aggression;
    private double fuel;

    public Driver(String name, int skill, double aggression) {
        this.name = name;
        this.skill = skill;
        this.aggression = aggression;
        this.fuel = 100.0;
    }

    public String getName() { return name; }
    public int getSkill() { return skill; }
    public double getAggression() { return aggression; }

    public double getFuel() {
        return fuel;
    }

    public void consumeFuel() {
        fuel -= 1.2 + (aggression * 0.3);
    }
}
