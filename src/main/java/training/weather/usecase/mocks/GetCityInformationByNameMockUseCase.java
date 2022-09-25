package training.weather.usecase.mocks;

import training.weather.interfaces.OnError;
import training.weather.interfaces.OnSuccess;
import training.weather.model.City;
import training.weather.model.GetCityInformationRequest;
import training.weather.usecase.interfaces.GetCityInformationByNameUseCase;

public class GetCityInformationByNameMockUseCase implements GetCityInformationByNameUseCase {

    @Override
    public void invoke(GetCityInformationRequest request, OnSuccess<City> onSuccess, OnError onError) {
        City city = new City("40.42882", "-3.64539");
        onSuccess.run(city);
    }
}
