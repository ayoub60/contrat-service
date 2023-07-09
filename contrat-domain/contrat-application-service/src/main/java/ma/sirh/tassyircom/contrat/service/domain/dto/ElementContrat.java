package ma.sirh.tassyircom.contrat.service.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ma.sirh.tassyircom.contrat.service.dto.TypeElement;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public class ElementContrat {

    private final String description;
    private final TypeElement typeElement;
    private final LocalDate dateDebut;
    private final LocalDate dateFin;
}
