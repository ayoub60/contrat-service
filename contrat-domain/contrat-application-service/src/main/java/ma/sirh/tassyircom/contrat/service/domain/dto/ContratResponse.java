package ma.sirh.tassyircom.contrat.service.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ma.sirh.tassyircom.contrat.service.dto.StatutContrat;
import ma.sirh.tassyircom.contrat.service.dto.TypeContrat;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class ContratResponse {
    private final Long id;
    private final TypeContrat typeContrat;
    private final StatutContrat statutContrat;
    private final LocalDate dateDebut;
    private final LocalDate dateFin;
    private final EmployeRequest employeRequest;
    private final List<ElementContrat> elementsContrat;
}
