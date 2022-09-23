package training.weather.model;

public class GetDailyInformationRequest {
    private String latt;
    private String longt;

    public GetDailyInformationRequest(String latt, String longt) {
        this.latt = latt;
        this.longt = longt;
    }

    public String getLatt() {
        return latt;
    }

    public void setLatt(String latt) {
        this.latt = latt;
    }

    public String getLongt() {
        return longt;
    }

    public void setLongt(String longt) {
        this.longt = longt;
    }
}
