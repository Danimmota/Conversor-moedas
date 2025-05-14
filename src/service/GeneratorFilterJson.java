package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.CurrencyResponse;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GeneratorFilterJson {

    public static void fileFilterJson(CurrencyResponse currencyResponse, String baseCode) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .setPrettyPrinting()
                .create();

        // Frase que irá receber o nome do arquivo com data/hora para evitar sobrescritas
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        // Frase que formará o nome do arquivo
        String fileFilterName = "Filtro" + baseCode + timestamp + ".json";

        try (FileWriter written = new FileWriter(fileFilterName)){
            written.write(gson.toJson(currencyResponse));
            System.out.println("Arquivo JSON gerado: " + fileFilterName);
        } catch (IOException e) {
            System.out.println("Erro ao gerar o arquivo JSON: " + e.getMessage());
        }
    }
}
