import models.*;
import services.*;

public class App {
    public static void main(String[] args) {
        Driver driver = new Driver("Max Rocha", 92, 0.8);
        Tire tire = new Tire("Medium");
        Car car = new Car(driver, tire);

        RaceSimulator simulator = new RaceSimulator(car);
        simulator.simulate(20);
    }
}
