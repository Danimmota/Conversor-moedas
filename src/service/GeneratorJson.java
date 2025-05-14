package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.CurrencyResponse;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GeneratorJson {

    public static void fileJson(CurrencyResponse currency, String from, String to) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .setPrettyPrinting()
                .create();


        // Frase que irá receber o nome do arquivo com data/hora para evitar sobrescritas
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        // Frase que formará o nome do arquivo
        String fileName = from + "_to_" + to + "_" + timestamp + ".json";

        try (FileWriter written = new FileWriter(fileName)){
            written.write(gson.toJson(currency));
            System.out.println("Arquivo JSON gerado: " + fileName);
        } catch (IOException e) {
            System.out.println("Erro ao gerar o arquivo JSON: " + e.getMessage());
        }
    }

}
