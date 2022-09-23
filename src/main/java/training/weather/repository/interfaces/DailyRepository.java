package training.weather.repository.interfaces;

import training.weather.entities.DailyEntity;
import training.weather.interfaces.OnError;
import training.weather.interfaces.OnSuccess;
import training.weather.model.GetDailyInformationRequest;

public interface DailyRepository {
    void getWeatherInformation(GetDailyInformationRequest request, OnSuccess<DailyEntity> onSuccess, OnError onError);
}
