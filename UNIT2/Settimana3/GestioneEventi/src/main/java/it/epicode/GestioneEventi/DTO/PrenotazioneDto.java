package it.epicode.GestioneEventi.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PrenotazioneDto {
    @NotBlank(message = "Il giorno prenotato non puo` essere nulla o solo spazzi!")
    private LocalDate giornoPrenotato;
    @NotBlank(message = "Il luogo non puo` essere nulla o solo spazzi!")
    private String luogo;
    @NotBlank(message = "Il numero massimo di posti disponibili non puo` essere nulla o solo spazzi!")
    private int numeroMaxPostiDisponibili;
}
