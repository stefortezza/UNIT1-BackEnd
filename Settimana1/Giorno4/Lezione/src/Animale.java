public abstract class Animale {

    private int zampe;

    private String nome;

    public Animale(int zampe, String nome) {
        this.nome = nome;
        this.zampe = zampe;
    }

    public Animale() {

    }

    public Animale(String nome) {
        this.nome = nome;
    }

    public Animale(String nome, int zampe) {
        this.zampe = zampe;
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setZampe(int zampe) {
        this.zampe = zampe;
    }

    public int getZampe() {
        return zampe;
    }

    public String visualizzaDati () {
        return "Nome: " + nome + " , zampe: " + zampe;
    }

    public abstract void Verso () ;
}
