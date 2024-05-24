package it.epicode.GestioneDispositivi.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(callSuper = true)
public class Laptop extends Dispositivo{
    private int schermo;
    private String cpu;
    private int ram;
}
