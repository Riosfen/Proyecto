package persistencia;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "juego")
@SuppressWarnings("serial")
public class Juego implements Serializable {
	
	@Id
	@NotNull
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@NotNull
	@Column(name = "NOMBRE")
	@Size(min = 3, max = 150)
	private String nombre;
	
	@NotNull
	@Max(99)
	@Min(0)
	@Column(name = "EDAD_MINIMA")
	private int edadMinima;

	@NotNull
	@Min(0)
	@Digits(integer=8, fraction = 2)
	@Column(name = "PRECIO")
	private double precio;
	
	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private TipoJuego tipoJuego;
	
	@NotNull
	@Min(0)
	@Column(name = "STOCK")
	private int stock;
	
	public Juego(){}
	
	public Juego(String nombre, int edadMinima, double precio, TipoJuego tipoJuego, int stock){
		
		this.nombre = nombre;
		this.edadMinima = edadMinima;
		this.precio = precio;
		this.tipoJuego = tipoJuego;
		this.stock = stock;
		
	}
	
	public int getStock() {
		return stock;
	}
	public int getEdadMinima() {
		return edadMinima;
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public TipoJuego getTipoJuego() {
		return tipoJuego;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void setTipoJuego(TipoJuego tipoJuego) {
		this.tipoJuego = tipoJuego;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
