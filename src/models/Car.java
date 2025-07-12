package models;

public class Car {
    private Driver driver;
    private Tire tire;
    private boolean broken = false;

    public Car(Driver driver, Tire tire) {
        this.driver = driver;
        this.tire = tire;
    }

    public Driver getDriver() {
        return driver;
    }

    public Tire getTire() {
        return tire;
    }

    public boolean isBroken() {
        return broken;
    }

    public void checkMechanicalFailure() {
        if (Math.random() < 0.02) {
            broken = true;
        }
    }
}
