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

import mx.uady.sicei.model.Maestro;
import mx.uady.sicei.service.MaestroService;



@RestController
@RequestMapping("/api")
public class MaestroRest {
    @Autowired
    private MaestroService maestroService;

    @GetMapping("/maestros")
    public ResponseEntity<List<Maestro>> getAlumnos() {
        return ResponseEntity.ok().body(maestroService.getMaestros());
    }

    @PostMapping("/maestros")
    public ResponseEntity<Maestro> crearMaestro( @Validated @RequestBody Maestro maestro) {
        Maestro maestroCreado = maestroService.crearMaestro(maestro);
        return new ResponseEntity<Maestro>(maestroCreado, HttpStatus.CREATED);
    }

    @PutMapping("/maestros/{id}")
    public ResponseEntity<Maestro> editarMaestro(@PathVariable Integer id, @Valid @RequestBody Maestro maestro) {
        Maestro maestroEditado = maestroService.editarMaestro(id, maestro);
        return new ResponseEntity<Maestro>(maestroEditado, HttpStatus.OK);
    }

    @GetMapping("/maestros/{id}")
    public ResponseEntity<Maestro> obtenerMaestro(@PathVariable Integer id) {
        Maestro maestro = maestroService.getMaestro(id);
        return new ResponseEntity<Maestro>(maestro, HttpStatus.OK);
    }

    @DeleteMapping("/maestros/{id}")
    public ResponseEntity<Void> eliminarMaestro(@PathVariable Integer id) {
        maestroService.eliminarMaestro(id);
        return ResponseEntity.ok().build();
    }
}
