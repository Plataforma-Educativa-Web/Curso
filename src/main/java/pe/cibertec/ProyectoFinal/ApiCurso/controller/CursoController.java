package pe.cibertec.ProyectoFinal.ApiCurso.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.ProyectoFinal.ApiCurso.dto.CursoDTO;
import pe.cibertec.ProyectoFinal.ApiCurso.entity.Curso;
import pe.cibertec.ProyectoFinal.ApiCurso.entity.Turno;
import pe.cibertec.ProyectoFinal.ApiCurso.exception.EntityNotFoundException;
import pe.cibertec.ProyectoFinal.ApiCurso.service.CursoService;
import pe.cibertec.ProyectoFinal.ApiCurso.restClient.TurnoRestClient;

@RestController
@RequestMapping("api/v1/curso")
@Slf4j

public class CursoController {

    @Autowired

    private CursoService cursoService;

    @GetMapping("/findAll")

    public ResponseEntity<List<Curso>> findAll() {

        try {
            log.info("Obteniendo todos los cursos");
            return new ResponseEntity<>(cursoService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al obtener todos los cursos: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/findById/{id}")

    public ResponseEntity<CursoDTO> findById(@PathVariable Long id) {

        try {
            log.info("Obteniendo curso por ID: {}", id);
            return new ResponseEntity<>(cursoService.findById(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al obtener curso por ID {}: {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/findByCodigo/{codigo}")

    public ResponseEntity<Curso> findByCodigo(@PathVariable Long codigo) {

        try {
            log.info("Buscando curso por código: {}", codigo);
            return new ResponseEntity<>(cursoService.findByCodigo(codigo), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al buscar curso por código {}: {}", codigo, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByNombre/{nombre}")

    public ResponseEntity<Curso> findByNombre(@PathVariable String nombre) {

        try {
            log.info("Buscando curso por nombre: {}", nombre);
            return new ResponseEntity<>(cursoService.findByNombre(nombre), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al buscar curso por nombre {}: {}", nombre, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/buscarPorId/{id}")

    public ResponseEntity<Curso> buscarPorId(@PathVariable Long id) {

        try {
            log.info("Buscando curso por ID: {}", id);
            return new ResponseEntity<>(cursoService.buscarPorId(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al buscar curso por ID {}: {}", id, e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/agregarCurso")

    public ResponseEntity<Curso> agregarCurso(@RequestBody Curso curso) {

        try {
            log.info("Agregando nuevo curso: {}", curso);
            return new ResponseEntity<>(cursoService.agregarCurso(curso), HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error al agregar nuevo curso: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/actualizarCurso")

    public ResponseEntity<Curso> actualizarCurso(@RequestBody Curso curso) {
        try {
            log.info("Actualizando curso con ID {}: {}", curso.getId(), curso);
            return new ResponseEntity<>(cursoService.actualizarCurso(curso), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            log.error("Error al actualizar curso con ID {}: {}", curso.getId(), e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/eliminarCurso/{id}")

    public void eliminarCurso(@PathVariable Long id) {

        try {
            log.info("Eliminando curso con ID: {}", id);
            cursoService.eliminarCurso(id);
        } catch (EntityNotFoundException e) {
            log.error("Error al eliminar curso con ID {}: {}", id, e.getMessage());
        }

    }

}
