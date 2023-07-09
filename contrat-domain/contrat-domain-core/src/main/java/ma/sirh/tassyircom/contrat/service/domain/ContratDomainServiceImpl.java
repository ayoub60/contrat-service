package ma.sirh.tassyircom.contrat.service.domain;


import ma.sirh.tassyircom.contrat.service.domain.constant.ContratConstants;
import ma.sirh.tassyircom.contrat.service.domain.entity.Contrat;
import ma.sirh.tassyircom.contrat.service.domain.event.ContratAnnulationEvent;
import ma.sirh.tassyircom.contrat.service.domain.event.ContratCreatedEvent;
import ma.sirh.tassyircom.contrat.service.domain.event.ContratResiliationEvent;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ContratDomainServiceImpl implements IContratDomainService {

    @Override
    public ContratCreatedEvent createContrat(Contrat contrat) {
        contrat.validerContrat();
        contrat.initialiserStatut();
        return new ContratCreatedEvent(contrat, ZonedDateTime.now(ZoneId.of(ContratConstants.UTC)));
    }

    @Override
    public ContratResiliationEvent resilierContrat(Contrat contrat) {
        contrat.validerResiliation();
        contrat.resilierContrat();
        return new ContratResiliationEvent(contrat, ZonedDateTime.now(ZoneId.of(ContratConstants.UTC)));
    }

    @Override
    public ContratAnnulationEvent annulerContrat(Contrat contrat) {
        contrat.annuler();
        return new ContratAnnulationEvent(contrat, ZonedDateTime.now(ZoneId.of(ContratConstants.UTC)));
    }
}
