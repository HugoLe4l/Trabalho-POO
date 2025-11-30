package classes;

public class Cliente {
    private int id;
    private String nome;
    private String email;
    private static int contadorID = 1;

    public Cliente(String nome, String email) {
        this.id = contadorID++;
        this.nome = nome;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        int espacosNome = Math.max(0, 25 - nome.length());
        String nomeFormatado = nome+" ".repeat(espacosNome);

        

        return "ID: " + id + " | Nome: " + nomeFormatado + " | E-mail: " + email;
    }

    
}