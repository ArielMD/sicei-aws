package mx.uady.sicei.rest;

import java.util.List;


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

import mx.uady.sicei.model.Maestro;
import mx.uady.sicei.model.request.MaestroRequest;
import mx.uady.sicei.service.MaestroService;



@RestController
@RequestMapping("/api")
public class MaestroRest {
    @Autowired
    private MaestroService maestroService;

    @GetMapping("/profesores")
    public ResponseEntity<List<Maestro>> getAlumnos() {
        return ResponseEntity.ok().body(maestroService.getMaestros());
    }

    @PostMapping("/profesores")
    public ResponseEntity<Maestro> crearMaestro( @Validated @RequestBody MaestroRequest maestro) {
        Maestro maestroCreado = maestroService.crearMaestro(maestro);
        return new ResponseEntity<Maestro>(maestroCreado, HttpStatus.CREATED);
    }

    @PutMapping("/profesores/{id}")
    public ResponseEntity<Maestro> editarMaestro(@PathVariable Integer id, @Validated @RequestBody MaestroRequest maestro) {
        Maestro maestroEditado = maestroService.editarMaestro(id, maestro);
        return new ResponseEntity<Maestro>(maestroEditado, HttpStatus.OK);
    }

    @GetMapping("/profesores/{id}")
    public ResponseEntity<Maestro> obtenerMaestro(@PathVariable Integer id) {
        Maestro maestro = maestroService.getMaestro(id);
        return new ResponseEntity<Maestro>(maestro, HttpStatus.OK);
    }

    @DeleteMapping("/profesores/{id}")
    public ResponseEntity<Void> eliminarMaestro(@PathVariable Integer id) {
        maestroService.eliminarMaestro(id);
        return ResponseEntity.ok().build();
    }
}
