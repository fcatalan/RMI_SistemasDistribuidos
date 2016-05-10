package Implementacion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.ConexionPostgrest;
import DTO.Cliente;
import RMI_Interfaces.IPersistencia;

public class ClienteImpl extends UnicastRemoteObject  implements IPersistencia {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteImpl() throws RemoteException {
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

	public ArrayList<Object> listar(Object obj) {
		return null;	
	}

	public ArrayList<Object> listarAll() {
		String sql = "SELECT * FROM cliente c INNER JOIN persona p ON (c.idPersona = p.idPersona);";
		//System.out.println("Listar cliente");
		ConexionPostgrest con = new ConexionPostgrest();
		ResultSet rs = con.conexion(sql);	
		
		try{
			
			ArrayList<Object> listaCliente = new ArrayList<Object>();

			while(rs.next()){
				Cliente cli = new Cliente();
				
				cli.setId(rs.getInt(1));
				cli.setCodigo(rs.getString(3));
				cli.setNombre(rs.getString(5));
				cli.setApellidoPaterno(rs.getString(6));
				cli.setApellidoMaterno(rs.getString(7));
				listaCliente.add(cli);
			}
			return listaCliente;
			
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			return null;
		}
	}

}
