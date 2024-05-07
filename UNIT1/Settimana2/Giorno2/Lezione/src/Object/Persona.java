package Object;

import java.util.Objects;

public class Persona {
    private String nome;
    private String cognome;
    private int eta;

    public Persona(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", eta=" + eta +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return eta == persona.eta && Objects.equals(nome, persona.nome) && Objects.equals(cognome, persona.cognome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome, eta);
    }


}
