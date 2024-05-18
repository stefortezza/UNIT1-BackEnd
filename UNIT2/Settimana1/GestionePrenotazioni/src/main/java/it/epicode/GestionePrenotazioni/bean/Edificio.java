package it.epicode.GestionePrenotazioni.bean;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Edificio {
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String indirizzo;
    private String citta;
    @OneToMany(mappedBy = "edificio", fetch = FetchType.EAGER)
    private List<PostazioneAziendale> postazioniAziendali;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Edificio{id=").append(id)
                .append(", nome='").append(nome).append('\'')
                .append(", indirizzo='").append(indirizzo).append('\'')
                .append('}');
        return sb.toString();
    }

}
