package training.weather;

import org.junit.Assert;
import org.junit.Test;
import training.weather.interfaces.OnSuccess;
import training.weather.model.GetDailyInformationRequest;
import training.weather.model.WeatherDaysList;
import training.weather.repository.interfaces.DailyRepository;
import training.weather.repository.mocks.DailyWeatherMockRepository;
import training.weather.usecase.GetWeatherInformationByLatitudeAndLongitudeUseCaseImplementation;


public class GetWeatherInformationByLatitudeAndLongitudeUseCaseTest {

    @Test
    public void GetWeatherInformationBySendingLatitudeAndLongitudeTest() {
        DailyRepository repository = new DailyWeatherMockRepository();
        GetDailyInformationRequest request = new GetDailyInformationRequest("40.4375", "-3.6875");
        GetWeatherInformationByLatitudeAndLongitudeUseCaseImplementation useCase = new GetWeatherInformationByLatitudeAndLongitudeUseCaseImplementation(repository);
        useCase.invoke(request, new OnSuccess<WeatherDaysList>() {
            @Override
            public void run(WeatherDaysList model) {
                Assert.assertEquals(ForecastEnum.getEnumByCode(model.getWeatherDays().get(0).getWeather().intValue()).getDescription(),"Overcast");
            }
        }, null);

    }
}
