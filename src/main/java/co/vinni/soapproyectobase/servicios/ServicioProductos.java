package co.vinni.soapproyectobase.servicios;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.vinni.soapproyectobase.dto.ProductoDto;
import co.vinni.soapproyectobase.entidades.Producto;
import co.vinni.soapproyectobase.repositorios.RepositorioProducto;

@Service
public class ServicioProductos implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private  ModelMapper modelMapper = new ModelMapper();

	@Autowired
    RepositorioProducto repositorioProducto;
	
    public void registrarProducto(ProductoDto productoDto) {
    	repositorioProducto.save(modelMapper.map(productoDto, Producto.class));
    }
    
    public List<ProductoDto> obtenerProductos() {
        TypeToken<List<ProductoDto>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repositorioProducto.findAll(), typeToken.getType());
    }
    
    public void eliminarProducto(Long id) {
    	repositorioProducto.deleteById(id);
    }
    
    public ProductoDto obtenerProductoPorId(Long id) {
        Optional<Producto> productoOptional = repositorioProducto.findById(id);
        if (productoOptional.isPresent()) {
        	Producto producto = productoOptional.get();
            return convertirAProductoDto(producto);
        } else {
            return null;
        }
    }
    
    private ProductoDto convertirAProductoDto(Producto producto) {
    	ProductoDto productoDto = new ProductoDto();
    	
    	productoDto.setId(producto.getId());
    	productoDto.setNombre(producto.getNombre());
    	productoDto.setTipoProducto(producto.getTipoProducto());
    	productoDto.setValorUnitario(producto.getValorUnitario());
    	productoDto.setStock(producto.getStock());
    	
        return productoDto;
    }
    
    public void editarProducto(ProductoDto productoDto) {
    	
        Long id = productoDto.getId();
        Optional<Producto> productoOptional = repositorioProducto.findById(id);

        if (productoOptional.isPresent()) {
        	
        	Producto productoExistente = productoOptional.get();
        	productoExistente.setId(productoDto.getId());
        	productoExistente.setNombre(productoDto.getNombre());
        	productoExistente.setTipoProducto(productoDto.getTipoProducto());
        	productoExistente.setValorUnitario(productoDto.getValorUnitario());
        	productoExistente.setStock(productoDto.getStock());

        	repositorioProducto.save(productoExistente);
        	
        } else {
        	
        }
    }

}
