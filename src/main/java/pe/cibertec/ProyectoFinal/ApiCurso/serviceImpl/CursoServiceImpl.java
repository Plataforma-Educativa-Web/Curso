package pe.cibertec.ProyectoFinal.ApiCurso.serviceImpl;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.ProyectoFinal.ApiCurso.dao.CursoRepository;
import pe.cibertec.ProyectoFinal.ApiCurso.dto.CursoDTO;
import pe.cibertec.ProyectoFinal.ApiCurso.entity.Curso;
import pe.cibertec.ProyectoFinal.ApiCurso.entity.Turno;
import pe.cibertec.ProyectoFinal.ApiCurso.exception.EntityNotFoundException;
import pe.cibertec.ProyectoFinal.ApiCurso.service.CursoService;
import pe.cibertec.ProyectoFinal.ApiCurso.restClient.TurnoRestClient;

@Service
@Slf4j

public class CursoServiceImpl implements CursoService {

    @Autowired

    private CursoRepository cursoRepository;

    @Autowired

    private TurnoRestClient turnoRestClient;

    @Override
    public List<Curso> findAll() {
        log.info("Buscando todos los cursos");

        return (List<Curso>) cursoRepository.findAll();

    }

    public List<Turno> findAllTurno() {
        log.info("Buscando todos los turnos");

        return (List<Turno>) turnoRestClient.findAllTurno();

    }

    @Override
    public Curso findByCodigo(Long codigo) {
        log.info("Buscando curso por código: {}", codigo);

        return cursoRepository.findByCodigo(codigo).orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con el codigo" + codigo.toString()));

    }

    @Override
    public Curso buscarPorId(Long id) {
        log.info("Buscando curso por ID: {}", id);

        return cursoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con el ID" + id.toString()));

    }

    @Override
    public Curso findByNombre(String nombre) {
        log.info("Buscando curso por nombre: {}", nombre);

        return cursoRepository.findByNombre(nombre).orElseThrow(() -> new EntityNotFoundException("Curso no encontrado con el nombre" + nombre.toString()));

    }

    @Override
    public Curso agregarCurso(Curso curso) {
        log.info("Agregando nuevo curso: {}", curso);

        return cursoRepository.save(curso);

    }

    @Override
    public Curso actualizarCurso(Curso curso) {
        log.info("Actualizando curso con ID {}: {}", curso.getId(), curso);

        var CursoF = cursoRepository.findById(curso.getId()).get();
        CursoF.setNombre(curso.getNombre());
        CursoF.setCodigo(curso.getCodigo());
        CursoF.setDescripcion(curso.getDescripcion());

        return cursoRepository.save(CursoF);

    }

    @Override
    public void eliminarCurso(Long id) {
        log.info("Eliminando curso con ID: {}", id);

        var CursoF = cursoRepository.findById(id).get();

        cursoRepository.delete(CursoF);

    }

    @Override
    public CursoDTO findById(Long id) {
        log.info("Buscando curso por ID y obteniendo información adicional");

        Curso curso = cursoRepository.findById(id).get();

        Turno turno = turnoRestClient.findByNombre(curso.getNombreH());

        CursoDTO cursoDTO = new CursoDTO();

        cursoDTO.setId(curso.getId());
        cursoDTO.setNombre(curso.getNombre());
        cursoDTO.setCodigo(curso.getCodigo());
        cursoDTO.setDescripcion(curso.getDescripcion());
        cursoDTO.setTurno(turno);

        return cursoDTO;

    }

}
