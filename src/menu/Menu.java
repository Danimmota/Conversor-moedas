package menu;

public class Menu {
    public static void menu() {
        System.out.println("**********************************************" +
                "\n\nSeja bem vindo/a ao Conversor de Moedas!!" +
                "\n----------------------------------------------" +
                "\nEscolha o número referente a operação desejada:" +
                "\n----------------------------------------------" +
                "\n\n1) Dólar ->> Peso argentino" +
                "\n2) Peso argentino ->> Dólar" +
                "\n3) Dólar ->> Real brasileiro" +
                "\n4) Real brasileiro ->> Dólar" +
                "\n5) Dólar ->> Euro" +
                "\n6) Euro ->> Dólar" +
                "\n7) Ver histórico de conversões" +
                "\n8) Filtrar moeda" +
                "\n9) Sair" +
                "\n\n**********************************************");
    }
    public static void menuCoin() {
        System.out.println("----------------------------------------------" +
                "\n\nCódigo da moeda | Nome da Moeda" +
                "\n  BRL           | Real brasileiro" +
                "\n  USD           | Dólar americano" +
                "\n  CAD           | Dólar canadense" +
                "\n  ARS           | Peso argentino" +
                "\n  CLP           | Peso chileno" +
                "\n  EUR           | Euro" +
                "\n\n----------------------------------------------");
    }
}
