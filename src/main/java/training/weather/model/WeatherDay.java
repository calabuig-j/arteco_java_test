package training.weather.model;

import java.time.LocalDate;

public class WeatherDay {
    private LocalDate day;
    private Double weather;

    public WeatherDay(LocalDate day, Double weather) {
        this.day = day;
        this.weather = weather;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public Double getWeather() {
        return weather;
    }

    public void setWeather(Double weather) {
        this.weather = weather;
    }


}
