package ma.sirh.tassyircom.contrat.service.domain.exception;


public class ContratDomainException extends RuntimeException {
    public ContratDomainException(String message) {
        super(message);
    }

    public ContratDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
