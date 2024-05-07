package epicode.entity;

import epicode.entity.gestioneEventi.GestioneEventi;
import epicode.entity.gestioneEventi.TipoEvento;
import epicode.entity.persona.Sesso;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Entity
public class Concerto extends GestioneEventi {
    @Enumerated(EnumType.STRING)
    private Genere genere;

    private boolean inStreaming;

    public Concerto(int id, String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Genere genere, boolean inStreaming) {
        super(id, titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Concerto(Genere genere, boolean inStreaming) {
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Concerto () {

    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}
