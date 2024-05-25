package co.vinni.soapproyectobase.seguridad;

import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import co.vinni.soapproyectobase.servicios.LoginAuditService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private LoginAuditService loginAuditService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        String username = authentication.getName();

        // Registrar el evento de inicio de sesión
        loginAuditService.logLogin(username);

        System.out.println("Authenticated User: " + username);
        System.out.println("Roles: " + roles);

        if (roles.contains("ROLE_ADMIN")) {
            response.sendRedirect("/ProductosAdmin");
        } else if (roles.contains("ROLE_USER")) {
            response.sendRedirect("/index");
        } else {
            response.sendRedirect("/login?error");
        }
    }
}
