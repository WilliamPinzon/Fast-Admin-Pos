package co.vinni.soapproyectobase.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import co.vinni.soapproyectobase.entidades.Vehiculo;

public interface RepositorioVehiculo extends JpaRepository<Vehiculo, Long>, JpaSpecificationExecutor<Vehiculo> {

	Optional<Vehiculo> findByPlaca(String placa);

}
