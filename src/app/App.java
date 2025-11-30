package app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import classes.ArvoreServicos;
import classes.Chamado;
import classes.Cliente;
import classes.Operacao;

import menus.MenuPrincipal;



public class App {
    public static ArrayList<Cliente> listaClientes = new ArrayList<>();
    public static Stack<Operacao> pilhaOperacoes = new Stack<>();
    public static Queue<Chamado> filaChamados = new LinkedList<>();
    public static ArvoreServicos arvoreServicos = new ArvoreServicos();

    public static void main(String[] args) throws Exception {
        MenuPrincipal.exibirMenuPrincipal();
    }


}
