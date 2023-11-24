package pe.cibertec.ProyectoFinal.ApiCurso.dto;

import lombok.Data;
import pe.cibertec.ProyectoFinal.ApiCurso.entity.Turno;

@Data

public class CursoDTO {

    private Long id;
    private String nombre;
    private Long codigo;
    private String descripcion;
    private Turno turno;

}
