package training.weather;

import org.junit.Test;

import java.io.IOException;
import java.util.Date;

public class WeatherForecastTest {

	@Test
	public void unfinished_test() throws IOException {
		String forecast = WeatherForecast.getCityWeather("Madrid", new Date());
		System.out.println(forecast);
	}
}