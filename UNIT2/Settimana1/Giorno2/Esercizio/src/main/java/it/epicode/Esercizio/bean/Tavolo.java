package it.epicode.Esercizio.bean;

import it.epicode.Esercizio.enums.Stato;
import lombok.Data;

@Data
public class Tavolo {
    private int numeroTavolo;
    private int numeroCopertiMassimo;
    private Stato stato;
}
