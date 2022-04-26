package mx.uady.sicei.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.uady.sicei.exception.NotFoundException;
import mx.uady.sicei.exception.UnprocessableEntityException;
import mx.uady.sicei.model.Alumno;

@Service
public class AlumnoService {

    private List<Alumno> alumnos = new LinkedList<>();
    
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public Alumno crearAlumno(Alumno alumno) {
        Alumno alumnoEncontrado = buscarAlumno(alumno.getId());

        if (alumnoEncontrado != null) {
            throw new UnprocessableEntityException("El alumno ya existe");
        }

        alumnos.add(alumno);
        return alumno;
    }

    public Alumno editarAlumno(Integer id, Alumno alumno){
        
        Alumno alumnoEncontrado = buscarAlumno(id);

        if (alumnoEncontrado == null) {
            throw new NotFoundException("Alumno no encontrado");
        }

        alumnoEncontrado.setNombres(alumno.getNombres());
        alumnoEncontrado.setApellidos(alumno.getApellidos());
        alumnoEncontrado.setMatricula(alumno.getMatricula());
        alumnoEncontrado.setPromedio(alumno.getPromedio());
            
        return alumnoEncontrado;
    }

    public Alumno getAlumno(Integer id){
        Alumno alumnoEncontrado = buscarAlumno(id);

        if (alumnoEncontrado == null) {
            throw new NotFoundException("Alumno no encontrado");
        }

        return alumnoEncontrado;
    }

    public boolean eliminarAlumno(Integer id){
        Alumno alumnoEncontrado = buscarAlumno(id);

        if (alumnoEncontrado == null) {
            throw new NotFoundException("Alumno no encontrado");
        }

        return  alumnos.removeIf(alumno -> id.equals(alumno.getId()));
    }

    private Alumno buscarAlumno(Integer id){
        return alumnos.stream().filter(alumno-> id.equals(alumno.getId()))
                               .findFirst()
                               .orElse(null);
    }
}