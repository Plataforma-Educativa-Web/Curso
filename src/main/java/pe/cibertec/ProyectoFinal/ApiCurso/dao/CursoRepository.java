package pe.cibertec.ProyectoFinal.ApiCurso.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.ProyectoFinal.ApiCurso.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    
    Optional<Curso> findByCodigo (Long codigo);
    Optional<Curso> findByNombre (String nombre);
    
}
