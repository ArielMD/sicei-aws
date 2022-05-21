package mx.uady.sicei.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class AlumnoRequest {
    
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombres;

    @NotBlank(message = "El apellidos no puede estar en blanco")
    private String apellidos;

    @NotBlank(message = "La matricula no puede estar en blanco")
    private String matricula;

    @NotNull(message = "El promedio no puede estar en blanco")
    private float promedio;

    public AlumnoRequest() {
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

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }
}
