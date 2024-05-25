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
@Entity(name = "Vehiculo")
@Table(name = "VEHICULOS")
public class Vehiculo implements Serializable{
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VEHICULOS")
    @SequenceGenerator(name = "SEQ_VEHICULOS", sequenceName = "SEQ_VEHICULOS", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private long id;
    
    @Column(name = "PROPIETARIO", nullable = false)
	private int idPropietario;
    
    @Column(name = "TIPO", nullable = false)
	private String tipo;
    
    @Column(name = "MARCA", nullable = false)
	private String marca;
    
    @Column(name = "MODELO", nullable = false)
	private long modelo;
    
    @Column(name = "PLACA", nullable = false)
	private String placa;
    
    @Column(name = "VALOR_COMERCIAL", nullable = false)
    private double valorComercial;
    
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
	
	@PreUpdate
	public void beforeUpdate() {
		fechaDeModificacion = LocalDateTime.now();
	}
	

}
