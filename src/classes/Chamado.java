package classes;

public class Chamado {
    private int codigo;
    private String nomeCliente;
    private String descricao;

    public Chamado(int codigo, String nomeCliente, String descricao) {
        this.codigo = codigo;
        this.nomeCliente = nomeCliente;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Chamado{" +
                "codigo=" + codigo +
                ", nomeCliente='" + nomeCliente + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}