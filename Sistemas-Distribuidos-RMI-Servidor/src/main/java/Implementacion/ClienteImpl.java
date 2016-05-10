package Implementacion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Conexion.ConexionPostgrest;
import DTO.Cliente;
import RMI_Interfaces.IPersistencia;

public class ClienteImpl implements IPersistencia {

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

	public ArrayList<Object> listar(Object obj) {
		String sql = "SELECT * FROM cliente c INNER JOIN persona p ON (c.idPersona = p.idPersona);";
		ConexionPostgrest con = new ConexionPostgrest();
		ResultSet rs = con.conexion(sql);	
		
		try{
			Cliente cli = new Cliente();
			ArrayList<Object> a = new ArrayList<Object>();

			while(rs.next()){
				cli.setId(rs.getInt(1));
				cli.setCodigo(rs.getString(3));
				cli.setNombre(rs.getString(5));
				
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			return null;
		}	
		return null;
	}

}
