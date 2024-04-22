public class Aritmetica {

    public int divisione(int a, int b) throws DivisionePerZeroException {

        int risultato = 0;

        if (b == 0) {
            throw new DivisionePerZeroException("ERRORE: Divisione per zero non ammessa!");
        } else {
            risultato = a / b;
        }

        return risultato;
    }

}
