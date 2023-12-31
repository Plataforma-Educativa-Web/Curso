package pe.cibertec.ProyectoFinal.ApiCurso.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Curso {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String nombre;
    private String nombreH;
    private Long codigo;
    private String descripcion; 
    
    
    
   
}
