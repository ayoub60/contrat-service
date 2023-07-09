package ma.sirh.tassyircom.contrat.service.domain.event;

import ma.sirh.tassyircom.contrat.service.domain.entity.Contrat;

import java.time.ZonedDateTime;

public abstract class ContratEvent {

    private final Contrat contrat;
    private final ZonedDateTime dateCreation;

    public ContratEvent(Contrat contrat, ZonedDateTime dateCreation) {
        this.contrat = contrat;
        this.dateCreation = dateCreation;
    }
}
