package training.weather.repository.mocks;

import training.weather.entities.DailyEntity;
import training.weather.entities.DailyResponse;
import training.weather.interfaces.OnError;
import training.weather.interfaces.OnSuccess;
import training.weather.model.GetDailyInformationRequest;
import training.weather.repository.interfaces.DailyRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DailyWeatherMockRepository implements DailyRepository {
    @Override
    public void getWeatherInformation(GetDailyInformationRequest request, OnSuccess<DailyEntity> onSuccess, OnError onError) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<LocalDate> days = new ArrayList<>();
        days.add(LocalDate.now());
        days.add(LocalDate.now().plusDays(1));
        days.add(LocalDate.now().plusDays(2));
        days.add(LocalDate.now().plusDays(3));
        days.add(LocalDate.now().plusDays(4));
        days.add(LocalDate.now().plusDays(5));
        days.add(LocalDate.now().plusDays(6));

        List<Double> weathercode = new ArrayList<>();
        weathercode.add(3.0);
        weathercode.add(3.0);
        weathercode.add(3.0);
        weathercode.add(3.0);
        weathercode.add(3.0);
        weathercode.add(61.0);
        weathercode.add(1.0);

        DailyEntity dailyEntity = new DailyEntity(days, weathercode);
        onSuccess.run(dailyEntity);
    }
}
