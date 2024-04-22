import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsaAritmetica {
    static Logger logger = LoggerFactory.getLogger("logger1"); //SCRITTURA CLASSICA PER UTILIZZARE IL METODO LOGGER

    //TRACE<DEBUG<INFO<WARN<ERROR, PIU' SI AVVICINA AD ERROR E PIU' E' ALTO IL LIVELLO DEL LOGGER.
    //DI DEFAUL IL LIVELLO E' DEBUG, PERTANTO IL LIVELLO TRACE NON VERRANNO STAMPATI.

    public static void main(String[] args) throws DivisionePerZeroException {
        logger.warn("STO LANCIANDO L'APPLICAZIONE!");

        Aritmetica aritmetica = new Aritmetica();
        try {
            System.out.println("Il risultato della divisione è: " + aritmetica.divisione(6, 3));
        } catch (ArithmeticException e) {
            System.out.println("ERRORE: Divisione per zero non ammessa!");
        } catch (DivisionePerZeroException e) {
            System.out.println(e.getMessage());
//            System.out.println(e.getStackTrace());
            e.printStackTrace(); //ERRORE IN ROSSO!!
        } catch (Exception e) {
            System.out.println("ERRORE: Gestione generica dell'eccezione!");
        }
        logger.info("Sto terminando l'applicazione!");
    }
}
