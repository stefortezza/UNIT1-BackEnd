package it.epicode.GestioneEventi.Entity;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class Error {
    private LocalDateTime dataErrore;
    private HttpStatus statoErrore;
}
