package mx.uady.sicei.service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import mx.uady.sicei.model.Alumno;

@Service
public class AlumnoService {

    private List<Alumno> alumnos = new LinkedList<>();

    {
        alumnos.add(new Alumno("100001940", "Eduardo Rodriguez"));
        alumnos.add(new Alumno("100001941", "Eduardo"));
        alumnos.add(new Alumno("100001941", "Eduardo"));
    }
    
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public Alumno crearAlumno(Alumno alumno) {
        alumnos.add(alumno);
        return alumno;
    }

    public Alumno editarAlumno(String matricula,Alumno alumno){
        alumnos = alumnos.stream().map(a -> {
            if(matricula.equals(a.getMatricula())){
                a.setMatricula(alumno.getMatricula());
                a.setNombre(alumno.getNombre());
            }
            return a;
        }).collect(Collectors.toList());
        
        return buscarAlumno(alumno.getMatricula());
    }

    public Alumno getAlumno(String matricula){
        return buscarAlumno(matricula);
    }

    public boolean eliminarAlumno(String matricula){
        return  alumnos.removeIf(alumno -> matricula.equals(alumno.getMatricula()));
    }

    private Alumno buscarAlumno(String matricula){
        return alumnos.stream().filter(alumno-> matricula.equals(alumno.getMatricula()))
                               .findFirst()
                               .orElse(null);
    }
}