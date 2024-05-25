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
public class PagoImpuestoDto implements Serializable {

    private long id;
	private long idContribuyente;
	private String idvehiculo;
	private String ciudad;
	private String anho;
	private double valorBase;
	private String porcentaje;
    private double ValorTotal;
	private LocalDateTime fechaDeRegistro = LocalDateTime.now();
	private LocalDateTime fechaDeModificacion = LocalDateTime.now();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdContribuyente() {
		return idContribuyente;
	}
	public void setIdContribuyente(long idContribuyente) {
		this.idContribuyente = idContribuyente;
	}
	public String getIdvehiculo() {
		return idvehiculo;
	}
	public void setIdvehiculo(String idvehiculo) {
		this.idvehiculo = idvehiculo;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getAnho() {
		return anho;
	}
	public void setAnho(String anho) {
		this.anho = anho;
	}
	public double getValorBase() {
		return valorBase;
	}
	public void setValorBase(double valorBase) {
		this.valorBase = valorBase;
	}
	public String getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}
	public double getValorTotal() {
		return ValorTotal;
	}
	public void setValorTotal(double valorTotal) {
		ValorTotal = valorTotal;
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
