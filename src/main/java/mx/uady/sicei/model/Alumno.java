package mx.uady.sicei.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class Alumno {
    
    @NotNull(message = "EL no puede estar en blanco")
    private Integer id;

    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombres;

    @NotBlank(message = "El apellidos no puede estar en blanco")
    private String apellidos;

    @NotBlank(message = "La matricula no puede estar en blanco")
    private String matricula;

    @NotNull(message = "El promedio no puede estar en blanco")
    private Integer promedio;

    public Alumno() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getPromedio() {
        return promedio;
    }

    public void setPromedio(Integer promedio) {
        this.promedio = promedio;
    }
}
