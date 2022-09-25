package training.weather.usecase.interfaces;

import training.weather.interfaces.OnError;
import training.weather.interfaces.OnSuccess;
import training.weather.model.GetDailyInformationRequest;
import training.weather.model.WeatherDaysList;

public interface GetWeatherInformationByLatitudeAndLongitudeUseCase {
    public void invoke(GetDailyInformationRequest request, OnSuccess<WeatherDaysList> onSuccess, OnError onError);
}
