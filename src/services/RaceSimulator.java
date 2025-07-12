package services;

import models.*;

public class RaceSimulator {
    private Car car;
    private WeatherService weatherService;

    public RaceSimulator(Car car) {
        this.car = car;
        this.weatherService = new WeatherService();
    }

    public void simulate(int laps) {
        System.out.println("\n🏁 Starting Race Simulation!\n");

        for (int i = 1; i <= laps; i++) {
            System.out.println("[Lap " + i + "/" + laps + "]");

            String weather = weatherService.getWeather();
            Driver driver = car.getDriver();
            Tire tire = car.getTire();

            tire.simulateLap();
            driver.consumeFuel();
            car.checkMechanicalFailure();

            double lapTime = 90 - (driver.getSkill() * 0.3) + (tire.getWear() * 0.1);
            if (weather.equals("Rain")) lapTime += 5;

            System.out.printf("Weather: %s | Lap Time: %.3fs%n", weather, lapTime);
            System.out.printf("Tire: %s | Wear: %.1f%%%n", tire.getType(), tire.getWear());
            System.out.printf("Fuel: %.1fL%n", driver.getFuel());

            if (car.isBroken()) {
                System.out.println("💥 Mechanical failure! " + driver.getName() + " is out of the race.");
                break;
            }

            if (tire.needsPitStop()) {
                System.out.println("🔧 Tire too worn! PIT STOP!");
                tire = new Tire(tire.getType());
                car = new Car(driver, tire);
            }

            if (driver.getFuel() <= 5) {
                System.out.println("⛽ Low fuel! PIT STOP!");
                driver = new Driver(driver.getName(), driver.getSkill(), driver.getAggression());
                car = new Car(driver, tire);
            }

            System.out.println("------------------------------------");
        }

        System.out.println("\n🏁 Race finished.");
    }
}
