package maia.administracaousuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan
@EnableJpaRepositories
public class AdministracaoUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdministracaoUsuariosApplication.class, args);
	}

}
