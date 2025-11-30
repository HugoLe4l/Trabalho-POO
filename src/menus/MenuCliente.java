package menus;

import java.util.Scanner;

import classes.Cliente;
import classes.Operacao;

import util.Util;
import app.App;

public class MenuCliente {

    private static Scanner sc = new Scanner(System.in);

    // Área da Cadastro de Clientes (Lista)
    public static void exibirMenuCliente() {
        while (true) {
            Util.titulo("MENU CLIENTES");
            System.out.println("-> Escolha o que deseja fazer.");
            System.out.println(
                    "1.Cadastrar novo cliente.\n" +
                            "2.Remover cliente pelo ID\n" +
                            "3.Buscar cliente pelo ID\n" +
                            "4.Exibir todos os clientes\n" +
                            "5.Retornar ao menu principal");
            System.out.print("Digite: ");
            int opcao = Util.LeitorINT();

            switch (opcao) {
                case 1:
                    cadastrarNovoCliente();
                    break;

                case 2:
                    deletarCliente();
                    break;

                case 3:
                    exibirClientePeloID();
                    break;

                case 4:
                    exibirTodosOsClientes();
                    break;
                case 5:
                    break;
                default:
                    Util.notificacao("Negativo", "Opção inválida! Tente novamente.");
                    break;
            }

            if (opcao == 5) {
                break;
            }
        }
    }

    private static void cadastrarNovoCliente() {
        Util.subTitulo("Cadastro de NOVO CLIENTE");

        System.out.print("Nome do Cliente: ");
        String nome = sc.nextLine();

        System.out.print("Email do Cliente: ");
        String email = sc.nextLine();

        Cliente novoCliente = new Cliente(nome, email);
        App.listaClientes.add(novoCliente);
        Util.notificacao("Positivo", "Novo cliente '" + nome + "' cadastrado com sucesso!");

        Operacao novOperacao = new Operacao("CREATE",
                "Cadastrou novo cliente [Id: " + novoCliente.getId() + " | Nome: " + nome + "].");
        MenuOperacoes.registraOperacoes(novOperacao);
        Util.tracoFinal();
    }

    private static void exibirTodosOsClientes() {
        Util.subTitulo("Lista com todos os clientes");
        if (App.listaClientes.isEmpty()) {
            Util.notificacao("Negativo", "Não há clientes cadastrados.");
            return;

        }
        for (Cliente c : App.listaClientes) {
            System.out.println(c);
        }

    }

    private static void exibirClientePeloID() {
        Util.subTitulo("Busca de cliente por ID");

        System.out.print("ID do Cliente: ");
        int id = Util.LeitorINT();

        boolean encontrado = false;
        for (Cliente cliente : App.listaClientes) {
            if (cliente.getId() == id) {
                System.out.println(cliente);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            Util.notificacao("Negativo", "Cliente com [ID " + id + "] não foi encontrado.");
        }
        Util.tracoFinal();

    }

    private static void deletarCliente() {
        Util.subTitulo("Deletar CLIENTE");

        System.out.print("ID do Cliente: ");
        int id = Util.LeitorINT();

        boolean encontrado = false;
        for (int i = 0; i < App.listaClientes.size(); i++) {
            if (App.listaClientes.get(i).getId() == id) {
                encontrado = true;

                App.listaClientes.remove(i);
                Util.notificacao("Positivo", "Cliente com ID [Id: " + App.listaClientes.get(i).getId() + " | Nome: "
                        + App.listaClientes.get(i).getNome() + "] foi deletado.");

                Operacao novOperacao = new Operacao("DELETE", "Cliente com ID [Id: " + App.listaClientes.get(i).getId()
                        + " | Nome: " + App.listaClientes.get(i).getNome() + "] foi deletado.");
                MenuOperacoes.registraOperacoes(novOperacao);

                break;

            }
        }
        if (!encontrado) {
            Util.notificacao("Negativo", "Cliente com ID [" + id + "] não foi encontrado.");
            return;
        }

        Util.tracoFinal();

    }
    // -----------------------------------------------------
}
