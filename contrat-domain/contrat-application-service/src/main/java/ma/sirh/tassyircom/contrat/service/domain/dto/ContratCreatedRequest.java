package ma.sirh.tassyircom.contrat.service.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ma.sirh.tassyircom.contrat.service.dto.TypeContrat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class ContratCreatedRequest {
    @NotNull
    private final TypeContrat typeContrat;
    @NotNull
    @JsonFormat
    private final LocalDate dateDebut;
    private final LocalDate dateFin;
    @NotNull
    private final EmployeRequest employeRequest;
    private final List<ElementContratRequest> elementsContrat;
}
