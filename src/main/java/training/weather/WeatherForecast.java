package training.weather;

import training.weather.exceptions.DayWithoutInfoException;
import training.weather.interfaces.OnError;
import training.weather.interfaces.OnSuccess;
import training.weather.model.*;
import training.weather.usecase.GetCityInformationByNameUseCaseImplementation;
import training.weather.usecase.GetWeatherInformationByLatitudeAndLongitudeUseCaseImplementation;
import training.weather.usecase.interfaces.GetCityInformationByNameUseCase;
import training.weather.usecase.interfaces.GetWeatherInformationByLatitudeAndLongitudeUseCase;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

public class WeatherForecast {

	private GetCityInformationByNameUseCase cityInformationByNameUseCase;
	private GetWeatherInformationByLatitudeAndLongitudeUseCase weatherInformationByLatitudeAndLongitudeUseCase;

	public WeatherForecast(GetCityInformationByNameUseCase cityInformationByNameUseCase,
						   GetWeatherInformationByLatitudeAndLongitudeUseCase weatherInformationByLatitudeAndLongitudeUseCase) {
		this.cityInformationByNameUseCase = cityInformationByNameUseCase;
		this.weatherInformationByLatitudeAndLongitudeUseCase = weatherInformationByLatitudeAndLongitudeUseCase;
	}

	public void getCityWeather(String city, Date datetime, OnSuccess<String> onSuccess, OnError onError) {
		Date date = Optional.ofNullable(datetime).orElse(new Date());
		if (checkDaysAfter(date, 6)) {
			GetCityInformationRequest request = new GetCityInformationRequest(city);
			cityInformationByNameUseCase.invoke(request, new OnSuccess<City>() {
				@Override
				public void run(City cityModel) {
					getForecastInformationByDay(cityModel, date, onSuccess, onError);
				}
			}, new OnError() {
				@Override
				public void run(ErrorModel error) {
					System.out.println(error.getMessage());
				}
			});

		}
	}

	public void getForecastInformationByDay(City cityModel, Date datetime,
												   OnSuccess<String> onSuccess, OnError onError) {
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
