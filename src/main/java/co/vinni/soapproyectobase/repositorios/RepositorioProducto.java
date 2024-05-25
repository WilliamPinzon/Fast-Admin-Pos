package co.vinni.soapproyectobase.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import co.vinni.soapproyectobase.entidades.Producto;

public interface RepositorioProducto extends JpaRepository<Producto, Long>, JpaSpecificationExecutor<Producto> {

	Optional<Producto> findById(Long id);
}

