package training.weather.connection;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;

import java.io.IOException;

public class Http {
    private  HttpRequestFactory rf;

    public Http(HttpRequestFactory rf) {
        this.rf = rf;
    }

    public String get(String url) throws IOException {
        HttpRequest req = rf.buildGetRequest(new GenericUrl(url));
        return req.execute().parseAsString();
    }
}
