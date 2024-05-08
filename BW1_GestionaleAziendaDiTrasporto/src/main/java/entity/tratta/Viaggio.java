package entity.tratta;

import entity.mezzo.Mezzo;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name="viaggi")
public class Viaggio {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="orario_partenza")
    private LocalDateTime orarioPartenza;
    @Column(name="orario_arrivo")
    private LocalDateTime orarioArrivo;
    @Column(name="percorrenza_effettiva")
    private Duration percorrenzaEffettiva;
    @ManyToOne
    @JoinColumn(name = "tratta_id")
    private Tratta tratta;
    @ManyToOne
    @JoinColumn(name="mezzo_id")
    private Mezzo mezzo;

    public Viaggio(LocalDateTime orarioPartenza, Tratta tratta, Mezzo mezzo) {
        this.orarioPartenza = orarioPartenza;
        this.tratta = tratta;
        this.mezzo = mezzo;
    }

    public Viaggio() {

    }

    public Integer getId() {
        return id;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    public LocalDateTime getOrarioPartenza() {
        return orarioPartenza;
    }

    public void setOrarioPartenza(LocalDateTime orarioPartenza) {
        this.orarioPartenza = orarioPartenza;
    }

    public LocalDateTime getOrarioArrivo() {
        return orarioArrivo;
    }

    public void setOrarioArrivo(LocalDateTime orarioArrivo) {
        this.orarioArrivo = orarioArrivo;
        this.percorrenzaEffettiva = Duration.between(this.orarioPartenza, this.orarioArrivo);
    }

    public Duration getPercorrenzaEffettiva() {
        return percorrenzaEffettiva;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    @Override
    public String toString() {
        return "Viaggio{" +
                "id="+id +
                ", orarioPartenza=" + orarioPartenza +
                ", orarioArrivo=" + orarioArrivo +
                ", percorrenzaEffettiva=" + percorrenzaEffettiva +
                '}';
    }
}


