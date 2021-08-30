package mainApp.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="proveedores")
public class Proveedores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private char id;
	
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="id")
	private List<Suministrar> Suministrar;
	
	//CONSTRUCTORES
	public Proveedores() {
		
		
	}
	
	
	//GETTERS Y SETTERS 
	public Proveedores(char id, String nombre) {
		this.id=id;
		this.nombre=nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(char id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//METODO TOSTRING
	@Override
	public String toString() {
		return "Proveedores [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
