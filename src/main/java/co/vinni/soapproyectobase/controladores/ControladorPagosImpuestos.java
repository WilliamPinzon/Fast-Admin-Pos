package co.vinni.soapproyectobase.controladores;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.vinni.soapproyectobase.dto.PagoImpuestoDto;
import co.vinni.soapproyectobase.dto.VehiculoDto;
import co.vinni.soapproyectobase.servicios.ServicioContribuyentes;
import co.vinni.soapproyectobase.servicios.ServicioPagosImpuestos;
import co.vinni.soapproyectobase.servicios.ServicioVehiculos;
import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
public class ControladorPagosImpuestos {
	
	private static final Logger logger = LogManager.getLogger(ControladorPagosImpuestos.class);

    @Autowired
    ServicioPagosImpuestos servicioPagosImpuestos;
    
    @Autowired
    ServicioVehiculos servicioVehiculos;
    
    @Autowired
    ServicioContribuyentes servicioContribuyentes;

    @RequestMapping("nuevoPagoImpuesto")
    public String mostrarFormulario(Model model){
        PagoImpuestoDto pagoImpuestoDto = new PagoImpuestoDto();
        model.addAttribute("pagoImpuesto", pagoImpuestoDto);
        return "nuevoPago";
    }
    
    @PostMapping("registrarPago")
    public String registrarPagoImpuesto(@ModelAttribute("pagoImpuesto") PagoImpuestoDto pagoImpuestoDto, HttpSession session) {
    	
    	String placa = String.valueOf(pagoImpuestoDto.getIdvehiculo());
    	VehiculoDto vehiculoDto = servicioVehiculos.obtenerVehiculoPorPlaca(placa);
    	
    	
    	
    	if(vehiculoDto == null) {
    			return "redirect:/nuevoPagoImpuesto?errorVehiculo";
    	}else {
    		double valorComercial = vehiculoDto.getValorComercial();
    		long propietario = vehiculoDto.getIdPropietario();
    		
    		String porcentaje = "10%";
    		double valorBase = valorComercial;
    		
    		double valorTotal = valorBase * 0.1;
    		
    		pagoImpuestoDto.setPorcentaje(porcentaje);
    		pagoImpuestoDto.setValorBase(valorBase);
    		pagoImpuestoDto.setValorTotal(valorTotal);
    		pagoImpuestoDto.setIdContribuyente(vehiculoDto.getIdPropietario());
    		
    		session.setAttribute("anho", pagoImpuestoDto.getAnho());
    		session.setAttribute("valorTotal", valorTotal);
    		session.setAttribute("placa", placa);
    		session.setAttribute("propietario", propietario);
    		servicioPagosImpuestos.registrarPagoImpuesto(pagoImpuestoDto);

            return "redirect:/nuevoPagoImpuesto?exito";
    	}
    }

    
    @GetMapping({  "/pagosImpuestos"})
    public String obtenerPagos(Model modelo){
        logger.info("Verificando ");
        modelo.addAttribute("pagos", servicioPagosImpuestos.obtenerPagosImpuestos());
        return "pagos";
    }
    
    @GetMapping("/eliminarPagoImpuesto/{id}")
    public String eliminarContribuyente(@PathVariable Long id) {
    	PagoImpuestoDto pagoImpuestoDto = servicioPagosImpuestos.obtenerPagosImpuestosPorId(id);
        
        if(id != null && id > 0 && pagoImpuestoDto != null) {
        	servicioPagosImpuestos.eliminarPagoImpuesto(id);
            return "redirect:/pagosImpuestos?delete";
        } else {
            return "redirect:/pagosImpuestos?error";
        }
    }
    
    @GetMapping("/obtenerAnhos/{id}")
    public String obtenerAnho(@PathVariable("id") String id, Model modelo){
        String placa = String.valueOf(id);
        VehiculoDto vehiculoDto = servicioVehiculos.obtenerVehiculoPorPlaca(placa);
        
        if (vehiculoDto != null) {
            long anho = vehiculoDto.getModelo(); // Suponiendo que getModelo() devuelve el año del modelo del vehículo
            modelo.addAttribute("anho", anho);
        }
        
        // Redirigir de nuevo a la página donde se encontraba
        return "redirect:/nuevoPagoImpuesto";
    }
    
    @GetMapping("/verAnhosPlaca")
    public ResponseEntity<Long> verAnhosPlaca(@RequestParam("placa") String placa) {
        VehiculoDto vehiculo = servicioVehiculos.obtenerVehiculoPorPlaca(placa);
        long modelo = vehiculo.getModelo();
        return ResponseEntity.ok(modelo);
    }




	

}
