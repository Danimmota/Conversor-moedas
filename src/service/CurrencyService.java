package service;

import model.CurrencyResponse;
import menu.Menu;
import java.util.Scanner;

public class CurrencyService {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int desiredOperation; //variável para receber a operação desejada

        do {
            Menu.menu(); //chama o menu inicial
            desiredOperation = scanner.nextInt();
            scanner.nextLine(); // consome a quebra de linha restante do nextInt()

            String from = "";
            String to = "";

            switch (desiredOperation) {
                case 1 -> {from = "USD"; to = "ARS";
                }
                case 2 -> {from = "ARS"; to = "USD";
                }
                case 3 -> {from = "USD"; to = "BRL";
                }
                case 4 -> {from = "BRL"; to = "USD";
                }
                case 5 -> {from = "USD"; to = "EUR";
                }
                case 6 -> {from = "EUR"; to = "USD";
                }
                case 7 -> {
                    //retorna uma lista do historico de arquivos gerados e retorna para o loop
                    GeneratorJson.listHistory();
                    continue;
                }
                case 8 -> {
                    System.out.println("Opções disponíveis para filtrar: ");
                    Menu.menuCoin(); //chama o menu de opcoes para realizar o filtro
                }
                case 9 -> {
                    System.out.println("Obrigado por utilizar o conversor!");
                }
                default -> {
                    // validação de entrada
                    System.out.println("Opção inválida! Escolha uma operação conforme o menu.");
                    continue;
                }
            }

            if (!from.isEmpty() && !to.isEmpty()) {
                System.out.println("----------------------------------------------" +
                        "\nVocê escolheu converter: " + from + " ->> " + to);
            }

            if (desiredOperation >= 1 && desiredOperation <= 6) {
                System.out.print("\nAgora digite o valor que deseja converter: ");
                double value = scanner.nextDouble(); // variável para receber o valor que será convertido

                CurrencyResponse currency = Converter.currencyConverter(from, to, value);
                if (currency != null && currency.result().equals("success")) {
                    System.out.printf("----------------------------------------------" +
                            "\nValor convertido: %.2f %s -> %.2f %s",value, from, currency.conversionResult(), to);

                    GeneratorJson.fileJson(currency, from, to);
                } else {
                    System.out.println("Erro ao realizar conversão.");
                }
            }
            if (desiredOperation == 8) {
                System.out.print("Digite o código da moeda que deseja filtrar: ");
                String baseCode = scanner.nextLine(); // variável para receber a moeda a ser filtrada

                CurrencyResponse currencyResponse = Converter.filterCurrency(baseCode);
                if (currencyResponse != null && currencyResponse.result().equals("success")) {

                    System.out.println("----------------------------------------------" +
                            "\nFiltro " + currencyResponse);

                    GeneratorJson.fileFilterJson(currencyResponse, baseCode);
                } else {
                    System.out.println("Erro ao filtrar moeda");
                }
            }

        } while (desiredOperation != 9);

        scanner.close();
    }
}
