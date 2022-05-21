
package mx.uady.sicei.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.uady.sicei.model.Maestro;

@Repository
public interface MaestroRepository extends CrudRepository<Maestro, Integer>{    
}