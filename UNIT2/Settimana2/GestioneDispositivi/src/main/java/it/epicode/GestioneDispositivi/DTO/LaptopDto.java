package it.epicode.GestioneDispositivi.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LaptopDto extends DispositivoDto{
    @NotNull
    private int schermo;
    @NotNull
    private String cpu;
    @NotNull
    private int ram;
}
