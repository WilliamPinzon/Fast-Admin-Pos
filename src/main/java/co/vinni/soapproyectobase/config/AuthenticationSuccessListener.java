package co.vinni.soapproyectobase.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import co.vinni.soapproyectobase.servicios.LoginAuditService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticationSuccessListener implements AuthenticationSuccessHandler {

    @Autowired
    private LoginAuditService loginAuditService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String username = authentication.getName();
        loginAuditService.logLogin(username);

        response.sendRedirect("/"); // Redirigir a la página principal u otra página deseada
    }
}