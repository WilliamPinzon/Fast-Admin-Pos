package co.vinni.soapproyectobase.controladores;

import java.security.Principal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.vinni.soapproyectobase.dto.ProductoDto;
import co.vinni.soapproyectobase.servicios.ServicioProductos;
import co.vinni.soapproyectobase.servicios.UsuarioServicio;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class ControladorProductos {
	
	private static final Logger logger = LogManager.getLogger(ControladorProductos.class);

	@Autowired
	ServicioProductos servicioProductos;
    @Autowired
    UsuarioServicio usuarioServicio;
    
//	@GetMapping("/")
//	public String inicioCotizaciones() {
//		return "index";
//	}
    
    @RequestMapping("nuevoProducto")
    public String mostrarFormulario(Model model){
    	ProductoDto productoDto = new ProductoDto();
        model.addAttribute("producto", productoDto);
        return "nuevoProducto";
    }
    
    @PostMapping("productos")
    public String registrarProducto(@ModelAttribute("producto") ProductoDto productoDto) {
    	servicioProductos.registrarProducto(productoDto);
        return "redirect:/nuevoProducto?exito";
    }
    
    @GetMapping({"/ProductosAdmin"})
    public String obtenercontribuyentes(Model modelo, Principal principal){
        logger.info("Verificando ");
        List<ProductoDto> productoDto = servicioProductos.obtenerProductos();
        
        String nombreUsuario = usuarioServicio.obtenerNombreUsuario(principal.getName());
        
        if(productoDto.isEmpty()) {
        	modelo.addAttribute("productos", servicioProductos.obtenerProductos());
        	modelo.addAttribute("nombreUsuario",nombreUsuario);
        	return "PrincipalAdmin";
        }else {
        	modelo.addAttribute("productos", servicioProductos.obtenerProductos());
        	modelo.addAttribute("nombreUsuario", nombreUsuario);
        	return "PrincipalAdmin";
        }
    }
    
    @GetMapping({"/index"})
    public String obtenerProductos(Model modelo, Principal principal){
        logger.info("Verificando ");
        List<ProductoDto> productoDto = servicioProductos.obtenerProductos();
        
        // Obtener el nombre del usuario de la base de datos
        String nombreUsuario = usuarioServicio.obtenerNombreUsuario(principal.getName());
        
        if(productoDto.isEmpty()) {
            modelo.addAttribute("productos", servicioProductos.obtenerProductos());
            modelo.addAttribute("nombreUsuario", nombreUsuario);
            return "index";
        } else {
            modelo.addAttribute("productos", servicioProductos.obtenerProductos());
            modelo.addAttribute("nombreUsuario", nombreUsuario);
            return "index";
        }
    }

    
    @GetMapping("/eliminarProducto/{id}")
    public String eliminarContribuyente(@PathVariable Long id) {
    	ProductoDto productoDto = servicioProductos.obtenerProductoPorId(id);
        
        if(id != null && id > 0 && productoDto != null) {
        	servicioProductos.eliminarProducto(id);
            return "redirect:/ProductosAdmin?delete";
        } else {
            return "redirect:/ProductosAdmin?error";
        }
    }

//    @GetMapping("/editarProducto/{id}")
//    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
//    	ProductoDto productoDto = servicioProductos.obtenerProductoPorId(id);
//        
//        if (productoDto != null) {
//            model.addAttribute("producto", productoDto);
//            return "editarProducto";
//        } else {
//            return "redirect:/ProductosAdmin?error";
//        }
//    }
    
    @GetMapping("/editarProducto/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
    	ProductoDto productoDto = servicioProductos.obtenerProductoPorId(id);
    	
    		model.addAttribute("producto", productoDto);
            return "editarProducto"; 
    }
    
    
    @PostMapping("/editarProducto")
    public String editarProdcuto(@ModelAttribute("producto") ProductoDto productoDto, Model model) {
    	
    	if(productoDto == null) {
    		return "redirect:/ProductosAdmin?error";
    	}else {
    		servicioProductos.editarProducto(productoDto);
            return "redirect:/ProductosAdmin?exito"; 
    	}
    	
    }
    
    @GetMapping("/{orderId}")
    public String showPaymentResult(@PathVariable String orderId) {
        // Aquí podrías realizar cualquier lógica adicional relacionada con el orderId, si es necesario.
        // Por ejemplo, podrías buscar información específica sobre la transacción asociada a ese orderId.

        // Devuelve el nombre de la plantilla HTML que deseas renderizar (sin la extensión .html).
        return "paymentResult";
    }
       
}
