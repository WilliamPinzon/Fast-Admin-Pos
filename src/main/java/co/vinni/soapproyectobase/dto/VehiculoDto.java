package co.vinni.soapproyectobase.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VehiculoDto implements Serializable {

    private long id;
	private int idPropietario;
	private String tipo;
	private String marca;
	private long modelo;
	private String placa;
    private double valorComercial;
	private LocalDateTime fechaDeRegistro = LocalDateTime.now();
	private LocalDateTime fechaDeModificacion = LocalDateTime.now();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getIdPropietario() {
		return idPropietario;
	}
	public void setIdPropietario(int idPropietario) {
		this.idPropietario = idPropietario;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public long getModelo() {
		return modelo;
	}
	public void setModelo(long modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public double getValorComercial() {
		return valorComercial;
	}
	public void setValorComercial(double valorComercial) {
		this.valorComercial = valorComercial;
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
