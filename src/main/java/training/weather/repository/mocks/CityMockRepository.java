package training.weather.repository.mocks;

import training.weather.entities.CityEntity;
import training.weather.interfaces.OnError;
import training.weather.interfaces.OnSuccess;
import training.weather.model.GetCityInformationRequest;
import training.weather.repository.interfaces.CityRepository;

public class CityMockRepository implements CityRepository {

    @Override
    public void getCityInformation(GetCityInformationRequest request, OnSuccess<CityEntity> onSuccess, OnError onError) {
        CityEntity cityEntity = new CityEntity("40.42882", 	"-3.64539");
        onSuccess.run(cityEntity);
    }
}
