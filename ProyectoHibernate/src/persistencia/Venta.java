package persistencia;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="venta")
@SuppressWarnings("serial")
public class Venta implements Serializable{

	@Id
	@NotNull
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@NotNull
	@Column(name="FECHA")
	@Temporal(TemporalType.DATE)
	private Date fechaVenta;

	@ManyToOne
	@JoinColumn(name="ID_CLIENTE")
	private Cliente cliente;
	
	@OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="ID_VENTA")
	private List<LineaVenta> lineaVentas;
	
	
	public Venta(){
		this.fechaVenta = new Date();}
	
	public Venta(Cliente cliente, List<LineaVenta> lineaVentas){
		this.cliente = cliente;
		this.lineaVentas = lineaVentas;
		this.fechaVenta = new Date();
	}
	
	public List<LineaVenta> getLineaVentas() {
		return lineaVentas;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public int getId() {
		return id;
	}
	
	public void setLineaVentas(List<LineaVenta> lineaVentas) {
		this.lineaVentas = lineaVentas;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
}
