package it.epicode.Lezione.bean;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class Studente {
    private String nome;
    private String cognome;
    private String indirizzo;

    private List<Dispositivo> dispositivi;
}
