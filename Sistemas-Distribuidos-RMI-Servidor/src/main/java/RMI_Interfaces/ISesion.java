package RMI_Interfaces;

import DTO.Usuario;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISesion extends Remote {
	public Boolean iniciarSesion(Usuario usuario);
	public Boolean cerrarSesion(Usuario usuario);
}
