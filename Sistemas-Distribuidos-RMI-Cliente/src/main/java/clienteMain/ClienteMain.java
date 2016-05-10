package clienteMain;

import java.util.ArrayList;

import rmi.ConexionCliente;
import DTO.Cliente;
import DTO.Usuario;
import RMI_Interfaces.*;

public class ClienteMain {
	
    public static int Puerto = 2014;
    public static String IPServer = "localhost";                
    public static String usuarioRefRemoto = "UsuarioRemoto";    
    public static String clienteRefRemota = "ClienteRemoto";    
    
    
    public ClienteMain() {
       
    }
    
   public static void main(String[] args)
   {
	   ISesion usuarioRemoto; //Se crea un nuevo objeto llamado objetoRemoto
       IPersistencia clienteRemoto;  //Se crea un nuevo objeto llamado tableroRemoto

       //Se instancia el objeto que conecta con el servidor
       ConexionCliente conexion = new ConexionCliente();
       
       try{
    	   if (conexion.iniciarRegistro(IPServer, Puerto, usuarioRefRemoto) && conexion.iniciarRegistro(IPServer, Puerto, clienteRefRemota)){
    		   
    		   //Se obtiene la referencia al objeto remoto
               usuarioRemoto = conexion.getUsuario();
               clienteRemoto = conexion.getCliente();
    		   
    		Usuario usuario = new Usuario();
    		usuario.setNombreUsuario("fcatalan");
    		usuario.setContrasena("12345");
    		
    		if(usuarioRemoto.iniciarSesion(usuario))
    		{
    			System.out.println("Conecto");
    			  			
    			ArrayList<Object> lsCliente = clienteRemoto.listarAll();
    			
    			for(Object cli : lsCliente){    				
    				Cliente c =	  (Cliente)cli;
    				System.out.println("Cliente: " +c.getNombre() + " " + c.getApellidoPaterno() + " " + c.getApellidoMaterno() );
    			}	
    		}else
    			System.out.println("El usuario o la contraseña son invalido.");    		
    	   }else{
    		   System.out.println("No se pudo realizar la conexión con el servidor.");   
    	   }
       }catch(Exception e){
    	   System.out.println(e);
       }
   }

}
