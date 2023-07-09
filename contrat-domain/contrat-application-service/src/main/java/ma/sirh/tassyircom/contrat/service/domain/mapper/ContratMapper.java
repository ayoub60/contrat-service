package ma.sirh.tassyircom.contrat.service.domain.mapper;

import ma.sirh.tassyircom.contrat.service.domain.dto.ContratCreatedRequest;
import ma.sirh.tassyircom.contrat.service.domain.dto.ContratResponse;
import ma.sirh.tassyircom.contrat.service.domain.dto.ElementContrat;
import ma.sirh.tassyircom.contrat.service.domain.entity.Contrat;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ContratMapper {
    public Contrat mapRequestToDomain(ContratCreatedRequest contratCreatedRequest){
        return Contrat.builder()
                .dateDebut(contratCreatedRequest.getDateDebut())
                .dateFin(contratCreatedRequest.getDateFin())
                .typeContrat(contratCreatedRequest.getTypeContrat())
                .elementsContrat(mapToElementContrat(contratCreatedRequest.getElementsContrat()))
                .build();
    }

    private List<ma.sirh.tassyircom.contrat.service.domain.entity.ElementContrat> mapToElementContrat(List<ElementContrat> elementsContrat) {
        if (CollectionUtils.isEmpty(elementsContrat)) {
            return new ArrayList<>();
        }
        return elementsContrat.stream().map(elt ->
                        ma.sirh.tassyircom.contrat.service.domain.entity.ElementContrat.builder()
                                .dateDebut(elt.getDateDebut())
                                .dateFin(elt.getDateFin())
                                .description(elt.getDescription())
                                .typeElement(elt.getTypeElement())
                                .build())
                .collect(toList());
    }

    public ContratResponse mapContratToResponse(Contrat contrat) {
        return ContratResponse.builder()
                .id(contrat.getId())
                .typeContrat(contrat.getTypeContrat())
                .dateDebut(contrat.getDateDebut())
                .dateFin(contrat.getDateFin())
                .typeContrat(contrat.getTypeContrat())
                .build();
    }
}
