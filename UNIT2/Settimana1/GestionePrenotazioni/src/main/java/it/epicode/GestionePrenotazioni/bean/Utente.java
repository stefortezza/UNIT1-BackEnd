package it.epicode.GestionePrenotazioni.bean;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
public class Utente {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String nome;
    private String email;
    @OneToMany(mappedBy = "utente", fetch = FetchType.EAGER)
    private List<PostazioneAziendale> postazioniAziendali;

    public void caricaPostazioniAziendali() {
        this.postazioniAziendali.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Utente{id=").append(id)
                .append(", username='").append(username).append('\'')
                .append(", nome='").append(nome).append('\'')
                .append(", email='").append(email).append('\'');
        if (postazioniAziendali != null) {
            sb.append(", postazioniAziendali=").append(postazioniAziendali.stream().map(PostazioneAziendale::getCodiceUnivoco).collect(Collectors.toList()));
        }
        sb.append('}');
        return sb.toString();
    }
}


