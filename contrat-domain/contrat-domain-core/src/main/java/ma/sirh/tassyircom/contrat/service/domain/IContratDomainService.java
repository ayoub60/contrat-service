package ma.sirh.tassyircom.contrat.service.domain;

import ma.sirh.tassyircom.contrat.service.domain.entity.Contrat;
import ma.sirh.tassyircom.contrat.service.domain.event.ContratAnnulationEvent;
import ma.sirh.tassyircom.contrat.service.domain.event.ContratCreatedEvent;
import ma.sirh.tassyircom.contrat.service.domain.event.ContratResiliationEvent;

public interface IContratDomainService {
    ContratCreatedEvent createContrat(Contrat contrat);
    ContratResiliationEvent resilierContrat(Contrat contrat);
    ContratAnnulationEvent annulerContrat(Contrat contrat);
}
