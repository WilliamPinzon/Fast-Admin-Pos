package co.vinni.soapproyectobase.servicios;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.vinni.soapproyectobase.dto.ContribuyenteDto;
import co.vinni.soapproyectobase.entidades.Contribuyente;
import co.vinni.soapproyectobase.repositorios.RepositorioContribuyente;

@Service
public class ServicioContribuyentes implements Serializable {
	
	private  ModelMapper modelMapper = new ModelMapper();

	@Autowired
    RepositorioContribuyente repositorioContribuyente;
	
    public void registrarContribuyente(ContribuyenteDto contribuyenteDto) {
    	repositorioContribuyente.save(modelMapper.map(contribuyenteDto, Contribuyente.class));
    }
    
    public List<ContribuyenteDto> obtenerContribuyentes() {
        TypeToken<List<ContribuyenteDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repositorioContribuyente.findAll(), typeToken.getType());
    }
    
    public void eliminarContribuyente(Long id) {
    	repositorioContribuyente.deleteById(id);
    }
    
    public ContribuyenteDto obtenerContribuyentePorId(Long id) {
        Optional<Contribuyente> contribuyenteOptional = repositorioContribuyente.findById(id);
        if (contribuyenteOptional.isPresent()) {
            Contribuyente contribuyente = contribuyenteOptional.get();
            return convertirAContribuyenteDto(contribuyente);
        } else {
            return null;
        }
    }
    
    public ContribuyenteDto obtenerContribuyentePorDocumento(Long documento) {
        Optional<Contribuyente> contribuyenteOptional = repositorioContribuyente.findBydocumento(documento);
        if (contribuyenteOptional.isPresent()) {
            Contribuyente contribuyente = contribuyenteOptional.get();
            return convertirAContribuyenteDto(contribuyente);
        } else {
            return null;
        }
    }

    private ContribuyenteDto convertirAContribuyenteDto(Contribuyente contribuyente) {
        ContribuyenteDto contribuyenteDto = new ContribuyenteDto();
        contribuyenteDto.setId(contribuyente.getId());
        contribuyenteDto.setNombre(contribuyente.getNombre());
        contribuyenteDto.setTipoDocumento(contribuyente.getTipoDocumento());
        contribuyenteDto.setDocumento(contribuyente.getDocumento());
        contribuyenteDto.setTelefono(contribuyente.getTelefono());
        contribuyenteDto.setDireccion(contribuyente.getDireccion());
        contribuyenteDto.setCorreo(contribuyente.getCorreo());
        return contribuyenteDto;
    }
    
    public void editarContribuyente(ContribuyenteDto contribuyenteDto) {
        Long id = contribuyenteDto.getId();
        Optional<Contribuyente> contribuyenteOptional = repositorioContribuyente.findById(id);

        if (contribuyenteOptional.isPresent()) {
            Contribuyente contribuyenteExistente = contribuyenteOptional.get();
            contribuyenteExistente.setId(contribuyenteDto.getId());
            contribuyenteExistente.setNombre(contribuyenteDto.getNombre());
            contribuyenteExistente.setTipoDocumento(contribuyenteDto.getTipoDocumento());
            contribuyenteExistente.setDocumento(contribuyenteDto.getDocumento());
            contribuyenteExistente.setTelefono(contribuyenteDto.getTelefono());
            contribuyenteExistente.setDireccion(contribuyenteDto.getDireccion());
            contribuyenteExistente.setCorreo(contribuyenteDto.getCorreo());

            repositorioContribuyente.save(contribuyenteExistente);
        } else {
        	
        }
    }

}
