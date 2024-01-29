package tec.utpl.sotre.serviceactividad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceActividadApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceActividadApplication.class, args);
	}

}
