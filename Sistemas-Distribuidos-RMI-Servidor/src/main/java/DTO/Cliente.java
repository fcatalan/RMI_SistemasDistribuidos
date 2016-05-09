package DTO;

public class Cliente extends Persona {
		
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
