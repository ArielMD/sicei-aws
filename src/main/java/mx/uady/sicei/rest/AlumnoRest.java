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

@RestController
@RequestMapping("/api")
public class AlumnoRest {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/alumnos")
    public ResponseEntity<List<Alumno>> getAlumnos() {
        return ResponseEntity.ok().body(alumnoService.getAlumnos());
    }

    @PostMapping("/alumnos")
    public ResponseEntity<Alumno> crearAlumno( @Validated @RequestBody Alumno alumno) {
        Alumno alumnoCreado = alumnoService.crearAlumno(alumno);
        return new ResponseEntity<Alumno>(alumnoCreado, HttpStatus.CREATED);
    }

    @PutMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> editarAlumno(@PathVariable Integer id, @Valid @RequestBody Alumno alumno) {
        Alumno alumnoEditado = alumnoService.editarAlumno(id, alumno);
        return new ResponseEntity<Alumno>(alumnoEditado, HttpStatus.OK);
    }

    @GetMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> obtenerAlumno(@PathVariable Integer id) {
        Alumno alumno = alumnoService.getAlumno(id);
        return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
    }

    @DeleteMapping("/alumnos/{id}")
    public ResponseEntity<Void> eliminarAlumno(@PathVariable Integer id) {
        alumnoService.eliminarAlumno(id);
        return ResponseEntity.ok().build();
    }
}