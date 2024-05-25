package co.vinni.soapproyectobase.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ProductoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String nombre;
	private String tipoProducto;
	private long valorUnitario;
	private long stock;
	private LocalDateTime fechaDeRegistro = LocalDateTime.now();
	private LocalDateTime fechaDeModificacion = LocalDateTime.now();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public long getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(long valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	public LocalDateTime getFechaDeRegistro() {
		return fechaDeRegistro;
	}

	public void setFechaDeRegistro(LocalDateTime fechaDeRegistro) {
		this.fechaDeRegistro = fechaDeRegistro;
	}

	public LocalDateTime getFechaDeModificacion() {
		return fechaDeModificacion;
	}

	public void setFechaDeModificacion(LocalDateTime fechaDeModificacion) {
		this.fechaDeModificacion = fechaDeModificacion;
	}

}
