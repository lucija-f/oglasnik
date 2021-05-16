package hr.java.oglasnik.exceptions;

public class NemoguceOdreditiGrupuOsiguranjaException extends Exception {


    private static final long serialVersionUID = 1660574401675840025L;

    public NemoguceOdreditiGrupuOsiguranjaException() {
        super("Ne mogu odrediti grupu osiguranja.");
    }

    public NemoguceOdreditiGrupuOsiguranjaException(String poruka) {
        super(poruka);

    }

    public NemoguceOdreditiGrupuOsiguranjaException(String poruka, Throwable uzrok) {
        super(poruka, uzrok);

    }

    public NemoguceOdreditiGrupuOsiguranjaException(Throwable uzrok) {
        super(uzrok);

    }

}
