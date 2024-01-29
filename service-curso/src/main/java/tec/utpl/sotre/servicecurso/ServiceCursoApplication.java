package tec.utpl.sotre.servicecurso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCursoApplication.class, args);
	}

}
