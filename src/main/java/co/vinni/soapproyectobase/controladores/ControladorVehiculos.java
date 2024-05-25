package co.vinni.soapproyectobase.controladores;

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
import co.vinni.soapproyectobase.dto.VehiculoDto;
import co.vinni.soapproyectobase.servicios.ServicioContribuyentes;
import co.vinni.soapproyectobase.servicios.ServicioVehiculos;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class ControladorVehiculos {
	
	private static final Logger logger = LogManager.getLogger(ControladorVehiculos.class);

    @Autowired
    ServicioVehiculos servicioVehiculos;
    
    @Autowired
    ServicioContribuyentes servicioContribuyentes;
    
    @RequestMapping("nuevoVehiculo")
    public String mostrarFormulario(Model model){
        VehiculoDto vehiculoDto = new VehiculoDto();
        model.addAttribute("vehiculo", vehiculoDto);
        return "nuevoVehiculo";
    }
    
    @PostMapping("vehiculos")
    public String registrarVehiculo(@ModelAttribute("vehiculo") VehiculoDto vehiculoDto) {
    	long documento = vehiculoDto.getIdPropietario();
    	ContribuyenteDto contribuyenteDto = servicioContribuyentes.obtenerContribuyentePorDocumento(documento);
    	if(contribuyenteDto != null) {
    		servicioVehiculos.registrarVehiculo(vehiculoDto);
            return "redirect:/nuevoVehiculo?exito";
    	}else {
    		return "redirect:/nuevoVehiculo?error";
    	}
    }
    
    @GetMapping({"/vehiculos"})
    public String obtenerVehiculos(Model modelo){
        logger.info("Verificando ");
        modelo.addAttribute("vehiculos", servicioVehiculos.obtenerVehiculos());
        return "vehiculos";
    }
    
    @GetMapping("/eliminarVehiculo/{id}")
    public String eliminarVehiculo(@PathVariable Long id) {
    	VehiculoDto vehiculoDto = servicioVehiculos.obtenerVehiculoPorId(id);
        
        if(id != null && id > 0 && vehiculoDto != null) {
        	servicioVehiculos.eliminarVehiculo(id);
            return "redirect:/vehiculos?delete";
        } else {
            return "redirect:/vehiculos?error";
        }
    }
  


    @GetMapping("/editarVehiculo/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
    	VehiculoDto vehiculoDto = servicioVehiculos.obtenerVehiculoPorId(id);
    	
    		model.addAttribute("vehiculo", vehiculoDto);
            return "editarVehiculo"; 
    }
    
    
    @PostMapping("/editarVehiculo")
    public String editarVehiculo(@ModelAttribute("vehiculo") VehiculoDto vehiculoDto, Model model) {
    	
    	long idPropietario = vehiculoDto.getIdPropietario();
    	ContribuyenteDto contribuyenteDto = servicioContribuyentes.obtenerContribuyentePorDocumento(idPropietario);
    	
    	if(contribuyenteDto == null) {
    		return "redirect:/vehiculos?errorPropietario";
    	}else {
    		servicioVehiculos.editarVehiculo(vehiculoDto); 
            return "redirect:/vehiculos?exito"; 
    	}
    	
    }
}
