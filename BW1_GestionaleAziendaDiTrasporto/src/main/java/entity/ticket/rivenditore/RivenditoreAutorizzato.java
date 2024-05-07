package entity.ticket.rivenditore;

import enums.Autorizzazione;

import javax.persistence.*;

@Entity
@Table(name="rivenditori_autorizzati")
public class RivenditoreAutorizzato extends Rivenditore {
    @Column(name = "nome_rivenditore")
    private String nomeRivenditore;
    @Enumerated(EnumType.STRING)
    private Autorizzazione autorizzazione;

    public RivenditoreAutorizzato(String nomeRivenditore, Autorizzazione autorizzazione) {
        this.nomeRivenditore = nomeRivenditore;
        this.autorizzazione = autorizzazione;
    }

    public RivenditoreAutorizzato() {

    }

    public String getNomeRivenditore() {
        return nomeRivenditore;
    }

    public void setNomeRivenditore(String nomeRivenditore) {
        this.nomeRivenditore = nomeRivenditore;
    }

    public Autorizzazione getAutorizzazione() {
        return autorizzazione;
    }

    public void setAutorizzazione(Autorizzazione autorizzazione) {
        this.autorizzazione = autorizzazione;
    }

    @Override
    public String toString() {
        return "RivenditoreAutorizzato{" +
                super.toString() +
                "nomeRivenditore='" + nomeRivenditore + '\'' +
                ", autorizzazione=" + autorizzazione +
                '}';
    }
}
