package br.gms.siscofa.infra.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import br.gms.siscofa.infra.spring.JPAProductionConfiguration;


@Configuration
@ComponentScan(basePackages = "br.gms.siscofa")
@EnableScheduling
@Import(value = { PersistenceConfig.class, JPAProductionConfiguration.class}) //, SecurityConfig.class })
public class MainConfig {

}
