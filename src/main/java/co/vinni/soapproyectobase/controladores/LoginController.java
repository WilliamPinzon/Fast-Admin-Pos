package co.vinni.soapproyectobase.controladores;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.vinni.soapproyectobase.servicios.LoginAuditService;
import co.vinni.soapproyectobase.servicios.UsuarioServicio;

@Controller
public class LoginController {
	
    @Autowired
    private LoginAuditService loginAuditService;
    
    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping("/audit")
    public String viewAuditLogs(Model model, Principal principal) {
    	String nombreUsuario = usuarioServicio.obtenerNombreUsuario(principal.getName());
        model.addAttribute("auditLogs", loginAuditService.getAllAuditLogs());
        model.addAttribute("nombreUsuario",nombreUsuario);
        return "audit";
    }

//    @Autowired
//    private UsuarioServicio usuarioServicio;
//
//    @GetMapping("/login")
//    public String login() {
//        org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        
//        // Verificar si el usuario tiene el rol "ADMIN"
//        if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
//            return "redirect:/login";
//        } else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
//            return "redirect:/index";
//        } else {
//            // Si el usuario no tiene ningún rol específico, puedes redirigirlo a una página de error o a una página predeterminada
//            return "redirect:/registro";
//        }
//    }
}
