package persistencia;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cliente")
@SuppressWarnings("serial")
public class Cliente implements Serializable {

	@Id
	@NotNull
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@NotNull
	@Column(name = "DNI")
	@Size(min = 9, max = 9)
	private String dni;

	@NotNull
	@Column(name = "NOMBRE")
	@Size(min = 3, max = 50)
	private String nombre;

	@NotNull
	@Column(name = "APELLIDO")
	@Size(min = 3, max = 50)
	private String apellido;

	@NotNull
	@Column(name = "FECHA_NACIMIENTO")
	@Past(message = "La fecha debe ser menor a la actual")
	private Date fechaNacimiento;

	@NotNull
	@Column(name = "TELEFONO")
	@Size(min = 9, max = 9)
	private String telefono;

	@NotNull
	@Column(name = "DIRECCION")
	@Size(min = 3, max = 150)
	private String direccion;

	@NotNull
	@Enumerated(EnumType.ORDINAL)
	private TipoSexo sexo;
	
	@OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name="ID_CLIENTE")
	private List<Venta> ventas;
	
	public Cliente(){};
	
	public Cliente (String dni, String nombre, String apellido, Date fechaNacimiento, String telefono, String direccion, TipoSexo sexo){
		
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.telefono = telefono;
		this.direccion = direccion;
		
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setSexo(TipoSexo sexo) {
		this.sexo = sexo;
	}
	
	public String getDireccion() {
		return direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public List<Venta> getVentas() {
		return ventas;
	}
	public String getApellido() {
		return apellido;
	}
	public String getDni() {
		return dni;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public TipoSexo getSexo() {
		return sexo;
	}
	
}
