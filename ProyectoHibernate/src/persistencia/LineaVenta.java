package persistencia;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="linea_venta")
@SuppressWarnings("serial")
public class LineaVenta implements Serializable {

	@Id
	@NotNull
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@NotNull
	@ManyToOne
	@JoinColumn(name="ID_JUEGO")
	private Juego juego;

	@ManyToOne
	@JoinColumn(name="ID_VENTA")
	private Venta venta;

	@NotNull
	@Column(name="CANTIDAD")
	private int cantidad;
	
	public LineaVenta(){}
	
	public LineaVenta(Juego juego, Venta venta, int cantidad){
		this.juego = juego;
		this.venta = venta;
		this.cantidad = cantidad;
	}
	
	public int getId() {
		return id;
	}
	public Juego getJuego() {
		return juego;
	}
	public Venta getVenta() {
		return venta;
	}
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setJuego(Juego juego) {
		this.juego = juego;
	}
	
}
