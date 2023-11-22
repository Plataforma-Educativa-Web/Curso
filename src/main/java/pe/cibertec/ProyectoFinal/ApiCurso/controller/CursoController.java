package pe.cibertec.ProyectoFinal.ApiCurso.controller;

import java.util.List;
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
import pe.cibertec.ProyectoFinal.ApiCurso.entity.Curso;
import pe.cibertec.ProyectoFinal.ApiCurso.service.CursoService;

@RestController
@RequestMapping("api/v1/curso")

public class CursoController {
    
    @Autowired
    
    private CursoService cursoService;
    
    @GetMapping("/findAll")
    
    public ResponseEntity<List<Curso>> findAll() {
        
        return new ResponseEntity<>(cursoService.findAll(), HttpStatus.OK);
        
    }
    
    @GetMapping("/findByCodigo/{codigo}")
    
    public ResponseEntity<Curso> findByCodigo(@PathVariable Long codigo) {
        
        return new ResponseEntity<>(cursoService.findByCodigo(codigo), HttpStatus.OK);
        
    }
    
    @GetMapping("/findByNombre/{nombre}")
    
    public ResponseEntity<Curso> findByNombre(@PathVariable String nombre) {
        
        return new ResponseEntity<>(cursoService.findByNombre(nombre), HttpStatus.OK);
        
    }
    
    @GetMapping("/buscarPorId/{id}")
    
    public ResponseEntity<Curso> buscarPorId(@PathVariable Long id) {
        
        return new ResponseEntity<>(cursoService.buscarPorId(id),HttpStatus.OK);
        
    }
    
    @PostMapping("/agregarCurso")
    
    public ResponseEntity<Curso> agregarCurso(@RequestBody Curso curso) {
        
        return new ResponseEntity<>(cursoService.agregarCurso(curso),HttpStatus.CREATED);
        
    }
    
    @PutMapping("/actualizarCurso")
    
    public ResponseEntity<Curso> actualizarCurso(@RequestBody Curso curso) {
        
        return new ResponseEntity<>(cursoService.actualizarCurso(curso), HttpStatus.OK);
        
    }
    
    @DeleteMapping("/eliminarCurso/{id}")
    
    public void eliminarCurso(@PathVariable Long id) {
        
        cursoService.eliminarCurso(id);
        
    }
    
}
