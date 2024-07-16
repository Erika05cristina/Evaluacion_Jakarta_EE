package ec.edu.ups.edu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tbl_planilla")
public class Planilla {
	
	@Id
	private String pla_codigo;
	
	@Column(name="pla_mes")
	private String per_cedula;
	
	@Column(name="pla_ciudad")
	private String pla_ciudad;
	
	@Column(name="pla_consumo")
	private String pla_consumo;
	
	//Relacion
	@ManyToOne
	@JoinColumn(name="fk_Usuario")
	private Usuario usuario;

	public String getPla_codigo() {
		return pla_codigo;
	}

	public void setPla_codigo(String pla_codigo) {
		this.pla_codigo = pla_codigo;
	}

	public String getPer_cedula() {
		return per_cedula;
	}

	public void setPer_cedula(String per_cedula) {
		this.per_cedula = per_cedula;
	}

	public String getPla_ciudad() {
		return pla_ciudad;
	}

	public void setPla_ciudad(String pla_ciudad) {
		this.pla_ciudad = pla_ciudad;
	}

	public String getPla_consumo() {
		return pla_consumo;
	}

	public void setPla_consumo(String pla_consumo) {
		this.pla_consumo = pla_consumo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
	
}
