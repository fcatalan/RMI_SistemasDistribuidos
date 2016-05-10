package Implementacion;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.*;
import DTO.Usuario;
import RMI_Interfaces.*;

public class UsuarioImpl implements IPersistencia, ISesion {

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
	
}
