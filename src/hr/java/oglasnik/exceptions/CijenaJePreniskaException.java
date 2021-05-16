package hr.java.oglasnik.exceptions;

public class CijenaJePreniskaException extends RuntimeException {


    private static final long serialVersionUID = 1995923096478174792L;

    public CijenaJePreniskaException() {
        super("Cijena ne smije biti manja od 10000kn");
    }

    public CijenaJePreniskaException(String poruka) {
        super(poruka);

    }

    public CijenaJePreniskaException(String poruka, Throwable uzrok) {
        super(poruka, uzrok);

    }

    public CijenaJePreniskaException(Throwable uzrok) {
        super(uzrok);

    }
}
