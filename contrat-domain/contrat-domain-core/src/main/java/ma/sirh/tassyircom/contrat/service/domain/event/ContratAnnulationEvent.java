package ma.sirh.tassyircom.contrat.service.domain.event;

import ma.sirh.tassyircom.contrat.service.domain.entity.Contrat;

import java.time.ZonedDateTime;


public class ContratAnnulationEvent extends ContratEvent {

    public ContratAnnulationEvent(Contrat contrat, ZonedDateTime dateCreation) {
        super(contrat, dateCreation);
    }
}
