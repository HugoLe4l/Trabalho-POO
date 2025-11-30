package menus;

import java.util.Scanner;

import classes.Chamado;
import classes.Operacao;

import util.Util;
import app.App;

public class MenuFilaChamada {
    private static Scanner sc = new Scanner(System.in);

    // Área de Chamados (Fila)
    public static void exibirMenuFilaChamadas() {
        while (true) {
            Util.titulo("MENU FILA DE CHAMADAS");
            System.out.println("-> Escolha o que deseja fazer.");
            System.out.println(
                    "1.Inserir novo chamado.\n" +
                            "2.Atender próximo chamado.\n" +
                            "3.Listar fila de espera.\n" +
                            "4.Voltar ao menu principal");
            System.out.print("Digite: ");
            int opcao = Util.LeitorINT();

            switch (opcao) {
                case 1:
                    inserirChamada();
                    break;
                case 2:
                    atenderProximoFila();
                    break;
                case 3:
                    listarFilaDeEspera();
                    break;
                case 4:
                    break;
                default:
                    Util.notificacao("Negativo", "Opção inválida! Tente novamente.");
                    break;
            }
            if (opcao == 4) {
                break;
            }
        }
    }

    private static void inserirChamada() {
        Util.subTitulo("Inserir chamada na fila");
        if (App.listaClientes.isEmpty()) {
            Util.notificacao("Negativo", "Não possuimos clientes cadastrados para colocar na fila");
            return;
        }

        System.out.print("Digite o ID do Cliente: ");
        int id = Util.LeitorINT();

        boolean encontrado = false;
        for (int i = 0; i < App.listaClientes.size(); i++) {
            if (App.listaClientes.get(i).getId() == id) {
                encontrado = true;
                System.out.print("Descrição do Problema: ");
                String descricao = sc.nextLine();
                Chamado novoChamado = new Chamado(App.listaClientes.get(i).getId(), App.listaClientes.get(i).getNome(),
                        descricao);
                App.filaChamados.add(novoChamado);
                Util.notificacao("Positivo",
                        "O Cliente " + App.listaClientes.get(i).getNome() + " foi adicionado a fila de chamada.");
                Operacao novOperacao = new Operacao("CREATE",
                        "Cliente " + App.listaClientes.get(i).getNome() + " foi adicionado fila de chamada.");
                MenuOperacoes.registraOperacoes(novOperacao);
                break;
            }
        }
        if (!encontrado) {
            Util.notificacao("Negativo", "Cliente com ID [" + id + "] não foi encontrado.");
            return;
        }

    }

    private static void atenderProximoFila() {
        Util.subTitulo("Atender proximo da fila de chamada");
        if (App.filaChamados.isEmpty()) {
            Util.notificacao("Negativo", "Fila de chamada está vazia.");
            return;
        }
        Util.notificacao("Positivo", "Cliente " + App.filaChamados.peek().getNomeCliente() + " foi atendido.");

        Operacao novOperacao = new Operacao("CREATE",
                "Cliente " + App.filaChamados.peek().getNomeCliente() + " foi atendido.");
        MenuOperacoes.registraOperacoes(novOperacao);

        App.filaChamados.remove();
        System.out.println("Tamanho da fila: " + App.filaChamados.size());
    }

    private static void listarFilaDeEspera() {
        Util.subTitulo("Exibir lista de espera");
        if (App.filaChamados.isEmpty()) {
            Util.notificacao("Negativo", "Fila de Espera está vazia");
            return;
        }
        for (Chamado fila : App.filaChamados) {
            System.out.println(fila);
        }
    }
    // -----------------------------------------------------
}
