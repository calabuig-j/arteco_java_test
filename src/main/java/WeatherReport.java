import training.weather.WeatherForecast;
import training.weather.interfaces.OnError;
import training.weather.interfaces.OnSuccess;
import training.weather.model.ErrorModel;

import java.util.Date;

public class WeatherReport {
    public static void main(String[] args) {
        System.out.println("---GETTING INFORMATION---");
        WeatherForecast forecast = new WeatherForecast();
        forecast.getCityWeather("Madrid", null, new OnSuccess<String>() {
            @Override
            public void run(String forecast) {
                System.out.println(forecast);
            }
        }, new OnError() {
            @Override
            public void run(ErrorModel error) {
                System.out.println(error.getMessage());
            }
        });
        System.out.println("---END GETTING INFORMATION---");
    }
}
