package org.hibernate.httpcalls;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.dao.SpaceResponse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientCalls {
       private static final String BASE_URL = "http://api.open-notify.org/iss-now.json";

    public static SpaceResponse getSpace() throws Exception {


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(response.body(), SpaceResponse.class);
        } else {
            throw new RuntimeException("Failed: " + response.statusCode());
        }
    }
}
