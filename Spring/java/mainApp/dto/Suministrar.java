package mainApp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="suministrar")
public class Suministrar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codigoPieza")
	private int codigoPieza;
		
	//PUEDE FALLAR
	@ManyToOne
	@JoinColumn(name="codigo")
	Piezas codigo;
	
	@Column(name="idProveedor")
	private char idProveedor;
	
	//PUEDE FALLAR
	@ManyToOne
	@JoinColumn(name="id")
	Proveedores id;
	
	@Column(name="precio")
	private int precio;

	
	
	//CONSTRUCTOR
	
	public Suministrar() {
		
	}
	
	public Suministrar(Piezas codigo, Proveedores id, int precio) {
		this.id=id;
		this.codigo=codigo;
		this.precio=precio;
		
	}

	//Getters y Setters
	public Piezas getCodigo() {
		return codigo;
	}

	public void setCodigo(Piezas codigo) {
		this.codigo = codigo;
	}

	public Proveedores getId() {
		return id;
	}

	public void setId(Proveedores id) {
		this.id = id;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	//METODO TO STRING

	@Override
	public String toString() {
		return "Suministrar [codigoPieza=" + codigoPieza + ", codigo=" + codigo + ", idProveedor=" + idProveedor
				+ ", id=" + id + ", precio=" + precio + "]";
	}

	
	
	
	
	
}
