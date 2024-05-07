package entity.ticket;

import java.time.LocalDateTime;

public class Biglietto extends Ticket {
    private LocalDateTime vidimazione;
    private LocalDateTime scadenza;
    private Integer mezzo_id;
}
