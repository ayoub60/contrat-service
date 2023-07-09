package ma.sirh.tassyircom.contrat.service.domain;


import lombok.extern.slf4j.Slf4j;
import ma.sirh.tassyircom.contrat.service.domain.dto.ContratCreatedRequest;
import ma.sirh.tassyircom.contrat.service.domain.dto.ContratResponse;
import ma.sirh.tassyircom.contrat.service.domain.entity.Contrat;
import ma.sirh.tassyircom.contrat.service.domain.event.ContratCreatedEvent;
import ma.sirh.tassyircom.contrat.service.domain.exception.ContratNotFoundException;
import ma.sirh.tassyircom.contrat.service.domain.mapper.ContratMapper;
import ma.sirh.tassyircom.contrat.service.domain.ports.input.IContratApplicationService;
import ma.sirh.tassyircom.contrat.service.domain.ports.output.IContratRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class ContratApplicationServiceImpl implements IContratApplicationService {
    private final IContratDomainService contratDomainService;
    private final ContratMapper contratMapper;
    private final IContratRepository contratRepository;
    public ContratApplicationServiceImpl(IContratDomainService contratDomainService,
                                         ContratMapper contratMapper,
                                         IContratRepository contratRepository) {
        this.contratDomainService = contratDomainService;
        this.contratMapper = contratMapper;
        this.contratRepository = contratRepository;
    }

    @Override
    @Transactional
    public ContratResponse createContrat(ContratCreatedRequest contratCreatedRequest) {
        Contrat contrat = contratMapper.mapRequestToDomain(contratCreatedRequest);
        ContratCreatedEvent contratCreatedEvent = contratDomainService.createContrat(contrat);
        Contrat contratSaved = contratRepository.save(contrat);
        log.info(" Contrat d'id : {} sauvegardé avec success", contratSaved.getId());
        // TODO: Aprés la création du commit de la transaction envoyer un message dans kafka
        return contratMapper.mapContratToResponse(contratSaved);
    }

    @Override
    @Transactional(readOnly = true)
    public ContratResponse getContratById(Long contratId) {
        Optional<Contrat> contratById = contratRepository.getContratById(contratId);
        if(contratById.isEmpty()){
            throw new ContratNotFoundException("Contrat non trouvé");
        }
        return contratMapper.mapContratToResponse(contratById.get());
    }
}
