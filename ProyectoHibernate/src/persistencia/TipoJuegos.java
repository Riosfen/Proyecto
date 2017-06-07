package persistencia;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
	
@Entity
@Table(name = "tipo_juego")
@SuppressWarnings("serial")
public class TipoJuegos implements Serializable {
	
	@Id
	@NotNull
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private TipoJuego tipo;

	@ManyToOne
	@JoinColumn(name = "ID_JUEGO")
	private Juego juego;
	
	
	public TipoJuegos(){}
	
	public TipoJuegos(TipoJuego tipo, Juego juego){
		this.tipo = tipo;
		this.juego = juego;
		
	}
		
	public int getId() {
		return id;
	}
	public Juego getIdJuego() {
		return juego;
	}
	public TipoJuego getTipo() {
		return tipo;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setIdJuego(Juego juego) {
		this.juego = juego;
	}
	public void setTipo(TipoJuego tipo) {
		this.tipo = tipo;
	}
	
}
