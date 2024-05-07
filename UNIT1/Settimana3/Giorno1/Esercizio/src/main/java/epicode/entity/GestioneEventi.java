package epicode.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "GestioneEventi")

public class GestioneEventi {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "eventi_id_table") //"eventi_id_sequence
    //si utilizza quando la generationType è SEQUENCE
    //@SequenceGenerator(name = "eventi_id_sequence", initialValue = 1, allocationSize = 1)
    @TableGenerator(name = "eventi_id_table", initialValue = 0)
    private int id;
    @Column(nullable = false, length = 50)
    private String titolo;
    @Column(name = "data_Evento")
    private LocalDate dataEvento;
    @Column(nullable = false, length = 50)
    private String descrizione;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento")
    private TipoEvento tipoEvento;
    @Column(name = "numero_massimo_partecipanti")
    private int numeroMassimoPartecipanti;

    public GestioneEventi(int id, String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
        this.id = id;
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public GestioneEventi() {

    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    @Override
    public String toString() {
        return "GestioneEventiDao{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", NumeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }
}
