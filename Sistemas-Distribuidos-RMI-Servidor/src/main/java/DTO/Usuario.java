package DTO;

public class Usuario extends Persona {
	
	private String nombreUsuario;
	private String contrasena;
	
	public Usuario(){
		super();
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}	
}
