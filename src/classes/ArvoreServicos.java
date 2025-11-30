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
        if (raizAtual == null) {
            /* System.out.println("Raiz vazia, criando uma raiz com valor " + servico.getCodigo()); */
            return new NoServico(servico);
        }

        int codigoServico = servico.getCodigo();

        if (codigoServico < raizAtual.servico.getCodigo()) {
            /* System.out.println("CodigoSerivco [ " + codigoServico + "] é menor que Raiz [ "+ raizAtual.servico.getCodigo() + " ] COLOCANDO NA ESQUERDA"); */
            raizAtual.esquerda = inserirServico(raizAtual.esquerda, servico);

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
        if (codigo == atual.servico.getCodigo())
            return atual;
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
