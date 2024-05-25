package co.vinni.soapproyectobase.servicios;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import co.vinni.soapproyectobase.dto.UsuarioRegistroDTO;
import co.vinni.soapproyectobase.entidades.Usuario;


public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();

	public String obtenerNombreUsuario(String name);
	
}
