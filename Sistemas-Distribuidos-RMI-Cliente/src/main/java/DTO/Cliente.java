package DTO;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable {
		
	private String codigo;

	public Cliente(){
		super();
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
