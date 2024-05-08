package entity.mezzo;

import entity.ticket.Biglietto;
import enums.TipoMezzo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="mezzi")
public class Mezzo {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer capienza;
    @OneToMany(mappedBy = "mezzo")
    private List<Biglietto> bigliettiVidimati;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_mezzo")
    private TipoMezzo tipoMezzo;
    @Column(name = "stati_mezzo")
    @OneToMany(mappedBy = "mezzo")
    private List<StatoMezzo> statiMezzo;

    public Mezzo(Integer capienza, TipoMezzo tipoMezzo) {
        this.capienza = capienza;
        this.tipoMezzo = tipoMezzo;
        this.bigliettiVidimati = new ArrayList<>();
        this.statiMezzo = new ArrayList<>();
    }

    public Mezzo() {
        this.bigliettiVidimati = new ArrayList<>();
        this.statiMezzo = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public Integer getCapienza() {
        return capienza;
    }

    public List<Biglietto> getBigliettiVidimati() {
        return bigliettiVidimati;
    }

    public TipoMezzo getTipoMezzo() {
        return tipoMezzo;
    }

    public List<StatoMezzo> getStatiMezzo() {
        return statiMezzo;
    }

    public void setCapienza(Integer capienza) {
        this.capienza = capienza;
    }

    public void setTipoMezzo(TipoMezzo tipoMezzo) {
        this.tipoMezzo = tipoMezzo;
    }
}
