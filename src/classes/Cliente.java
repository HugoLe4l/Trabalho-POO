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
        return "ID: " + id + " | Nome: " + nome + " | E-mail: " + email;
    }

    
}