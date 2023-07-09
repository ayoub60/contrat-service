package ma.sirh.tassyircom.contrat.service.domain.adapter;

import lombok.extern.slf4j.Slf4j;
import ma.sirh.tassyircom.contrat.service.domain.IContratJpaRepository;
import ma.sirh.tassyircom.contrat.service.domain.entity.Contrat;
import ma.sirh.tassyircom.contrat.service.domain.entity.ContratDb;
import ma.sirh.tassyircom.contrat.service.domain.exception.ContratDomainException;
import ma.sirh.tassyircom.contrat.service.domain.mapper.ContratDbMapper;
import ma.sirh.tassyircom.contrat.service.domain.ports.output.IContratRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class ContratRepositoryImpl implements IContratRepository {
    private final IContratJpaRepository contratJpaRepository;
    private final ContratDbMapper contratDbMapper;

    public ContratRepositoryImpl(IContratJpaRepository contratJpaRepository,
                                 ContratDbMapper contratDbMapper) {
        this.contratJpaRepository = contratJpaRepository;
        this.contratDbMapper = contratDbMapper;
    }

    @Override
    public Contrat save(Contrat contrat) {
        ContratDb saveSaved = contratJpaRepository.save(
                contratDbMapper.mapContratToDb(contrat)
        );
        log.info("Contrat d'id= {}  sauvegardé avec succés", saveSaved.getId());
        return contratDbMapper.mapToContrat(saveSaved);
    }

    @Override
    public Optional<Contrat> getContratById(Long contratId) {
        return contratJpaRepository.findById(contratId)
                .map(contratDbMapper::mapToContrat);
    }
}
