package it.epicode.GestioneDispositivi.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TabletDto extends DispositivoDto {
    @NotNull
    private int schermo;
    @NotNull
    private int ram;
}
