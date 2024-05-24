package it.epicode.GestioneDispositivi.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DipendenteDto {
    
    @NotNull(message = "Il campo nome non puo` essere null!")
    @Size(max = 30, min = 1)
    private String nome;

    @NotNull(message = "Il campo cognome non puo` essere  null!")
    @Size(max = 30)
    private String cognome;

    @NotNull(message = "Il campo email non puo` essere null!")
    @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")
    private String email;

    private int dispositivoId;
}
