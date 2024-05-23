package it.epicode.Lezione.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AulaDto {
    @NotNull(message = "Il campo nome non puo` essere null!")
    @Size(max = 30)
    private String nome;

    @Max(3)
    @Min(0)
    private int piano;
}
