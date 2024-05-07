public class Cane extends Animale {

    private String razza;

    public Cane(String nome, int zampe, String razza) {
        super(nome, zampe);
        this.razza = razza;
    }

    public String getRazza() {
        return razza;
    }

    public void setRazza(String razza) {
        this.razza = razza;
    }

    @Override
    public String visualizzaDati() {
        return super.visualizzaDati() + ", razza: " + razza;
    }

    @Override
    public void Verso() {
        System.out.println("buuuu");
    }
}
