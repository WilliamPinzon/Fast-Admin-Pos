package co.vinni.soapproyectobase.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import co.vinni.soapproyectobase.entidades.PagoImpuesto;

public interface RepositorioPagoImpuesto extends JpaRepository<PagoImpuesto, Long>, JpaSpecificationExecutor<PagoImpuesto> {

}
