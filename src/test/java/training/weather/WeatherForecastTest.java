package training.weather;

import org.junit.Assert;
import org.junit.Test;
import training.weather.interfaces.OnError;
import training.weather.interfaces.OnSuccess;
import training.weather.model.ErrorModel;
import training.weather.usecase.mocks.GetCityInformationByNameMockUseCase;
import training.weather.usecase.mocks.GetWeatherInformationByLatitudeAndLongitudeMockUseCase;

import java.io.IOException;
import java.util.Date;

public class WeatherForecastTest {

	@Test
	public void unfinished_test(){

		GetCityInformationByNameMockUseCase cityInformationByNameMockUseCase = new GetCityInformationByNameMockUseCase();
		GetWeatherInformationByLatitudeAndLongitudeMockUseCase getWeatherInformationByLatitudeAndLongitudeMockUseCase =
				new GetWeatherInformationByLatitudeAndLongitudeMockUseCase();

		WeatherForecast forecast = new WeatherForecast(cityInformationByNameMockUseCase,
				getWeatherInformationByLatitudeAndLongitudeMockUseCase);
		forecast.getCityWeather("Madrid", new Date(), new OnSuccess<String>() {
			@Override
			public void run(String forecast) {

				Assert.assertEquals(forecast, "Overcast");
			}
		}, null);

	}
}