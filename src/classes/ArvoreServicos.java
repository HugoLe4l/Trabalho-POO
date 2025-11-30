package classes;
import util.Util;
public class ArvoreServicos {

    private static class NoServico {
        Servico servico;
        NoServico esquerda;
        NoServico direita;

        NoServico(Servico servico) {
            this.servico = servico;
        }
    }

    private NoServico raiz;

    public void inserir(Servico servico) {
        raiz = inserirServico(raiz, servico);
    }

    private NoServico inserirServico(NoServico raizAtual, Servico servico) {

        //Se o nó da raiz for nulo cria um novo nó com o serviço fornecido.
        if (raizAtual == null) {
            /* System.out.println("Raiz vazia, criando uma raiz com valor " + servico.getCodigo()); */
            return new NoServico(servico);
        }


        int codigoServico = servico.getCodigo();

        //Verifica se codigoServico é menor que o codigo da raizAtual. Caso seja menor adiciona no NÓ da esquerda
        if (codigoServico < raizAtual.servico.getCodigo()) {
            /* System.out.println("CodigoSerivco [ " + codigoServico + "] é menor que Raiz [ "+ raizAtual.servico.getCodigo() + " ] COLOCANDO NA ESQUERDA"); */

            //Casso o no ainda não tenha um valor em raizAtual.esquerda, vai ser igual a null.
            raizAtual.esquerda = inserirServico(raizAtual.esquerda, servico);

        //Se for maior que o codigo de raizAtual adiciona na direita.
        } else if (codigoServico > raizAtual.servico.getCodigo()) {
            /* System.out.println("CodigoSerivco [ " + codigoServico + "] é maior que Raiz [ "+ raizAtual.servico.getCodigo() + " ] COLOCANDO NA DIREITA"); */
            raizAtual.direita = inserirServico(raizAtual.direita, servico);
        } else {
            // Em brnaco para caso seja inserção duplicada ;)
        }

        return raizAtual;
    }

    public Servico buscar(int codigo) {
        NoServico no = buscarRec(raiz, codigo);
        return (no == null) ? null : no.servico;
    }

    private NoServico buscarRec(NoServico atual, int codigo) {
        if (atual == null)
            return null;
        //Se o codigo fornecido for igual a o codigo do NÓ atual retorna o atual.
        if (codigo == atual.servico.getCodigo())
            return atual;

        //Se menor, verifica passa como parametro do metodo buscarRec() o atual.esquerda do atual e o codigo fornecido.
        else if (codigo < atual.servico.getCodigo())
            return buscarRec(atual.esquerda, codigo);
        else
            return buscarRec(atual.direita, codigo);
    }

    public void exibirEmOrdem() {
        if (raiz == null) {
            Util.notificacao("Negativo", "Não existe serviços cadastrados.");
            return;
        } else {
            exibirEmOrdemRec(raiz);
        }
    }

    private void exibirEmOrdemRec(NoServico atual) {
        if (atual == null)
            return;
        exibirEmOrdemRec(atual.esquerda);
        System.out.println(atual.servico);
        exibirEmOrdemRec(atual.direita);
    }

}
