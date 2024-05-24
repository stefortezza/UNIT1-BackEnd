package it.epicode.GestioneDispositivi.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SmartphoneDto extends DispositivoDto {
    @NotNull
    private int schermo;
}
