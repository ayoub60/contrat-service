package ma.sirh.tassyircom.contrat.service.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
 @AllArgsConstructor
public class EmployeRequest {
     @NotEmpty
     private final String nom;
     @NotEmpty
     private final String prenom;
}
