package co.vinni.soapproyectobase.servicios;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.vinni.soapproyectobase.dto.VehiculoDto;
import co.vinni.soapproyectobase.entidades.Vehiculo;
import co.vinni.soapproyectobase.repositorios.RepositorioVehiculo;

@Service
public class ServicioVehiculos implements Serializable {
	
	private  ModelMapper modelMapper = new ModelMapper();

	@Autowired
    RepositorioVehiculo repositorioVehiculo;
	
    public void registrarVehiculo(VehiculoDto vehiculoDto) {
    	repositorioVehiculo.save(modelMapper.map(vehiculoDto, Vehiculo.class));
    }
    
    public List<VehiculoDto> obtenerVehiculos() {
        TypeToken<List<VehiculoDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repositorioVehiculo.findAll(), typeToken.getType());
    }
    
    public void eliminarVehiculo(Long id) {
    	repositorioVehiculo.deleteById(id);
    }
    
    public VehiculoDto obtenerVehiculoPorId(Long id) {
        Optional<Vehiculo> vehiculoOptional = repositorioVehiculo.findById(id);
        if (vehiculoOptional.isPresent()) {
            Vehiculo vehiculo = vehiculoOptional.get();
            return convertirAVehiculoDto(vehiculo);
        } else {
            return null;
        }
    }
    
    public VehiculoDto obtenerVehiculoPorPlaca(String placa) {
        Optional<Vehiculo> vehiculoOptional = repositorioVehiculo.findByPlaca(placa);
        if (vehiculoOptional.isPresent()) {
            Vehiculo vehiculo = vehiculoOptional.get();
            return convertirAVehiculoDto(vehiculo);
        } else {
            return null;
        }
    }

    private VehiculoDto convertirAVehiculoDto(Vehiculo vehiculo) {
    	VehiculoDto vehiculoDto = new VehiculoDto();
    	vehiculoDto.setId(vehiculo.getId());
    	vehiculoDto.setIdPropietario(vehiculo.getIdPropietario());
    	vehiculoDto.setTipo(vehiculo.getTipo());
    	vehiculoDto.setMarca(vehiculo.getMarca());
    	vehiculoDto.setModelo(vehiculo.getModelo());
    	vehiculoDto.setPlaca(vehiculo.getPlaca());
    	vehiculoDto.setValorComercial(vehiculo.getValorComercial());
        return vehiculoDto;
    }
    
    public void editarVehiculo(VehiculoDto vehiculoDto) {
        Long id = vehiculoDto.getId();
        Optional<Vehiculo> vehiculoOptional = repositorioVehiculo.findById(id);

        if (vehiculoOptional.isPresent()) {
        	Vehiculo vehiculoExistente = vehiculoOptional.get();
        	vehiculoExistente.setId(vehiculoDto.getId());
        	vehiculoExistente.setIdPropietario(vehiculoDto.getIdPropietario());
        	vehiculoExistente.setTipo(vehiculoDto.getTipo());
            vehiculoExistente.setMarca(vehiculoDto.getMarca());
            vehiculoExistente.setModelo(vehiculoDto.getModelo());
            vehiculoExistente.setPlaca(vehiculoDto.getPlaca());
            vehiculoExistente.setValorComercial(vehiculoDto.getValorComercial());

            repositorioVehiculo.save(vehiculoExistente);
        } else {
        	
        }
    }
}
