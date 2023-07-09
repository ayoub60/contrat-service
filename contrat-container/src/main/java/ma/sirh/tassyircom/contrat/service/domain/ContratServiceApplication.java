package ma.sirh.tassyircom.contrat.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "ma.sirh.tassyircom.contrat.service.domain")
@EntityScan(basePackages = "ma.sirh.tassyircom.contrat.service.domain.entity")
@SpringBootApplication(scanBasePackages = "ma.sirh.tassyircom")
public class ContratServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContratServiceApplication.class);
    }
}
