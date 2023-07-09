package ma.sirh.tassyircom.contrat.service.domain.entity;

import lombok.Builder;
import lombok.Getter;
import ma.sirh.tassyircom.contrat.service.domain.constant.ContratConstants;
import ma.sirh.tassyircom.contrat.service.domain.exception.ContratDomainException;
import ma.sirh.tassyircom.contrat.service.dto.StatutContrat;
import ma.sirh.tassyircom.contrat.service.dto.TypeContrat;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class Contrat {
    private Long id;
    private final TypeContrat typeContrat;
    private StatutContrat statutContrat;
    private List<ElementContrat> elementsContrat;
    private final LocalDate dateDebut;
    private LocalDate dateFin;
    private LocalDate dateResiliation;

    public void initialiserStatut() {
        this.statutContrat = StatutContrat.EN_ATTENTE;
    }

    public void approuver() {
        this.statutContrat = StatutContrat.VALIDE;
    }

    public void annuler() {
        this.statutContrat = StatutContrat.ANNULE;
    }

    public void validerContrat() {
        if (this.typeContrat == TypeContrat.CDD && this.dateFin == null) {
            throw new ContratDomainException("La date de fin du contrat doit etre non null pour un CDD");
        }
    }

    public void resilierContrat() {
        if (this.dateResiliation.equals(ContratConstants.DATE_JOUR) || this.dateResiliation.isBefore(ContratConstants.DATE_JOUR)) {
            this.statutContrat = StatutContrat.RESILIE;
        }
        if (this.dateResiliation.isAfter(ContratConstants.DATE_JOUR)) {
            this.statutContrat = StatutContrat.EN_COURS_RESILIATION;
        }
    }

    public void validerResiliation() {
        if (this.typeContrat == TypeContrat.CDD) {
            throw new ContratDomainException("Vous ne pouvez pas résilier un contrat CDD");
        }
        if (this.dateResiliation == null) {
            throw new ContratDomainException(" La date de résiliation ne peut etre vide");
        }
    }


}
