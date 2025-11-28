package classes;

public class Operacao {
    private int id;
    private String tipo;
    private String texto;
    private static int contadorID = 1;

    public Operacao(String tipo, String texto){
        this.id = contadorID++;
        this.tipo   = tipo;
        this.texto  = texto;
    }

    public static final String RESET = "\u001B[0m";

    public static final String RED    = "\u001B[31m";
    public static final String GREEN  = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";



    public int getID(){
        return id;
    }
    public String getTipo(){
        return tipo;
    }
    public String getTexto(){
        return texto;
    }
    public String toString(){
        String COLOR = "";
        int mintamanho =  40;
        int espacos = Math.max(0, mintamanho - texto.length());
        String textoFormatado = texto+" ".repeat(espacos);
        if(tipo == "CREATE"){
            COLOR = GREEN;
        }
        if(tipo == "DELETE"){
            COLOR = RED;
        }
        if(tipo == "MANUAL"){
            COLOR = YELLOW;
        }
        return "ID: "+id+" | "+COLOR+" "+textoFormatado+" "+RESET+" |";
    }
}
