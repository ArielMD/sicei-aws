package mx.uady.sicei.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uady.sicei.exception.NotFoundException;
import mx.uady.sicei.model.Maestro;
import mx.uady.sicei.model.request.MaestroRequest;
import mx.uady.sicei.repository.MaestroRepository;

@Service
public class MaestroService {

    @Autowired
    MaestroRepository maestroRepository;
    
    public List<Maestro> getMaestros() {
        List<Maestro> maestros =  new LinkedList<>();
        maestroRepository.findAll().iterator().forEachRemaining(maestros::add);
        return maestros;
    }

    public Maestro crearMaestro(MaestroRequest maestro) {
        Maestro nuevoMaestro = new Maestro();

        nuevoMaestro.setNombres(maestro.getNombres());
        nuevoMaestro.setApellidos(maestro.getApellidos());
        nuevoMaestro.setNumeroEmpleado(maestro.getNumeroEmpleado());
        nuevoMaestro.setHorasClase(maestro.getHorasClase());

        nuevoMaestro = maestroRepository.save(nuevoMaestro);
        return nuevoMaestro;
    }

    public Maestro editarMaestro(Integer id, MaestroRequest maestro){
        
        Maestro maestroEncontrado = buscarMaestro(id);

        maestroEncontrado.setNombres(maestro.getNombres());
        maestroEncontrado.setApellidos(maestro.getApellidos());
        maestroEncontrado.setHorasClase(maestro.getHorasClase());
        maestroEncontrado.setNumeroEmpleado(maestro.getNumeroEmpleado());

        maestroEncontrado = maestroRepository.save(maestroEncontrado);
            
        return maestroEncontrado;
    }

    public Maestro getMaestro(Integer id){
        Maestro maestroEncontrado = buscarMaestro(id);
        return maestroEncontrado;
    }

    public void eliminarMaestro(Integer id){
        Maestro maestroEncontrado = buscarMaestro(id);
        maestroRepository.delete(maestroEncontrado);
    }

    private Maestro buscarMaestro(Integer id){
        Optional<Maestro> maestro = this.maestroRepository.findById(id);
        if(!maestro.isPresent()) {
            throw new NotFoundException("El profesor solicitado no existe");
        }
        return maestro.get();
    }
}
