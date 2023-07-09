package ma.sirh.tassyircom.contrat.service.domain.ports.output;

import ma.sirh.tassyircom.contrat.service.domain.entity.Contrat;

import java.util.Optional;

public interface IContratRepository {
    Contrat save(Contrat contrat);

    Optional<Contrat> getContratById(Long contratId);
}
