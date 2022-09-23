package training.weather;

import com.google.api.client.http.javanet.NetHttpTransport;
import training.weather.connection.Http;
import training.weather.exceptions.DayWithoutInfoException;
import training.weather.interfaces.OnError;
import training.weather.interfaces.OnSuccess;
import training.weather.model.*;
import training.weather.repository.CityHttpRepository;
import training.weather.repository.DailyHttpRepository;
import training.weather.repository.interfaces.CityRepository;
import training.weather.repository.interfaces.DailyRepository;
import training.weather.usecase.GetCityInformationByNameUseCase;
import training.weather.usecase.GetWeatherInformationByLatitudeAndLongitudeUseCase;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

public class WeatherForecast {

	public void getCityWeather(String city, Date datetime, OnSuccess<String> onSuccess, OnError onError) {
		Date date = Optional.ofNullable(datetime).orElse(new Date());
		if (checkDaysAfter(date, 6)) {
			Http http = new Http(new NetHttpTransport().createRequestFactory());
			CityRepository cityRepository = new CityHttpRepository(http);
			GetCityInformationByNameUseCase cityInformationByNameUseCase =
					new GetCityInformationByNameUseCase(cityRepository);

			GetCityInformationRequest request = new GetCityInformationRequest(city);
			cityInformationByNameUseCase.invoke(request, new OnSuccess<City>() {
				@Override
				public void run(City cityModel) {
					getForecastInformationByDay(http, cityModel, date, onSuccess, onError);
				}
			}, new OnError() {
				@Override
				public void run(ErrorModel error) {
					System.out.println(error.getMessage());
				}
			});

		}
	}

	public void getForecastInformationByDay(Http http, City cityModel, Date datetime,
												   OnSuccess<String> onSuccess, OnError onError) {
		DailyRepository dailyRepository = new DailyHttpRepository(http);
		GetWeatherInformationByLatitudeAndLongitudeUseCase weatherInformationByLatitudeAndLongitudeUseCase =
				new GetWeatherInformationByLatitudeAndLongitudeUseCase(dailyRepository);

		GetDailyInformationRequest request = new GetDailyInformationRequest(cityModel.getLatt(),
				cityModel.getLongt());

		weatherInformationByLatitudeAndLongitudeUseCase.invoke(request, new OnSuccess<WeatherDaysList>() {
			@Override
			public void run(WeatherDaysList model) {
				try {
					String weatherString = getForecast(model, datetime);
					onSuccess.run(weatherString);
				} catch (DayWithoutInfoException e) {
					onError.run(new ErrorModel(e.getMessage()));
				}
			}
		}, new OnError() {
			@Override
			public void run(ErrorModel error) {
				System.out.println(error.getMessage());
			}
		});
	}

	private String getForecast(WeatherDaysList weatherDaysList, Date datetime) throws DayWithoutInfoException {
		LocalDate transformedDatetime = datetime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return weatherDaysList.getWeatherDays().stream()
			.filter(e -> e.getDay().isEqual(transformedDatetime))
			.map(e -> ForecastEnum.getEnumByCode(e.getWeather().intValue()).getDescription())
			.findFirst().orElseThrow( () -> new DayWithoutInfoException("Day wihtout information"));
	}

	private boolean checkDaysAfter(Date date, int days) {
		int daysTomilisec = 1000 * 60 * 60 * 24 * days;
		Date dateAddDays = new Date(new Date().getTime() + daysTomilisec);
		return date.before(dateAddDays);
	}
}
