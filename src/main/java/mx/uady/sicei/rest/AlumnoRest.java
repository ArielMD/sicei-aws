package mx.uady.sicei.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.uady.sicei.model.Alumno;
import mx.uady.sicei.service.AlumnoService;

@RestController // Metaprogramacion
@RequestMapping("/api")
public class AlumnoRest {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/alumnos") // Verbo GET, URL: uady.mx/api/alumnos
    public ResponseEntity<List<Alumno>> getAlumnos() {
        return ResponseEntity.ok().body(alumnoService.getAlumnos());
    }

    @PostMapping("/alumnos") // ? /alumnos/crear
    public ResponseEntity<Alumno> crearAlumno( @Validated @RequestBody Alumno alumno) {
        Alumno alumnoCreado = alumnoService.crearAlumno(alumno);
        return ResponseEntity.ok().body(alumnoCreado);
    }

    // Path Paramater
    @PutMapping("/alumnos/{matricula}") // PUT /alumnos/1001930
    public ResponseEntity<Alumno> editarAlumno(@PathVariable String matricula, @Valid @RequestBody Alumno alumno) {
        Alumno alumnoEditado = alumnoService.editarAlumno(matricula, alumno);
        if(alumnoEditado != null){
            return new ResponseEntity<Alumno>(alumnoEditado, HttpStatus.OK);
        }else{
            return new ResponseEntity<Alumno>( alumnoEditado, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    // Path Paramater
    @GetMapping("/alumnos/{matricula}") // GET /alumnos/1001930
    public ResponseEntity<Alumno> obtenerAlumno(@PathVariable String matricula) {
        Alumno alumno = alumnoService.getAlumno(matricula);
        if(alumno != null){
            return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
        }else{
            return new ResponseEntity<Alumno>(alumno, HttpStatus.NOT_FOUND);
        }
    }

    // Path Paramater
    @DeleteMapping("/alumnos/{matricula}") // DELETE /alumnos/1001930
    public ResponseEntity<Boolean> eliminarAlumno(@PathVariable String matricula) {
        boolean result = alumnoService.eliminarAlumno(matricula);
        if (result) {
            return new ResponseEntity<Boolean>( result, HttpStatus.OK);
        }else{
            return new ResponseEntity<Boolean>( result, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}