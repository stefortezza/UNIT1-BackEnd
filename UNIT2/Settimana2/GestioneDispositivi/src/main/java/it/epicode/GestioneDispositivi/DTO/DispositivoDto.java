package it.epicode.GestioneDispositivi.DTO;

import it.epicode.GestioneDispositivi.enums.TipoDispositivo;
import it.epicode.GestioneDispositivi.model.Laptop;
import it.epicode.GestioneDispositivi.model.Smartphone;
import it.epicode.GestioneDispositivi.model.Tablet;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class DispositivoDto {

    @NotNull
    private int id;
    @NotNull
    private String nome;
//    @NotNull(message = "Il campo tipo Dispositivo non puo` essere null!")
//    private TipoDispositivo tipoDispositivo;

    private List<Laptop> laptop;
    private List<Smartphone> smartphone;
    private List<Tablet> tablet;
}
