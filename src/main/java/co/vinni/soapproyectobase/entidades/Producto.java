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
@Entity(name = "Producto")
@Table(name = "PRODUCTOS")
public class Producto implements Serializable {
	
    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCTOS")
    @SequenceGenerator(name = "SEQ_PRODUCTOS", sequenceName = "SEQ_PRODUCTOS", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private long id;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "TIPOPRODUCTO", nullable = false)
    private String tipoProducto;
    
    @Column(name = "VALORUNITARIO", nullable = false)
    private long valorUnitario;
    
    @Column(name = "STOCK", nullable = false)
    private long stock;
    
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
	
	@PreUpdate
	public void beforeUpdate() {
		fechaDeModificacion = LocalDateTime.now();
	}

}