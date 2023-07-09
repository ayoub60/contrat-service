package ma.sirh.tassyircom.contrat.service.domain.mapper;

import ma.sirh.tassyircom.contrat.service.domain.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class ContratDbMapper {
    public ContratDb mapContratToDb(Contrat contrat) {
        return ContratDb.builder()
                .dateDebut(contrat.getDateDebut())
                .dateFin(contrat.getDateFin())
                .statutContrat(contrat.getStatutContrat())
                .typeContrat(contrat.getTypeContrat())
                .elementsContrat(mapToElementsContratDb(contrat.getElementsContrat()))
                .build();
    }
    public Contrat mapToContrat(ContratDb contratDb){
        return Contrat.builder()
                .dateDebut(contratDb.getDateDebut())
                .id(contratDb.getId())
                .dateFin(contratDb.getDateFin())
                .dateDebut(contratDb.getDateDebut())
                .statutContrat(contratDb.getStatutContrat())
                .typeContrat(contratDb.getTypeContrat())
                .elementsContrat(mapToElementsContrat(contratDb.getElementsContrat()))
                .build();

    }
    private List<ElementContratDb> mapToElementsContratDb(List<ElementContrat> elementsContrat) {
        return elementsContrat.stream().map(elementContrat ->
                ElementContratDb.builder()
                        .dateDebut(elementContrat.getDateDebut())
                        .dateFin(elementContrat.getDateDebut())
                        .description(elementContrat.getDescription())
                        .typeElement(elementContrat.getTypeElement())
                        .build()
        ).collect(toList());
    }
    public List<ElementContrat> mapToElementsContrat(List<ElementContratDb> elementContratDbs){
        return elementContratDbs.stream().map(db ->
                ElementContrat.builder()
                        .dateDebut(db.getDateDebut())
                        .dateFin(db.getDateFin())
                        .typeElement(db.getTypeElement())
                        .description(db.getDescription())
                        .id(db.getId())
                        .build()
        ).collect(toList());

    }
}
