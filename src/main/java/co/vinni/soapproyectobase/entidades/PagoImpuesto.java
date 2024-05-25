package co.vinni.soapproyectobase.entidades;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PagoImpuesto")
@Table(name = "PAGOSIMPUESTOS")
public class PagoImpuesto implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PAGOSIMPUESTOS")
    @SequenceGenerator(name = "SEQ_PAGOSIMPUESTOS", sequenceName = "SEQ_PAGOSIMPUESTOS", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private long id;
	
	@Column(name = "ID_CONTRIBUYENTE", nullable = false)
	private long idContribuyente;
	
	@Column(name = "ID_VEHICULO", nullable = false)
	private String idvehiculo;
	
	@Column(name = "CIUDAD", nullable = false)
	private String ciudad;
	
	@Column(name = "ANHO", nullable = false)
	private String anho;
	
	@Column(name = "VALOR_BASE", nullable = false)
	private double valorBase;
	
	@Column(name = "PORCENTAJE", nullable = false)
	private String porcentaje;
	
	@Column(name = "VALOR_TOTAL", nullable = false)
    private double ValorTotal;
	
	@Column(name = "FECHA_DE_REGISTRO")
	private LocalDateTime fechaDeRegistro = LocalDateTime.now();

	@Column(name = "FECHA_DE_MODIFICACION")
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
	
	@PreUpdate
	public void beforeUpdate() {
		fechaDeModificacion = LocalDateTime.now();
	}

}
