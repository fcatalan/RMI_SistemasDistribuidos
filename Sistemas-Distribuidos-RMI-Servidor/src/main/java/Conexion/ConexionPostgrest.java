package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionPostgrest {

	public ResultSet conexion(String sql){
		String clave= "8764h758";
		
		ResultSet rs = null;
		
		try {
			//CLASE USADA PARA EL DRIVER
			Class.forName("org.postgresql.Driver");
			//RUTA DE LA BASE DE DATOS
			String  url="jdbc:postgresql://localhost:5432/sistemaDistribuido";
			//CONECCION A LA BASE DE DATOS
			Connection cn= DriverManager.getConnection(url,"postgres",clave);
			//TRAE LOS DATOS
			Statement st = cn.createStatement();
			//SELECCIONA LA TABLA			
			rs = st.executeQuery(sql);			
		} catch (ClassNotFoundException ex) {
			// TODO: handle exception
			System.out.print("Error en el Driver");
			
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			
		}
		return rs;
	}
	

	/*
	private static void listar(ResultSet rs) throws SQLException{
		// TODO Auto-generated method stub
		System.out.print("");
		//TRAE LOS DATOS DE LA TABLA
		ResultSetMetaData meta = rs.getMetaData();
		
		System.out.print("\n");
		//SE ENCARGA DE RECORRRER FILAS POR FILAS
		while(rs.next()){
			//MUESTRA LA 1 COLUMNA DE LA FILA
			System.out.println("ID cliente: "+rs.getString(1)+"\t");
			//MUESTRA LA 2 COLUMNA DE LA FILA
			System.out.println("nombre: "+rs.getString(2)+"\t");
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String sql="SELECT * FROM persona ";
		
		ResultSet rs = conexion(sql);
		try{
			listar(rs);
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.print(e.getMessage());
			
		}
	}
	*/
	
}
