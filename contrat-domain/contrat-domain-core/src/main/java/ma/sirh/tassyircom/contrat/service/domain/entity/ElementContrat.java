package ma.sirh.tassyircom.contrat.service.domain.entity;

import lombok.Builder;
import lombok.Getter;
import ma.sirh.tassyircom.contrat.service.dto.TypeElement;

import java.time.LocalDate;

@Getter
@Builder
public class ElementContrat {
    private Long id;
    private final String description;
    private final TypeElement typeElement;
    private final LocalDate dateDebut;
    private final LocalDate dateFin;


}
