package pe.cibertec.ProyectoFinal.ApiCurso.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.ProyectoFinal.ApiCurso.dao.CursoRepository;
import pe.cibertec.ProyectoFinal.ApiCurso.entity.Curso;
import pe.cibertec.ProyectoFinal.ApiCurso.exception.EntityNotFoundException;
import pe.cibertec.ProyectoFinal.ApiCurso.service.CursoService;

@Service

public class CursoServiceImpl implements CursoService {
    
    @Autowired
    
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> findAll() {
        
        return (List<Curso>) cursoRepository.findAll();
                
    }

    @Override
    public Curso findByCodigo(Long codigo) {
        
        return cursoRepository.findByCodigo(codigo).orElseThrow(()-> new EntityNotFoundException("Curso no encontrado con el codigo"+codigo.toString()));
        
    }

    @Override
    public Curso buscarPorId(Long id) {
        
        return cursoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con el ID"+id.toString()));
        
    }

    @Override
    public Curso findByNombre(String nombre) {
        
        return cursoRepository.findByNombre(nombre).orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con el nombre"+nombre.toString()));
    
    }

    @Override
    public Curso agregarCurso(Curso curso) {
       
        return cursoRepository.save(curso);
        
    }

    @Override
    public Curso actualizarCurso(Curso curso) {
        
        var CursoF = cursoRepository.findById(curso.getId()).get();
        CursoF.setNombre(curso.getNombre());
        CursoF.setCodigo(curso.getCodigo());
        CursoF.setDescripcion(curso.getDescripcion());
        
        
        return cursoRepository.save(CursoF);
        
    }

    @Override
    public void eliminarCurso(Long id) {
       
        var CursoF = cursoRepository.findById(id).get();
        
        cursoRepository.delete(CursoF);
        
        
    }
    
}
