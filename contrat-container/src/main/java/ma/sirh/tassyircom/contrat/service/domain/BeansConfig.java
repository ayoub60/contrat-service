package ma.sirh.tassyircom.contrat.service.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    @Bean
    public IContratDomainService contratDomainService(){
        return new ContratDomainServiceImpl();
    }
}
