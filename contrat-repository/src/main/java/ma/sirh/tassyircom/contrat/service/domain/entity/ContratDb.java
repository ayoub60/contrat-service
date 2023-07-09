package ma.sirh.tassyircom.contrat.service.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ma.sirh.tassyircom.contrat.service.dto.StatutContrat;
import ma.sirh.tassyircom.contrat.service.dto.TypeContrat;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Service
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "CONTRAT")
@Entity
public class ContratDb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    @Enumerated(EnumType.STRING)
    private StatutContrat statutContrat;
    @Enumerated(EnumType.STRING)
    private TypeContrat typeContrat;
    @OneToMany(mappedBy = "contratDb", cascade = CascadeType.ALL)
    private List<ElementContratDb> elementsContrat;
}
