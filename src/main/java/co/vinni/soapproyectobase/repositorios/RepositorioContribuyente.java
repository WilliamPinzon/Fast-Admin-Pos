package co.vinni.soapproyectobase.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import co.vinni.soapproyectobase.entidades.Contribuyente;

public interface RepositorioContribuyente extends JpaRepository<Contribuyente, Long>, JpaSpecificationExecutor<Contribuyente> {

	Optional<Contribuyente> findBydocumento(Long documento);
	
}

