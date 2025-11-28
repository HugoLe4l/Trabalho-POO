import classes.Cliente;
import classes.Operacao;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

public class App {
    public static ArrayList<Cliente> listaClientes = new ArrayList<>();
    public static Stack<Operacao> pilhaOperacoes = new Stack<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Operacao p1 = new Operacao("CREATE", "Usuario Hugo foi criado");
        Operacao p2 = new Operacao("DELETE", "Usuario Hugo foi DELETADO");
        Operacao p3 = new Operacao("CREATE", "Usuario Hugo foi criado");

        pilhaOperacoes.push(p1);
        pilhaOperacoes.push(p2);
        pilhaOperacoes.push(p3);



        while (true) {

            exibirMenuPrincipal();
            String op1 = sc.nextLine();

            switch (op1) {
                case "1":
                    System.out.println("Escolheu: " + op1);
                    break;

                case "2":
                    exibirMenuOperacoes();
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

    
    public static final String BG_BLUE = "\u001B[44m";

    public static final String RED = "\u001B[31m";

    public static final String GREEN = "\u001B[32m";

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

  

    private static void exibirMenuPrincipal() {
        titulo("MENU PRINCIPAL");
        System.out.println("-> Escolha o que deseja fazer.");
        System.out.println(
                "1.Gerenciar Fila de Chamados.\n" +
                        "2.Gerenciar Pilha de Operações.\n" +
                        "3.Gerenciar Lista de Clientes. ( Concluido )\n" +
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
                notificacao("Negativo", "Opção inválida! Tente novamente.");
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

        Operacao novOperacao = new Operacao("DELETE", "Cadastrou novo cliente ["+nome+"].");
        registraOperacoes(novOperacao);
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
                notificacao("Positivo", "Cliente com ID ["+id+"] foi deletado.");
                encontrado = true;
                break;

            }
        }
        if(!encontrado){
            notificacao( "Negativo", "Cliente com ID ["+id+"] não foi encontrado.");
        }

        Operacao novOperacao = new Operacao("DELETE", "Cliente com ID ["+id+"] foi deletado.");
        registraOperacoes(novOperacao);
        tracoFinal();
   
    }
    //-----------------------------------------------------



    //Área de Registro Operações
    private static void exibirMenuOperacoes(){
        titulo("MENU REGISTRO DE OPERAÇÕES");
        System.out.println("-> Escolha o que deseja fazer.");
        System.out.println(
                        "1.Registrar operação manualmente.\n" +
                        "2.Desfazer última operação.\n" +
                        "3.Listar histórico de operaçõe.\n" +
                        "4.Voltar ao menu principal");
        System.out.print("Digite: ");
        String opcao = sc.nextLine();

        switch (opcao) {
            case "1":
                registrarOperacaoManualmente();
                break;
            case "2":
                desfazerRegistro();
                break;
            case "3":
                exibirTodasOperacoes();
                break;
            case "4":
                break;
            default:
                notificacao("Negativo", "Opção inválida! Tente novamente.");
                break;
        }
    }

    private static void registrarOperacaoManualmente(){
        subTitulo("Registrar operação");
        System.out.print("Descreva a operação: ");
        String operacao = sc.nextLine();
        Operacao novaOperacao = new Operacao("MANUAL", operacao);
        registraOperacoes(novaOperacao);
        notificacao("Positivo", "Operação registrada.");
    }
    
    private static void registraOperacoes(Operacao novaOperacao){
        pilhaOperacoes.push(novaOperacao);
    }

    private static void desfazerRegistro(){
        subTitulo("Desfazer a ultima operação");
        if(pilhaOperacoes.empty()) { 
            notificacao("Negativo", "Não existe operações para desfazer.");
            return;
        }
        notificacao("Posiivo", "Ultima operação | "+pilhaOperacoes.peek()+" | foi desfeita.");
        pilhaOperacoes.pop();
    }
    
    private static void exibirTodasOperacoes(){
        subTitulo("Exibir historico de operações");

        for( Operacao item : pilhaOperacoes){
            System.out.println(item);
        }
    }
}
