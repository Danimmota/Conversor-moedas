package service;

import com.google.gson.Gson;
import model.CurrencyResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Converter {

    public static CurrencyResponse currencyConverter(String from, String to, double value) {

        String apiKey = "f24a511d36d9ba1d01b5ef19";
        String endpoint = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + from + "/" + to + "/" + value;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                return new Gson().fromJson(responseBody, CurrencyResponse.class);
            } else {
                System.out.println("Erro da API: código " + response.statusCode());
                return null;
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao consultar a API" + e.getMessage());
        }
    }

    public static CurrencyResponse filterCurrency (String baseCode) {

        String apiKey = "f24a511d36d9ba1d01b5ef19";
        String endpoint = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCode;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .GET()
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();
                return new Gson().fromJson(responseBody, CurrencyResponse.class);
            } else {
                System.out.println("Erro da API: código " + response.statusCode());
                return null;
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao consultar a API" + e.getMessage());
        }
    }
}
