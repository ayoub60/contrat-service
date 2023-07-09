package ma.sirh.tassyircom.contrat.service.domain.event;

import lombok.Getter;
import ma.sirh.tassyircom.contrat.service.domain.entity.Contrat;

import java.time.ZonedDateTime;

@Getter
public class ContratResiliationEvent extends ContratEvent {

    public ContratResiliationEvent(Contrat contrat, ZonedDateTime dateCreation) {
        super(contrat, dateCreation);
    }
}
