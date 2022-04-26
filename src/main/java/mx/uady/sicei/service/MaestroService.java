package mx.uady.sicei.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import mx.uady.sicei.exception.NotFoundException;
import mx.uady.sicei.exception.UnprocessableEntityException;
import mx.uady.sicei.model.Maestro;

@Service
public class MaestroService {
    private List<Maestro> maestros = new LinkedList<>();
    
    public List<Maestro> getMaestros() {
        return maestros;
    }

    public Maestro crearMaestro(Maestro maestro) {
        Maestro maestroEncontrado = buscarMaestro(maestro.getId());

        if (maestroEncontrado != null) {
            throw new UnprocessableEntityException("El Maestro ya existe");
        }

        maestros.add(maestro);
        return maestro;
    }

    public Maestro editarMaestro(Integer id, Maestro maestro){
        
        Maestro maestroEncontrado = buscarMaestro(id);

        if (maestroEncontrado == null) {
            throw new NotFoundException("Maestro no encontrado");
        }

        maestroEncontrado.setNombres(maestro.getNombres());
        maestroEncontrado.setApellidos(maestro.getApellidos());
        maestroEncontrado.setHorasClase(maestro.getHorasClase());
        maestroEncontrado.setNumeroEmpleado(maestro.getNumeroEmpleado());
            
        return maestroEncontrado;
    }

    public Maestro getMaestro(Integer id){
        Maestro maestroEncontrado = buscarMaestro(id);

        if (maestroEncontrado == null) {
            throw new NotFoundException("Maestro no encontrado");
        }

        return maestroEncontrado;
    }

    public boolean eliminarMaestro(Integer id){
        Maestro maestroEncontrado = buscarMaestro(id);

        if (maestroEncontrado == null) {
            throw new NotFoundException("Alumno no encontrado");
        }

        return  maestros.removeIf(maestro -> id.equals(maestro.getId()));
    }

    private Maestro buscarMaestro(Integer id){
        return maestros.stream().filter(maestro-> id.equals(maestro.getId()))
                               .findFirst()
                               .orElse(null);
    }
}
