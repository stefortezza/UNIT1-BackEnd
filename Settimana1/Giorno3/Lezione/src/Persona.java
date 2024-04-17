public class Persona {

    public String nome;
    public String cognome;
    public int eta;
    public String indirizzo;
    public static int contatore;
    public tipoLavoro tipoLavoro;

    public Persona() {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.indirizzo = indirizzo;
        this.tipoLavoro = tipoLavoro;
        contatore++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome (String nome) { //CON QUESTO METODO SI MODIFICA IL PARAMETRO, IN QUESTO CASO NAME!
        this.nome = nome;
    }
}
