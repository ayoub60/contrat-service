package ma.sirh.tassyircom.contrat.service.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import ma.sirh.tassyircom.contrat.service.dto.TypeElement;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@Table(name = "ELEMENT_CONTRAT")
@Entity
public class ElementContratDb {
    @Id
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String description;
    @Enumerated(EnumType.STRING)
    private TypeElement typeElement;
    @ManyToOne
    private ContratDb contratDb;
}
