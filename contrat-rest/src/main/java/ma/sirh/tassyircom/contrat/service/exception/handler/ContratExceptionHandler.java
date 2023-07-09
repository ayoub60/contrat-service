package ma.sirh.tassyircom.contrat.service.exception.handler;

import lombok.extern.slf4j.Slf4j;
import ma.sirh.tassyircom.contrat.service.domain.exception.ContratDomainException;
import ma.sirh.tassyircom.contrat.service.domain.exception.ContratNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@ControllerAdvice
public class ContratExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ContratNotFoundException.class)
    public ErrorDto handleException(ContratNotFoundException exception){
        log.error(exception.getMessage(),exception);
        return ErrorDto.builder()
                .code(HttpStatus.NOT_FOUND.getReasonPhrase())
                .message(exception.getMessage())
                .build();
    }
    @ResponseBody
    @ExceptionHandler(value = ContratDomainException.class)
    public ErrorDto handleException(ContratDomainException exception){
        log.error(exception.getMessage(),exception);
        return ErrorDto.builder()
                .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(exception.getMessage())
                .build();
    }
}
