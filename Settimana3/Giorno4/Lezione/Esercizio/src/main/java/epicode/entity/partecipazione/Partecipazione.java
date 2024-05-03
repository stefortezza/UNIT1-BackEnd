package epicode.entity.partecipazione;

import epicode.entity.gestioneEventi.GestioneEventi;
import epicode.entity.persona.Persona;

import javax.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn (name = "persona_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private GestioneEventi evento;

    @Enumerated(EnumType.STRING)
    private Stato stato;


    public Partecipazione(int id, Persona persona, Stato stato, GestioneEventi evento) {
        this.id = id;
        this.persona = persona;
        this.stato = stato;
        this.evento = evento;
    }

    public Partecipazione () {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }


    public GestioneEventi getEvento() {
        return evento;
    }

    public void setEvento(GestioneEventi evento) {
        this.evento = evento;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }

}
