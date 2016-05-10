package clienteMain;

import java.util.ArrayList;

import rmi.ConexionCliente;
import DTO.Cliente;
import DTO.Usuario;
import RMI_Interfaces.*;

public class ClienteMain {
	
    public static int Puerto = 2014;                            //Número del puerto que está alojado el servidor
    public static String IPServer = "localhost";                //Dirección IP del servidor, la cual podría utilizarse por defecto el localhost
    public static String usuarioRefRemoto = "UsuarioRemoto";    // Nombre del objeto subido
    public static String clienteRefRemota = "ClienteRemoto";    // Nombre del objeto subido
    
    
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
    				System.out.println(c.getNombre());
    			}    			
    		}else
    			System.out.println("El usuario o la contraseña son invalido");
    		
    	   }
       }catch(Exception e){
    	   System.out.println(e);
       }
   }

}
