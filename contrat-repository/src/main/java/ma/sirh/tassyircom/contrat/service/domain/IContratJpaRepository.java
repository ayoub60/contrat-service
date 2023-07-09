package ma.sirh.tassyircom.contrat.service.domain;

import ma.sirh.tassyircom.contrat.service.domain.entity.ContratDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContratJpaRepository extends JpaRepository<ContratDb, Long> {
}
