package training.weather.entities;

public class DailyResponse {
    private DailyEntity daily;

    public DailyResponse(DailyEntity daily) {
        this.daily = daily;
    }

    public DailyEntity getDaily() {
        return daily;
    }

    public void setDaily(DailyEntity daily) {
        this.daily = daily;
    }
}
