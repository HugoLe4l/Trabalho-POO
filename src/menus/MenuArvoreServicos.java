package menus;

import java.util.Scanner;

import classes.Operacao;
import classes.Servico;

import util.Util;
import app.App;

public class MenuArvoreServicos {

    private static Scanner sc = new Scanner(System.in);

    // Área da Arvore
    public static void exibirMenuArvore() {
        while (true) {
            Util.titulo("MENU ÁRVORE DE SERVIÇO");
            System.out.println(
                    "1.Inserir serviço.\n" +
                            "2.Buscar serviço por código\n" +
                            "3.Listar serviços em ordem crescente\n" +
                            "4.Retornar ao menu principal");
            System.out.print("Digite: ");
            int opcao = Util.LeitorINT();

            switch (opcao) {
                case 1:
                    inserirServico();
                    break;

                case 2:
                    buscarServicoPorId();
                    break;

                case 3:
                    listarServicos();
                    break;
                case 4:
                    break;
                default:
                    Util.notificacao("Negativo", "Opção inválida! Tente novamente.");
                    break;
            }
            if(opcao == 4){ break; }
        }
    }

    private static void inserirServico() {
        Util.subTitulo("Inserir novo serviço");
        System.out.print("Codigo do novo serviço: ");
        int codigo = Util.LeitorINT();

        System.out.print("Nome do Serviço: ");
        String nomeServico = sc.nextLine();

        System.out.print("Descrição do Serviço: ");
        String DescricaoServico = sc.nextLine();

        //Criando o objeto serviço com os dados informados
        Servico novoServico = new Servico(codigo, nomeServico, DescricaoServico);

        //Insere o serviço criado na arvore de serviços
        App.arvoreServicos.inserir(novoServico);
        

        Operacao novOperacao = new Operacao("CREATE", "Novo serviço " + nomeServico + " criado.");
        MenuOperacoes.registraOperacoes(novOperacao);
        Util.notificacao("Positivo", "Serviço criado e inserido na árvore.");
    }

    private static void buscarServicoPorId() {
        Util.subTitulo("Buscar serviço por ID");
        System.out.print("Codigo do serviço: ");
        int codigo = Util.LeitorINT();
        Servico s = App.arvoreServicos.buscar(codigo);
        if (s == null) {
            Util.notificacao("Negativo", "Serviço ["+codigo+"] não encontrado.");
            return;
        }
        System.out.println(s);
    }

    private static void listarServicos() {
        Util.subTitulo("Listar serviços em ordem");
        App.arvoreServicos.exibirEmOrdem();
    }
    // -----------------------------------------------------

}
