package mx.uady.sicei.rest;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import mx.uady.sicei.model.Alumno;
import mx.uady.sicei.model.request.AlumnoRequest;
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
    public ResponseEntity<Alumno> crearAlumno(@Validated @RequestBody AlumnoRequest alumno) {
        Alumno alumnoCreado = alumnoService.crearAlumno(alumno);
        return new ResponseEntity<Alumno>(alumnoCreado, HttpStatus.CREATED);
    }

    @PutMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> editarAlumno(@PathVariable Integer id, @Valid @RequestBody AlumnoRequest alumno) {
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

    @PostMapping(value = "/alumnos/{id}/fotoPerfil", consumes = {
        MediaType.MULTIPART_FORM_DATA_VALUE,
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Alumno> uploadFile(@PathVariable Integer id, @RequestParam("foto") MultipartFile file)
            throws MalformedURLException, URISyntaxException {
        Alumno alumno = alumnoService.subirFotoPerfil(id, file);
        return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
    }
}