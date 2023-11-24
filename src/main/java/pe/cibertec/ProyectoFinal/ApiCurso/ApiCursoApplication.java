package pe.cibertec.ProyectoFinal.ApiCurso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class ApiCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCursoApplication.class, args);
	}

}
