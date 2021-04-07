package mx.uady.sicei.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class Alumno {
    
    // POJO: Plain Java Object
    // Validar aqui (opcional)
    @NotBlank(message = "La matricula no puede estar en blanco")
    private String matricula; // NO vacia - null or ""

    @NotBlank(message = "La matricula no puede estar en blanco")
    private String nombre; // No vacio - null or ""

    public Alumno() {
        System.out.println("un Alumno validado");
    }

    public Alumno(String matricula, String nombre) {
        this.matricula = matricula;
        this.nombre = nombre;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Alumno matricula(String matricula) {
        setMatricula(matricula);
        return this;
    }

    public Alumno nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " matricula='" + getMatricula() + "'" +
            ", nombre='" + getNombre() + "'" +
            "}";
    }

}
