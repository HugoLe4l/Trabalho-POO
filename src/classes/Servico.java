package classes;

public class Servico {

    private int codigo;
    private String nome;
    private String descricao;

    public Servico(int codigo ,String nome, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Codigo: "+codigo+" | Nome: "+nome+" | Descrição: "+descricao;
    }
}
