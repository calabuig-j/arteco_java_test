package training.weather.usecase;

import training.weather.entities.DailyEntity;
import training.weather.interfaces.OnError;
import training.weather.interfaces.OnSuccess;
import training.weather.model.GetDailyInformationRequest;
import training.weather.model.WeatherDay;
import training.weather.model.WeatherDaysList;
import training.weather.repository.interfaces.DailyRepository;
import training.weather.usecase.interfaces.GetWeatherInformationByLatitudeAndLongitudeUseCase;

public class GetWeatherInformationByLatitudeAndLongitudeUseCaseImplementation implements GetWeatherInformationByLatitudeAndLongitudeUseCase {

    private DailyRepository repository;

    public GetWeatherInformationByLatitudeAndLongitudeUseCaseImplementation(DailyRepository dailyRepository) {
        this.repository = dailyRepository;
    }

    public void invoke(GetDailyInformationRequest request, OnSuccess<WeatherDaysList> onSuccess, OnError onError) {
        repository.getWeatherInformation(request, new OnSuccess<DailyEntity>() {
            @Override
            public void run(DailyEntity model) {
                WeatherDaysList weatherDaysList = dailyEntityToWeatherDaysListMapper(model);
                onSuccess.run(weatherDaysList);
            }
        }, onError);
    }


    public WeatherDaysList dailyEntityToWeatherDaysListMapper (DailyEntity dailyEntity) {
        WeatherDaysList resultList = new WeatherDaysList();
        for (int i = 0; i < dailyEntity.getTime().size(); i++) {
            resultList.add(new WeatherDay(dailyEntity.getTime().get(i),dailyEntity.getWeatherCode().get(i)));
        }
        return resultList;
    }
}
