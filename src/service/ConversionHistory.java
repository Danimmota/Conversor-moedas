package service;

import java.io.File;

public class ConversionHistory {

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
