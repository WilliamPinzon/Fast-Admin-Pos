package co.vinni.soapproyectobase.controladores;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.vinni.soapproyectobase.servicios.UsuarioServicio;

@Controller
public class RegistroControlador {

	@Autowired
	private UsuarioServicio servicio;
	
	@GetMapping("login")
	public String iniciarSesion() {
		return "login";
	}
	
	@GetMapping("/")
	public String verPaginaDeInicio(Model modelo, Principal principal) {
		modelo.addAttribute("usuarios", servicio.listarUsuarios());
		modelo.addAttribute("nombreUsuario", principal.getName());
		return "index";
	}
}
