package org.jugistanbul.finance;

import io.vertx.core.json.JsonObject;
import java.util.List;
import java.util.Map;

import static picocli.CommandLine.Command;
import static picocli.CommandLine.Parameters;

/**
 * @author hakdogan (hakdogan75@gmail.com)
 * Created on 14.10.2023
 ***/
@Command(name = "finance-api", mixinStandardHelpOptions = true,
         description         = "Finance API returns the rates of currency or precious metal type that matches the passed name to it from a public service.",
         version             = "Finance API version 1.0",
         footer              = "Copyright (c) 2021")
public class FinanceAPI implements Runnable
{

   @Parameters(description = "Currency or precious metal name is mandatory")
   String name;

   @Override
   public void run() {

       String response = RateClient.query();
       var responseBody = new JsonObject(response);

       List<Map.Entry<String, Object>> list = responseBody
               .stream().filter(p -> p.getKey().contains(name))
               .toList();

       if(list.isEmpty()){
           System.out.printf("%s not found!%n", name);
           return;
       }

       list.forEach(this::print);
    }

    private void print(final Map.Entry<String, Object> entry){
        System.out.printf("%s %s%n", entry.getKey(), entry.getValue());
    }
}
