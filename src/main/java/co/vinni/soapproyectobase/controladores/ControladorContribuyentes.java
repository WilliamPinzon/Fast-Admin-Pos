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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import co.vinni.soapproyectobase.dto.ContribuyenteDto;
import co.vinni.soapproyectobase.dto.ProductoDto;
import co.vinni.soapproyectobase.servicios.ServicioContribuyentes;
import co.vinni.soapproyectobase.servicios.ServicioProductos;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class ControladorContribuyentes {
	
	private static final Logger logger = LogManager.getLogger(ControladorContribuyentes.class);

    @Autowired
    ServicioContribuyentes servicioContribuyentes;
    
    @Autowired
    ServicioProductos servicioProductos;
    
//	@GetMapping("/")
//	public String inicioCotizaciones() {
//		return "index";
//	}
    
    @RequestMapping("nuevoContribuyente")
    public String mostrarFormulario(Model model){
        ContribuyenteDto contribuyenteDto = new ContribuyenteDto();
        model.addAttribute("contribuyente", contribuyenteDto);
        return "nuevoContribuyente";
    }
    
    @PostMapping("contribuyentes")
    public String registrarContribuyente(@ModelAttribute("contribuyente") ContribuyenteDto contribuyenteDto) {
        servicioContribuyentes.registrarContribuyente(contribuyenteDto);
        return "redirect:/nuevoContribuyente?exito";
    }
    


    @GetMapping("/eliminarContribuyente/{id}")
    public String eliminarContribuyente(@PathVariable Long id) {
        ContribuyenteDto contribuyenteDto = servicioContribuyentes.obtenerContribuyentePorId(id);
        
        if(id != null && id > 0 && contribuyenteDto != null) {
            servicioContribuyentes.eliminarContribuyente(id);
            return "redirect:/Contribuyentes?delete";
        } else {
            return "redirect:/Contribuyentes?error";
        }
    }

    @GetMapping("/editarContribuyente/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        ContribuyenteDto contribuyenteDto = servicioContribuyentes.obtenerContribuyentePorId(id);
        
        if (contribuyenteDto != null) {
            model.addAttribute("contribuyente", contribuyenteDto);
            return "editarContribuyente";
        } else {
            return "redirect:/Contribuyentes?error";
        }
    }
       
}
