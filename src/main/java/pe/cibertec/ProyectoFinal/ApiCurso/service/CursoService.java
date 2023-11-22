package pe.cibertec.ProyectoFinal.ApiCurso.service;

import java.util.List;
import pe.cibertec.ProyectoFinal.ApiCurso.entity.Curso;

public interface CursoService {
    
    public List<Curso> findAll(); 
    public Curso findByCodigo(Long codigo);
    public Curso buscarPorId (Long id);
    public Curso findByNombre (String nombre);
    public Curso agregarCurso(Curso curso);
    public Curso actualizarCurso(Curso curso);
    public void eliminarCurso (Long id);
    
}
