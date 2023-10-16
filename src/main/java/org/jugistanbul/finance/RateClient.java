package org.jugistanbul.finance;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author hakdogan (hakdogan75@gmail.com)
 * Created on 15.10.2023
 ***/
public class RateClient
{

    record ResponseWrapper(int statusCode, String response){}

    private static final String SERVICE_URL = "https://finans.truncgil.com/today.json";

    private RateClient(){}

    public static ResponseWrapper query(){

        try {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(SERVICE_URL))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient
                    .newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new ResponseWrapper(response.statusCode(), response.body());

        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("This thread was interrupted...");
        }
    }
}
