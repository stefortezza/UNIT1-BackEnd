package it.epicode.Lezione.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Smartphone extends Dispositivo {
    private int schermo;

}
