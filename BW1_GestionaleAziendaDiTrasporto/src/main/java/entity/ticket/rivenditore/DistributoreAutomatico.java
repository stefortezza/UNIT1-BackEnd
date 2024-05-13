package entity.ticket.rivenditore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="distributori_automatici")
public class DistributoreAutomatico extends Rivenditore {
    private Boolean attivo;

    public DistributoreAutomatico(Boolean attivo) {
        this.attivo = attivo;
    }

    public DistributoreAutomatico() {

    }

    public Boolean getAttivo() {
        return attivo;
    }

    public void setAttivo(Boolean attivo) {
        this.attivo = attivo;
    }

    @Override
    public String toString() {
        return "DistributoreAutomatico{" +
                super.toString() +
                "attivo=" + attivo +
                '}';
    }
}
