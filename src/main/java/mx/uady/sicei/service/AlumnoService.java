package mx.uady.sicei.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uady.sicei.exception.NotFoundException;
import mx.uady.sicei.model.Alumno;
import mx.uady.sicei.model.request.AlumnoRequest;
import mx.uady.sicei.repository.AlumnoRepository;

@Service
public class AlumnoService {
    @Autowired
    AlumnoRepository alumnoRepository;

    public List<Alumno> getAlumnos() {
        List<Alumno> alumnos = new LinkedList<>();

        alumnoRepository.findAll().iterator().forEachRemaining(alumnos::add);
        return alumnos;
    }
    
    public Alumno crearAlumno(AlumnoRequest alumno) {
        Alumno nuevoAlumno = new Alumno();
        nuevoAlumno.setNombres(alumno.getNombres());
        nuevoAlumno.setApellidos(alumno.getApellidos());
        nuevoAlumno.setMatricula(alumno.getMatricula());
        nuevoAlumno.setPromedio(alumno.getPromedio());

        nuevoAlumno = alumnoRepository.save(nuevoAlumno);

        return nuevoAlumno;
    }

    public Alumno editarAlumno(Integer id, AlumnoRequest alumno){
        
        Alumno alumnoEncontrado = buscarAlumno(id);

        if (alumnoEncontrado == null) {
            throw new NotFoundException("Alumno no encontrado");
        }

        alumnoEncontrado.setNombres(alumno.getNombres());
        alumnoEncontrado.setApellidos(alumno.getApellidos());
        alumnoEncontrado.setMatricula(alumno.getMatricula());
        alumnoEncontrado.setPromedio(alumno.getPromedio());
        
        alumnoEncontrado = alumnoRepository.save(alumnoEncontrado);
            
        return alumnoEncontrado;
    }

    public Alumno getAlumno(Integer id){
        return buscarAlumno(id);
    }

    public void eliminarAlumno(Integer id){
        Alumno alumno = buscarAlumno(id);
        alumnoRepository.delete(alumno);
    }

    private Alumno buscarAlumno(Integer id){
        Optional<Alumno> alumno = this.alumnoRepository.findById(id);
        if(!alumno.isPresent()) {
            throw new NotFoundException("El alumno solicitado no existe");
        }
        return alumno.get();
    }
}