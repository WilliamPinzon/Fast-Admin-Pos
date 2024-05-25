package co.vinni.soapproyectobase.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Contribuyente")
@Table(name = "CONTRIBUYENTES")
public class Contribuyente implements Serializable {
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTRIBUYENTES")
    @SequenceGenerator(name = "SEQ_CONTRIBUYENTES", sequenceName = "SEQ_CONTRIBUYENTES", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private long id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "TIPODOCUMENTO", nullable = false)
    private String tipoDocumento;
    
    @Column(name = "DOCUMENTO", nullable = false)
    private long documento;
    
    @Column(name = "TELEFONO", nullable = false)
    private long telefono;
    
    @Column(name = "DIRECCION", nullable = false)
    private String direccion;
    
    @Column(name = "CORREO", nullable = false)
    private String correo;
    
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public long getDocumento() {
		return documento;
	}

	public void setDocumento(long documento) {
		this.documento = documento;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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