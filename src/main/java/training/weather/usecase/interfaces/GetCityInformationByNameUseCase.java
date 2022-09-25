package training.weather.usecase.interfaces;

import training.weather.interfaces.OnError;
import training.weather.interfaces.OnSuccess;
import training.weather.model.City;
import training.weather.model.GetCityInformationRequest;

public interface GetCityInformationByNameUseCase {
    public void invoke(GetCityInformationRequest request, OnSuccess<City> onSuccess, OnError onError);
}
