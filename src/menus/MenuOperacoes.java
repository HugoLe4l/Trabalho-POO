package menus;

import classes.Operacao;
import util.Util;

import java.util.Scanner;

import app.App;

public class MenuOperacoes {

    private static Scanner sc = new Scanner(System.in);

    // Área de Registro Operações (Stack)
    public static void exibirMenuOperacoes() {
        while (true) {
            Util.titulo("MENU REGISTRO DE OPERAÇÕES");
            System.out.println("-> Escolha o que deseja fazer.");
            System.out.println(
                    "1.Registrar operação manualmente.\n" +
                            "2.Desfazer última operação.\n" +
                            "3.Listar histórico de operaçõe.\n" +
                            "4.Voltar ao menu principal");
            System.out.print("Digite: ");
            int opcao = Util.LeitorINT();

            switch (opcao) {
                case 1:
                    registrarOperacaoManualmente();
                    break;
                case 2:
                    desfazerRegistro();
                    break;
                case 3:
                    exibirTodasOperacoes();
                    break;
                case 4:
                    break;
                default:
                    Util.notificacao("Negativo", "Opção inválida! Tente novamente.");
                    break;
            }

            if(opcao == 4) { break; }
        }
    }

    private static void registrarOperacaoManualmente() {
        Util.subTitulo("Registrar operação");
        System.out.print("Descreva a operação: ");
        String operacao = sc.nextLine();
        Operacao novaOperacao = new Operacao("MANUAL", operacao);
        MenuOperacoes.registraOperacoes(novaOperacao);
        Util.notificacao("Positivo", "Operação registrada.");
    }

    public static void registraOperacoes(Operacao novaOperacao) {
        App.pilhaOperacoes.push(novaOperacao);
    }

    private static void desfazerRegistro() {
        Util.subTitulo("Desfazer a ultima operação");
        if (App.pilhaOperacoes.empty()) {
            Util.notificacao("Negativo", "Não existe operações para desfazer.");
            return;
        }
        Util.notificacao("Posiivo", "Ultima operação | " + App.pilhaOperacoes.peek() + " | foi desfeita.");
        App.pilhaOperacoes.pop();
    }

    private static void exibirTodasOperacoes() {
        Util.subTitulo("Exibir historico de operações");
        if (App.pilhaOperacoes.isEmpty()) {
            Util.notificacao("Negativo", "Sem registro de operações.");
            return;
        }
        for (Operacao item : App.pilhaOperacoes) {
            System.out.println(item);
        }
    }
    // -----------------------------------------------------
}
