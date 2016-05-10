package Implementacion;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.*;
import DTO.Usuario;
import RMI_Interfaces.*;

public class UsuarioImpl extends UnicastRemoteObject  implements IPersistencia, ISesion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public Object consultar(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean update(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean eliminar(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean iniciarSesion(Usuario usuario) {		
		String sql = "SELECT * FROM persona where nombre = '" + usuario.getNombreUsuario() + "' and contrasena = '" + usuario.getContrasena() + "';";
		ConexionPostgrest con = new ConexionPostgrest();		
		ResultSet rs = con.conexion(sql);
		try{
			return rs.first();
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			return false;
		}		
	}

	public Boolean cerrarSesion(Usuario usuario) {
		return false;
	}
	
	public ArrayList<Object> listar(Object obj) {
		return null;
	}

	public ArrayList<Object> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
