package org.hibernate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SpaceRespond {
    private static final String API_KEY = "c6ba5ab0fcb6f46d2d9ef4e5f084dbf8";  // Replace with your API key
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

    public static SpaceRespond getSpace(double lat, double lon) throws Exception {
        String url = String.format("%s?lat=%f&lon=%f&appid=%s", BASE_URL, lat, lon, API_KEY);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return  null;
    }
}