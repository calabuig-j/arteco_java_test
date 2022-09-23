package training.weather.repository;

import com.google.gson.Gson;
import training.weather.connection.Http;
import training.weather.connection.URLTemplates;
import training.weather.entities.CityEntity;
import training.weather.interfaces.OnError;
import training.weather.interfaces.OnSuccess;
import training.weather.model.ErrorModel;
import training.weather.model.GetCityInformationRequest;
import training.weather.repository.interfaces.CityRepository;

import java.io.IOException;

public class CityHttpRepository implements CityRepository {
    private Http http;

    public CityHttpRepository(Http http) {
        this.http = http;
    }

    @Override
    public void getCityInformation(GetCityInformationRequest request, OnSuccess<CityEntity> onSuccess, OnError onError) {
        try {
            String response = http.get(String.format(URLTemplates.city, request.getCityName()));
            CityEntity cityEntity = new Gson().fromJson(response,CityEntity.class);
            onSuccess.run(cityEntity);

        } catch (IOException e) {
            onError.run(new ErrorModel(e.getMessage()));
        }
    }
}
