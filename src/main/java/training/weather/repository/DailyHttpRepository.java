package training.weather.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import training.weather.adapters.LocalDateAdapter;
import training.weather.connection.Http;
import training.weather.connection.URLTemplates;
import training.weather.entities.DailyEntity;
import training.weather.entities.DailyResponse;
import training.weather.interfaces.OnError;
import training.weather.interfaces.OnSuccess;
import training.weather.model.ErrorModel;
import training.weather.model.GetDailyInformationRequest;
import training.weather.repository.interfaces.DailyRepository;

import java.io.IOException;
import java.time.LocalDate;

public class DailyHttpRepository implements DailyRepository {
    private Http http;

    public DailyHttpRepository(Http http) {
        this.http = http;
    }
    @Override
    public void getWeatherInformation(GetDailyInformationRequest request, OnSuccess<DailyEntity> onSuccess, OnError onError) {
        try {
            String response = http.get(
                    String.format(URLTemplates.forecastPart1,request.getLatt(), request.getLongt())
                    + URLTemplates.forecastPart2);

            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
            DailyResponse dailyResponse = gson.fromJson(response, DailyResponse.class);
            onSuccess.run(dailyResponse.getDaily());

        } catch (IOException e) {
            onError.run(new ErrorModel(e.getMessage()));
        }
    }
}
