package training.weather.usecase.mocks;

import training.weather.interfaces.OnError;
import training.weather.interfaces.OnSuccess;
import training.weather.model.GetDailyInformationRequest;
import training.weather.model.WeatherDay;
import training.weather.model.WeatherDaysList;
import training.weather.usecase.interfaces.GetWeatherInformationByLatitudeAndLongitudeUseCase;

import java.time.LocalDate;

public class GetWeatherInformationByLatitudeAndLongitudeMockUseCase
        implements GetWeatherInformationByLatitudeAndLongitudeUseCase {

    public void invoke(GetDailyInformationRequest request, OnSuccess<WeatherDaysList> onSuccess, OnError onError) {
        WeatherDaysList weatherDaysList = new WeatherDaysList();

        WeatherDay day0 = new WeatherDay(LocalDate.now(), 3.0);
        WeatherDay day1 = new WeatherDay(LocalDate.now().plusDays(1), 3.0);
        WeatherDay day2 = new WeatherDay(LocalDate.now().plusDays(2), 3.0);
        WeatherDay day3 = new WeatherDay(LocalDate.now().plusDays(3), 3.0);
        WeatherDay day4 = new WeatherDay(LocalDate.now().plusDays(4), 3.0);
        WeatherDay day5 = new WeatherDay(LocalDate.now().plusDays(5), 61.0);
        WeatherDay day6 = new WeatherDay(LocalDate.now().plusDays(6), 1.0);

        weatherDaysList.add(day0);
        weatherDaysList.add(day1);
        weatherDaysList.add(day2);
        weatherDaysList.add(day3);
        weatherDaysList.add(day4);
        weatherDaysList.add(day5);
        weatherDaysList.add(day6);

        onSuccess.run(weatherDaysList);
    }
}
