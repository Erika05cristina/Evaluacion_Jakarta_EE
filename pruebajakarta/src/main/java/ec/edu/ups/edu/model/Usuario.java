package ec.edu.ups.edu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Tbl_usuario")
public class Usuario {
	@Id
	private String usu_id;
	@Column(name="usu_nombre")
	private String usu_nombre;
	@Column(name="usu_direccion")
	private String usu_direccion;
	@Column(name="usu_telefono")
	private String usu_telefono;
	
	public String getUsu_id() {
		return usu_id;
	}
	public void setUsu_id(String usu_id) {
		this.usu_id = usu_id;
	}
	public String getUsu_nombre() {
		return usu_nombre;
	}
	public void setUsu_nombre(String usu_nombre) {
		this.usu_nombre = usu_nombre;
	}
	public String getUsu_direccion() {
		return usu_direccion;
	}
	public void setUsu_direccion(String usu_direccion) {
		this.usu_direccion = usu_direccion;
	}
	public String getUsu_telefono() {
		return usu_telefono;
	}
	public void setUsu_telefono(String usu_telefono) {
		this.usu_telefono = usu_telefono;
	}
	
	

}
