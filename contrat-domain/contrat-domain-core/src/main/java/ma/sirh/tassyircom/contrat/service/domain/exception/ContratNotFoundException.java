package ma.sirh.tassyircom.contrat.service.domain.exception;

public class ContratNotFoundException extends RuntimeException {
    public ContratNotFoundException(String message) {
        super(message);
    }

    public ContratNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
