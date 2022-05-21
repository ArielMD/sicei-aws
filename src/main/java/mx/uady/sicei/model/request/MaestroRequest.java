package mx.uady.sicei.model.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class MaestroRequest {

    @NotNull(message = "El numero de empleado no puede estar en blanco")
    private Integer numeroEmpleado;

    @NotBlank(message = "los nombre no puede estar en blanco")
    private String nombres;

    @NotBlank(message = "Los apellidos no puede estar en blanco")
    private String apellidos;

    @NotNull(message = "Las horas de clase no puede estar en blanco")
    private Integer horasClase;

    public MaestroRequest() {
    }

    public Integer getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(Integer numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
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

    public Integer getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(Integer horasClase) {
        this.horasClase = horasClase;
    }
}
