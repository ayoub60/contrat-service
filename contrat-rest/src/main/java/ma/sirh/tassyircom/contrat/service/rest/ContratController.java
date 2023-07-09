package ma.sirh.tassyircom.contrat.service.rest;

import lombok.extern.slf4j.Slf4j;
import ma.sirh.tassyircom.contrat.service.domain.dto.ContratCreatedRequest;
import ma.sirh.tassyircom.contrat.service.domain.dto.ContratResponse;
import ma.sirh.tassyircom.contrat.service.domain.ports.input.IContratApplicationService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/contrats")
public class ContratController {
    private final IContratApplicationService contratApplicationService;

    public ContratController(IContratApplicationService contratApplicationService) {
        this.contratApplicationService = contratApplicationService;
    }

    @PostMapping
    public ContratResponse createContrat(@RequestBody ContratCreatedRequest contratCreatedRequest){
        log.info(" Début Création du contrat");
        ContratResponse contratResponse = contratApplicationService.createContrat(contratCreatedRequest);
        return contratResponse;
    }
    @GetMapping("/{contratId}")
    public ContratResponse getContratById(@PathVariable Long contratId){
        log.info(" get contrat d'id: {} ", contratId);
        return contratApplicationService.getContratById(contratId);
    }
}
