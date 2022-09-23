package training.weather;

import org.junit.Test;
import training.weather.interfaces.OnError;
import training.weather.interfaces.OnSuccess;
import training.weather.model.ErrorModel;

import java.io.IOException;
import java.util.Date;

public class WeatherForecastTest {

	@Test
	public void unfinished_test() throws IOException {
		WeatherForecast forecast = new WeatherForecast();
		forecast.getCityWeather("Madrid", new Date(), new OnSuccess<String>() {
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

	}
}