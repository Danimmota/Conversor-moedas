package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.CurrencyResponse;

import java.io.File;
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


        // Data/hora para evitar sobrescritas
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        // Nome do arquivo
        String fileName = from + "_to_" + to + "_" + timestamp + ".json";

        try (FileWriter written = new FileWriter(fileName)){
            written.write(gson.toJson(currency));
            
            System.out.println("\n----------------------------------------------" +
                    "\n- Arquivo JSON gerado: " + fileName);
        } catch (IOException e) {
            System.out.println("Erro ao gerar o arquivo JSON: " + e.getMessage());
        }
    }

    public static void fileFilterJson(CurrencyResponse currencyResponse, String baseCode) {

        Gson gson = new GsonBuilder()
                .setLenient()
                .setPrettyPrinting()
                .create();

        // Data/hora para evitar sobrescritas no nome do arquivo
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        // Nome do arquivo
        String fileFilterName = "Filtro" + baseCode + timestamp + ".json";

        try (FileWriter written = new FileWriter(fileFilterName)){
            written.write(gson.toJson(currencyResponse));

            System.out.println("\n----------------------------------------------" +
                    "\n- Arquivo JSON gerado: " + fileFilterName);
        } catch (IOException e) {
            System.out.println("Erro ao gerar o arquivo JSON: " + e.getMessage());
        }
    }

    //metodo para listar os arquivos .json salvos no diretório atual do projeto
    public static void listHistory(){
        File currentFile = new File(".");

        File[] arquivos = currentFile.listFiles((dir, name) -> name.endsWith(".json"));

        if (arquivos == null || arquivos.length == 0) {
            System.out.println("Nenhuma conversão encontrada.");
            return;
        }

        System.out.println("Histórico de conversões salvas:");
        for (File arquivo : arquivos) {
            System.out.println("- " + arquivo.getName());
        }
    }

}
