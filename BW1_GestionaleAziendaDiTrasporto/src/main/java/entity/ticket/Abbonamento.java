package entity.ticket;

import enums.TipoAbbonamento;

import java.time.LocalDate;

public class Abbonamento extends Ticket {
    private TipoAbbonamento tipoAbbonamento;
    private LocalDate dataEmissione;
    private LocalDate dataScadenza;
    private Integer tessera_id;
}
