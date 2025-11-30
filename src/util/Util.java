package util;

import java.util.Scanner;

public class Util {
    public static Scanner sc = new Scanner(System.in);

    public static final String RESET = "\u001B[0m";

    public static final String BG_BLUE = "\u001B[44m";

    public static final String RED = "\u001B[31m";

    public static final String GREEN = "\u001B[32m";

    public static final String BG_MAGENTA = "\u001B[45m";

    public static void notificacao(String tipo, String mensagem) {
        String BGcolor = GREEN;
        if (tipo == "Negativo") {
            BGcolor = RED;
        }
        System.out.println(BGcolor + mensagem + RESET);
    }

    public static void titulo(String texto) {
        System.out.println("\n" + BG_BLUE + "===== " + texto + " =====" + RESET + "\n");
    }

    public static void subTitulo(String texto) {
        System.out.println("\n" + BG_MAGENTA + "===== " + texto + " =====" + RESET + "\n");
    }

    public static void tracoFinal() {
        System.out.println("\n" + "-".repeat(60));
    }

    public static int LeitorINT() {
        while (true) {
            try {
                String linha = sc.nextLine();
                return Integer.parseInt(linha.trim());
            } catch (NumberFormatException e) {
                Util.notificacao("Negativo", "Valor Inserido é inválido! Tente novamente com numeros inteiros.");
                System.out.print("Digite novamente: ");
            }
        }
    }
}
