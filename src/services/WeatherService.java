package services;

import java.util.Random;

public class WeatherService {
    private String condition = "Dry";
    private Random rand = new Random();

    public String getWeather() {
        if (rand.nextInt(100) < 10) {
            condition = "Rain";
        } else if (rand.nextInt(100) < 90) {
            condition = "Dry";
        }
        return condition;
    }
}
