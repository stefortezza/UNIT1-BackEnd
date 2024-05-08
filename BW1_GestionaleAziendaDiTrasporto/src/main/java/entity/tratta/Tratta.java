package entity.tratta;

import javax.persistence.*;
import java.time.Duration;
import java.util.List;

@Entity
@Table(name="tratte")
public class Tratta {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name="luogo_partenza")
    private String luogoPartenza;
    @Column(name = "luogo_arrivo")
    private String luogoArrivo;
    @Column(name = "percorrenza_media")
    private Duration percorrenzaMedia;
    @OneToMany(mappedBy = "tratta")
    private List<Viaggio> viaggi;

    public Tratta(String luogoPartenza, String luogoArrivo, Duration percorrenzaMedia) {
        this.luogoPartenza = luogoPartenza;
        this.luogoArrivo = luogoArrivo;
        this.percorrenzaMedia = percorrenzaMedia;
    }

    public Tratta() {

    }

    public Integer getId() {
        return id;
    }

    public List<Viaggio> getViaggi() {
        return viaggi;
    }

    public String getLuogoPartenza() {

        return luogoPartenza;
    }

    public String getLuogoArrivo() {
        return luogoArrivo;
    }

    public Duration getPercorrenzaMedia() {
        return percorrenzaMedia;
    }

    public void setLuogoPartenza(String luogoPartenza) {
        this.luogoPartenza = luogoPartenza;
    }

    public void setLuogoArrivo(String luogoArrivo) {
        this.luogoArrivo = luogoArrivo;
    }

    public void setPercorrenzaMedia(Duration percorrenzaMedia) {
        this.percorrenzaMedia = percorrenzaMedia;
    }

    @Override
    public String toString() {
        return "Tratta{" +
                "id=" + id +
                ", luogoPartenza='" + luogoPartenza + "'" +
                ", luogoArrivo='" + luogoArrivo + "'" +
                ", percorrenzaMedia=" + percorrenzaMedia +
                '}';
    }
}









