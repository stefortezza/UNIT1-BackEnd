package it.epicode.Esercizio.bean;

import it.epicode.Esercizio.enums.StatoOrdine;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@PropertySource("application.properties")
public class Ordine {
    private int numeroOrdine;
    private StatoOrdine statoOrdine;
    private int numeroCoperti;
    private LocalTime oraAcquisizione;
    @Value("${ordine.coperto}")
    private int copoerto;
    private int importoTotale;
}

