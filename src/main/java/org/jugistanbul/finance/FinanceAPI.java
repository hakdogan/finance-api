package org.jugistanbul.finance;

import io.vertx.core.json.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import static picocli.CommandLine.Command;
import static picocli.CommandLine.Parameters;

/**
 * @author hakdogan (hakdogan75@gmail.com)
 * Created on 14.10.2023
 ***/
@Command(name = "finance-api")
public class FinanceAPI implements Runnable
{

   @Parameters(description = "Currency or precious metal name is mandatory")
   String name;

   @Override
    public void run() {

       try {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://finans.truncgil.com/today.json"))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient
                    .newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            var responseBody = new JsonObject(response.body());
            List<Map.Entry<String, Object>> list = responseBody
                    .stream().filter(p -> p.getKey().contains(name))
                    .toList();

            if(list.isEmpty()){
                System.out.printf("%s not found!%n", name);
                return;
            }

            list.forEach(this::print);

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void print(final Map.Entry<String, Object> entry){
        System.out.printf("%s %s%n", entry.getKey(), entry.getValue());
    }
}
