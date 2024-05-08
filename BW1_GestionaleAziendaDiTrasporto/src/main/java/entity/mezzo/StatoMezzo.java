package entity.mezzo;

import enums.TipoStatoMezzo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="stati_mezzi")
public class StatoMezzo {
    @Id
    @GeneratedValue
    private Integer id;
    private LocalDateTime inizio;
    private LocalDateTime fine;
    @Enumerated(EnumType.STRING)
    private TipoStatoMezzo tipo;
    @ManyToOne
    @JoinColumn(name="mezzo_id")
    private Mezzo mezzo;

    public StatoMezzo(LocalDateTime inizio, TipoStatoMezzo tipo, Mezzo mezzo) {
        this.inizio = inizio;
        this.tipo = tipo;
        this.mezzo = mezzo;
    }

    public StatoMezzo() {

    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getInizio() {
        return inizio;
    }

    public LocalDateTime getFine() {
        return fine;
    }

    public TipoStatoMezzo getTipo() {
        return tipo;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setInizio(LocalDateTime inizio) {
        this.inizio = inizio;
    }

    public void setFine(LocalDateTime fine) {
        this.fine = fine;
    }

    public void setTipo(TipoStatoMezzo tipo) {
        this.tipo = tipo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    @Override
    public String toString() {
        return "StatoMezzo{" +
                "id=" + id +
                ", inizio=" + inizio +
                ", fine=" + fine +
                ", tipo=" + tipo +
                ", mezzo=" + mezzo +
                '}';
    }
}
