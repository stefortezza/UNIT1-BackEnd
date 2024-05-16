package it.epicode.Esercizio.bean;

import it.epicode.Esercizio.enums.Stato;
import lombok.Data;

@Data
public class Tavolo {
    private int numeroTavolo;
    private int numeroCopertiMassimi;
    private Stato stato;
    private double coperto;
}
