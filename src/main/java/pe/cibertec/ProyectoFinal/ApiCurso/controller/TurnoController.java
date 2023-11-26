package pe.cibertec.ProyectoFinal.ApiCurso.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ProyectoFinal.ApiCurso.entity.Turno;
import pe.cibertec.ProyectoFinal.ApiCurso.restClient.TurnoRestClient;

@RestController
@RequestMapping("api/v1/turno")
@Slf4j

public class TurnoController {

    @Autowired

    private TurnoRestClient turnoRestClient;

    @GetMapping("/findAllTurno")

    public ResponseEntity<List<Turno>> findAllTurno() {

        try {
            log.info("Obteniendo todos los turnos");
            return new ResponseEntity<>(turnoRestClient.findAllTurno(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al obtener todos los turnos: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
