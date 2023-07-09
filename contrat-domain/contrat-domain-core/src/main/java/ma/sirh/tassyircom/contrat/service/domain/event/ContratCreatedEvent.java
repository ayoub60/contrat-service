package ma.sirh.tassyircom.contrat.service.domain.event;

import lombok.Getter;
import ma.sirh.tassyircom.contrat.service.domain.entity.Contrat;

import java.time.ZonedDateTime;

@Getter
public class ContratCreatedEvent extends ContratEvent {

    public ContratCreatedEvent(Contrat contrat, ZonedDateTime dateCreation) {
        super(contrat, dateCreation);
    }
}
