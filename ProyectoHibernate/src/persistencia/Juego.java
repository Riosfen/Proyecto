package persistencia;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	@Digits(integer=2, fraction = 0)
	@Column(name = "EDAD_MINIMA")
	private int edadMinima;

	@NotNull
	@Min(0)
	@Digits(integer=8, fraction = 2)
	@Column(name = "PRECIO")
	private double precio;
	
	@OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="ID_JUEGO")
	private Set<TipoJuegos> tipoJuego;
	
	
	public Juego(){}
	
	public Juego(String nombre, int edadMinima, double precio, HashSet<TipoJuegos> tipoJuego){
		
		this.nombre = nombre;
		this.edadMinima = edadMinima;
		this.precio = precio;
		this.tipoJuego = tipoJuego;
		
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
	public Set<TipoJuegos> getTipoJuego() {
		return tipoJuego;
	}
	
	public void setTipoJuego(Set<TipoJuegos> tipoJuego) {
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
