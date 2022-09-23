package training.weather.repository.interfaces;

import training.weather.entities.CityEntity;
import training.weather.interfaces.OnError;
import training.weather.interfaces.OnSuccess;
import training.weather.model.GetCityInformationRequest;

public interface CityRepository {
    void getCityInformation(GetCityInformationRequest request, OnSuccess<CityEntity> onSuccess, OnError onError);
}
