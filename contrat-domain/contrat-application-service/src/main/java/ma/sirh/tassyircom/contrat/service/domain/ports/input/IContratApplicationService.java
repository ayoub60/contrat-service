package ma.sirh.tassyircom.contrat.service.domain.ports.input;

import ma.sirh.tassyircom.contrat.service.domain.dto.ContratCreatedRequest;
import ma.sirh.tassyircom.contrat.service.domain.dto.ContratResponse;

import javax.validation.Valid;

public interface IContratApplicationService {

    ContratResponse createContrat(@Valid ContratCreatedRequest contratCreatedRequest);

    ContratResponse getContratById(Long contratId);

}
