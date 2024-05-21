package it.epicode.GestionePrenotazioni.appConfig;
import it.epicode.GestionePrenotazioni.bean.Edificio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


@Configuration
public class AppConfig {
    @Bean(name = "edificio1")
    @Primary
    public Edificio edificio1() {
        Edificio edificio1 = new Edificio();
        edificio1.setId(1);
        edificio1.setNome("Edificio ALA A");
        edificio1.setIndirizzo("Via Roma, 1");
        edificio1.setCitta("Caltagirone");
        return edificio1;
    }

}
