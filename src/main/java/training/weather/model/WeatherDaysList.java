package training.weather.model;

import java.util.ArrayList;
import java.util.List;

public class WeatherDaysList {
    private List<WeatherDay> weatherDays;

    public WeatherDaysList() {
        this.weatherDays = new ArrayList<>();
    }

    public WeatherDaysList(List<WeatherDay> weatherDays) {
        this.weatherDays = weatherDays;
    }

    public List<WeatherDay> getWeatherDays() {
        return weatherDays;
    }

    public void setWeatherDays(List<WeatherDay> weatherDays) {
        this.weatherDays = weatherDays;
    }

    public void add(WeatherDay weatherDay) {
        weatherDays.add(weatherDay);
    }
}
