import classes.Cliente;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

public class App {
    public static ArrayList<Cliente> listaClientes = new ArrayList<>();
    public static Stack<String> pilhaOperacoes = new Stack<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {


        while (true) {

            exibirMenuPrincipal();
            String op1 = sc.nextLine();

            switch (op1) {
                case "1":
                    System.out.println("Escolheu: " + op1);
                    break;

                case "2":
                    System.out.println("Escolheu: " + op1);
                    for(String op : pilhaOperacoes){
                        System.out.println(op);
                    }

                    break;

                case "3":
                    exibirMenuCliente();
                    break;

                case "4":
                    System.out.println("Escolheu: " + op1);
                    break;

                case "5":
                    System.out.println("=== Programa encerrado ===");
                    return;

                default:
                    notificacao("Negativo", "Opção inválida! Tente novamente.");
            }

        }
    }

    public static final String RESET = "\u001B[0m";

    public static final String BLUE = "\u001B[34m";
    public static final String BG_BLUE = "\u001B[44m";

    public static final String RED = "\u001B[31m";
    public static final String BG_RED = "\u001B[41m";

    public static final String GREEN = "\u001B[32m";
    public static final String BG_GREEN = "\u001B[42m";

    public static final String BG_YELLOW = "\u001B[43m";
    public static final String BG_MAGENTA = "\u001B[45m";



    private static void notificacao(String tipo, String mensagem) {
        String BGcolor = GREEN;
        if (tipo == "Negativo") {
            BGcolor = RED;
        }
        System.out.println(BGcolor + mensagem + RESET);
    }

    private static void titulo(String texto){
        System.out.println("\n" + BG_BLUE + "===== "+texto+" =====" + RESET + "\n");
    }
    private static void subTitulo(String texto){
        System.out.println("\n" + BG_MAGENTA + "===== "+texto+" =====" + RESET + "\n");
    }
    private static void tracoFinal(){
        System.out.println("\n"+"-".repeat(60));
    }

    private static void registraLog(String texto){
        pilhaOperacoes.add(texto);
    }


    private static void exibirMenuPrincipal() {
        titulo("MENU PRINCIPAL");
        System.out.println("-> Escolha o que deseja fazer.");
        System.out.println(
                "1.Gerenciar Fila de Chamados.\n" +
                        "2.Gerenciar Pilha de Operações\n" +
                        "3.Gerenciar Lista de Clientes.\n" +
                        "4.Gerenciar Árvore de Serviços.\n" +
                        "5.Sair");
        System.out.print("Digite: ");
    }


    //Área da LISTA
    private static void exibirMenuCliente() {
        titulo("MENU CLIENTES");
        System.out.println("-> Escolha o que deseja fazer.");
        System.out.println(
                "1.Cadastrar novo cliente.\n" +
                        "2.Remover cliente pelo ID\n" +
                        "3.Buscar cliente pelo ID\n" +
                        "4.Exibir todos os clientes\n" +
                        "5.Retornar ao menu principal");
        System.out.print("Digite: ");
        String opcao = sc.nextLine();

        switch (opcao) {
            case "1":
                cadastrarNovoCliente();
                break;

            case "2":
                deletarCliente();
                break;

            case "3":
                exibirClientePeloID();
                break;

            case "4":
                exibirTodosOsClientes();
                break;

            default:
                break;
        }
    }

    private static void cadastrarNovoCliente() {
        subTitulo("Cadastro de NOVO CLIENTE");

        System.out.print("Nome do Cliente: ");
        String nome = sc.nextLine();

        System.out.print("Email do Cliente: ");
        String email = sc.nextLine();

        Cliente novoCliente = new Cliente(nome, email);
        listaClientes.add(novoCliente);
        notificacao("Positivo", "Novo cliente '" + nome + "' cadastrado com sucesso!");

        registraLog("Cadastrou novo cliente ["+nome+"].");
        tracoFinal();
    }

    private static void exibirTodosOsClientes() {
        subTitulo("Lista de CLIENTES CADASTRADOS");
        for (Cliente c : listaClientes) {
            System.out.println(c);
        }
        tracoFinal();
    }

    private static void exibirClientePeloID(){
        subTitulo("Busca de cliente por ID");

        System.out.print("ID do Cliente: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean encontrado = false;
        for(Cliente cliente : listaClientes){
            if (cliente.getId() == id) {
                System.out.println(cliente);
                encontrado = true;
                break;
            }
        }

        if(!encontrado){
            notificacao( "Negativo", "Cliente com [ID "+id+"] não foi encontrado.");
        }
        tracoFinal();

    }

    private static void deletarCliente(){
        subTitulo("Deletar CLIENTE");

        System.out.print("ID do Cliente: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        boolean encontrado = false;
        for(int i=0; i < listaClientes.size(); i++){
            if(listaClientes.get(i).getId() == id){
                 listaClientes.remove(i);
                System.out.println("ID["+id+"] informado foi enconrado e deletado");
                encontrado = true;
                break;

            }
        }
        if(!encontrado){
            notificacao( "Negativo", "Cliente com [ID "+id+"] não foi encontrado.");
        }
        registraLog("Cliente com ID["+id+"] foi deletado.");
        tracoFinal();
   
    }
    //-----------------------------------------------------

}
