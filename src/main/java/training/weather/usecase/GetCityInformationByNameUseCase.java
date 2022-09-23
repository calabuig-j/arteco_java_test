package training.weather.usecase;

import training.weather.entities.CityEntity;
import training.weather.interfaces.OnError;
import training.weather.interfaces.OnSuccess;
import training.weather.model.City;
import training.weather.model.GetCityInformationRequest;
import training.weather.repository.interfaces.CityRepository;

public class GetCityInformationByNameUseCase {

    private CityRepository repository;

    public GetCityInformationByNameUseCase(CityRepository repository) {
        this.repository = repository;
    }

    public void invoke(GetCityInformationRequest request, OnSuccess<City> onSuccess, OnError onError) {
        repository.getCityInformation(request, new OnSuccess<CityEntity>() {
            @Override
            public void run(CityEntity model) {
                City city = mapFromCityEntityToCity(model);
                onSuccess.run(city);
            }
        }, onError);
    }

    private City mapFromCityEntityToCity(CityEntity model) {
        return new City(model.getLatt(), model.getLongt());
    }
}
