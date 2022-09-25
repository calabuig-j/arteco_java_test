import com.google.api.client.http.javanet.NetHttpTransport;
import training.weather.WeatherForecast;
import training.weather.connection.Http;
import training.weather.interfaces.OnError;
import training.weather.interfaces.OnSuccess;
import training.weather.model.ErrorModel;
import training.weather.repository.CityHttpRepository;
import training.weather.repository.DailyHttpRepository;
import training.weather.repository.interfaces.CityRepository;
import training.weather.repository.interfaces.DailyRepository;
import training.weather.usecase.GetCityInformationByNameUseCaseImplementation;
import training.weather.usecase.GetWeatherInformationByLatitudeAndLongitudeUseCaseImplementation;

public class Main {
    public static void main(String[] args) {
        System.out.println("RETRIEVING INFO...");

        Http http = new Http(new NetHttpTransport().createRequestFactory());

        CityRepository cityRepository = new CityHttpRepository(http);
        GetCityInformationByNameUseCaseImplementation cityInformationByNameUseCase =
                new GetCityInformationByNameUseCaseImplementation(cityRepository);

        DailyRepository dailyRepository = new DailyHttpRepository(http);
        GetWeatherInformationByLatitudeAndLongitudeUseCaseImplementation weatherInformationByLatitudeAndLongitudeUseCase =
                new GetWeatherInformationByLatitudeAndLongitudeUseCaseImplementation(dailyRepository);

        WeatherForecast forecast = new WeatherForecast(cityInformationByNameUseCase,
                weatherInformationByLatitudeAndLongitudeUseCase);

        forecast.getCityWeather("Madrid", null, new OnSuccess<String>() {
            @Override
            public void run(String forecast) {
                System.out.println(forecast);
            }
        }, new OnError() {
            @Override
            public void run(ErrorModel error) {
                System.out.println(error.getMessage());
            }
        });
    }
}
