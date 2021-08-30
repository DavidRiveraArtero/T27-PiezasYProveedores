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
@Table(name="piezas")
public class Piezas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="codigo")
	private List<Suministrar> Suministrar;
	
	//CONSTRUCTORES
	public Piezas() {
		
	}
	
	public Piezas(int codigo, String nombre) {
		this.codigo=codigo;
		this.nombre=nombre;
	}
	
	//GETTERS Y SETTERS

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//TOSTRING
	@Override
	public String toString() {
		return "Piezas [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
	
	
}
