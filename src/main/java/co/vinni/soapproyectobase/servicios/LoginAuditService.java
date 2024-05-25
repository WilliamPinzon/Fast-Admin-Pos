package co.vinni.soapproyectobase.servicios;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.vinni.soapproyectobase.entidades.LoginAudit;
import co.vinni.soapproyectobase.repositorios.LoginAuditRepository;

@Service
public class LoginAuditService {

    @Autowired
    private LoginAuditRepository loginAuditRepository;

    public void logLogin(String username) {
        LoginAudit audit = new LoginAudit(username, LocalDateTime.now());
        loginAuditRepository.save(audit);
        System.out.println("Auditoría guardada: " + audit);  // Registro de depuración
    }
    
    public List<LoginAudit> getAllAuditLogs() {
        return loginAuditRepository.findAll();
    }
}