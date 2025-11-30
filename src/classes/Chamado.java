package classes;

public class Chamado {
    private int codigo;
    private int idCliente;
    private String nomeCliente;
    private String descricao;
    private int contadorCodigo = 1;

    public Chamado( int idCliente, String nomeCliente, String descricao) {
        this.codigo = contadorCodigo++;
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getIdCliente(){
        return idCliente;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        int espacosNome = Math.max(0, 20 - nomeCliente.length());
        String nomeFormatado = nomeCliente+" ".repeat(espacosNome);

        int espacosDesc = Math.max(0, 30 - descricao.length());
        String descFormatado = descricao+" ".repeat(espacosDesc);

        return "Codigo: "+codigo+" | Cliente: "+ idCliente + " - "+nomeFormatado+ " | Problema: "+descFormatado + " |";
    }
}