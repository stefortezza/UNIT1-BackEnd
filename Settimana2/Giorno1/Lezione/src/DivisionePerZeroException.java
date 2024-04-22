public class DivisionePerZeroException extends Exception { // extends RuntimeException
                                                           // per dichiararlo non obbligatorio!!

    public DivisionePerZeroException(String message) {
        super(message);
    }
}
