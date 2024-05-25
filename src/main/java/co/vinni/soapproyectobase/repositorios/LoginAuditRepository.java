package co.vinni.soapproyectobase.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import co.vinni.soapproyectobase.entidades.LoginAudit;

public interface LoginAuditRepository extends JpaRepository<LoginAudit, Long>  {

}
