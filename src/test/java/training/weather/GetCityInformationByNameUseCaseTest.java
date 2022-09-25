package training.weather;

import org.junit.Assert;
import org.junit.Test;
import training.weather.interfaces.OnSuccess;
import training.weather.model.City;
import training.weather.model.GetCityInformationRequest;
import training.weather.repository.interfaces.CityRepository;
import training.weather.repository.mocks.CityMockRepository;
import training.weather.usecase.GetCityInformationByNameUseCaseImplementation;

public class GetCityInformationByNameUseCaseTest {
    @Test
    public void testGettingCityByNameIsReturningCoordsLattAndLongt() {

        CityRepository repository = new CityMockRepository();
        GetCityInformationRequest request = new GetCityInformationRequest("Madrid");
        GetCityInformationByNameUseCaseImplementation getCityInformationByNameUseCase = new GetCityInformationByNameUseCaseImplementation(repository);
        getCityInformationByNameUseCase.invoke(request, new OnSuccess<City>() {
            @Override
            public void run(City model) {
                Assert.assertEquals(model.getLatt(), "40.42882");
                Assert.assertEquals(model.getLongt(), "-3.64539");
            }
        }, null);
    }
}
