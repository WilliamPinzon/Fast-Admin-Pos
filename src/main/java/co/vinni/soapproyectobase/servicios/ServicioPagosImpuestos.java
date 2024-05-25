package co.vinni.soapproyectobase.servicios;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.vinni.soapproyectobase.dto.ContribuyenteDto;
import co.vinni.soapproyectobase.dto.PagoImpuestoDto;
import co.vinni.soapproyectobase.dto.VehiculoDto;
import co.vinni.soapproyectobase.entidades.PagoImpuesto;
import co.vinni.soapproyectobase.entidades.Vehiculo;
import co.vinni.soapproyectobase.repositorios.RepositorioPagoImpuesto;

@Service
public class ServicioPagosImpuestos implements Serializable {
	
	private  ModelMapper modelMapper = new ModelMapper();

	@Autowired
    RepositorioPagoImpuesto repositorioPagoImpuesto;
	
    public void registrarPagoImpuesto(PagoImpuestoDto pagoImpuestoDto) {
    	repositorioPagoImpuesto.save(modelMapper.map(pagoImpuestoDto, PagoImpuesto.class));
    }
    
    public List<PagoImpuestoDto> obtenerPagosImpuestos() {
        TypeToken<List<PagoImpuestoDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repositorioPagoImpuesto.findAll(), typeToken.getType());
    }
    
    public void eliminarPagoImpuesto(Long id) {
    	repositorioPagoImpuesto.deleteById(id);
    }
    
    public PagoImpuestoDto obtenerPagosImpuestosPorId(Long id) {
        Optional<PagoImpuesto> pagoImpuesto1 = repositorioPagoImpuesto.findById(id);
        if (pagoImpuesto1.isPresent()) {
        	PagoImpuesto pagoImpuesto = pagoImpuesto1.get();
            return convertirAPagoImpuestoDto(pagoImpuesto);
        } else {
            return null;
        }
    }

    private PagoImpuestoDto convertirAPagoImpuestoDto(PagoImpuesto pagoImpuesto) {
    	PagoImpuestoDto pagoImpuestoDto = new PagoImpuestoDto();
    	pagoImpuestoDto.setId(pagoImpuesto.getId());
    	pagoImpuestoDto.setIdContribuyente(pagoImpuesto.getIdContribuyente());
    	pagoImpuestoDto.setIdvehiculo(pagoImpuesto.getIdvehiculo());
    	pagoImpuestoDto.setCiudad(pagoImpuesto.getCiudad());
    	pagoImpuestoDto.setAnho(pagoImpuesto.getAnho());
    	pagoImpuestoDto.setValorBase(pagoImpuesto.getValorBase());
    	pagoImpuestoDto.setPorcentaje(pagoImpuesto.getPorcentaje());
    	pagoImpuestoDto.setValorTotal(pagoImpuesto.getValorTotal());
        return pagoImpuestoDto;
    }
}
