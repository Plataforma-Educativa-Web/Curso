package pe.cibertec.ProyectoFinal.ApiCurso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient

public class ApiCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCursoApplication.class, args);
	}

}
