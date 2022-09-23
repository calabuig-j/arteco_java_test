package training.weather.model;

public class GetCityInformationRequest {
    private String cityName;

    public GetCityInformationRequest(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
