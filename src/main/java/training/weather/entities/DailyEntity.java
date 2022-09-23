package training.weather.entities;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.util.List;

public class DailyEntity {
    private List<LocalDate> time;
    @SerializedName("weathercode")
    private List<Double> weatherCode;

    public DailyEntity(List<LocalDate> time, List<Double> weatherCode) {
        this.time = time;
        this.weatherCode = weatherCode;
    }

    public List<LocalDate> getTime() {
        return time;
    }

    public void setTime(List<LocalDate> time) {
        this.time = time;
    }

    public List<Double> getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(List<Double> weatherCode) {
        this.weatherCode = weatherCode;
    }
}
