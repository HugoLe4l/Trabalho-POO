package menus;

import util.Util;

public class MenuPrincipal {
    // Menu Principal
    public static void exibirMenuPrincipal() {

        while (true) {
            Util.titulo("MENU PRINCIPAL");
            System.out.println("-> Escolha o que deseja fazer.");
            System.out.println(
                    "1.Gerenciar Fila de Chamados. ( Concluido )\n" +
                            "2.Gerenciar Pilha de Operações. ( Concluido )\n" +
                            "3.Gerenciar Lista de Clientes. ( Concluido )\n" +
                            "4.Gerenciar Árvore de Serviços.\n" +
                            "5.Sair");
            System.out.print("Digite: ");
            int op1 = Util.LeitorINT();

            switch (op1) {
                case 1:
                    MenuFilaChamada.exibirMenuFilaChamadas();
                    break;

                case 2:
                    MenuOperacoes.exibirMenuOperacoes();
                    break;

                case 3:
                    MenuCliente.exibirMenuCliente();
                    break;

                case 4:
                    MenuArvoreServicos.exibirMenuArvore();
                    break;

                case 5:
                    System.out.println("=== Programa encerrado ===");
                    return;

                default:
                    Util.notificacao("Negativo", "Opção inválida! Tente novamente.");
                    break;
            }

        }
    }

}
