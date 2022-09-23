package training.weather.connection;

public class URLTemplates {

    public static String city = "https://geocode.xyz/%s?json=1";

    public static String forecastPart1 = "https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s";
    public static String forecastPart2 = "&daily=weathercode&current_weather=true&timezone=Europe%2FBerlin";

}
