package clienteMain;

import java.util.ArrayList;
import java.util.Scanner;

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
    		   System.out.println("Bienvanido ingresar usuario");
    		Usuario usuario = new Usuario();
    		Scanner sc = new Scanner(System.in);
    		usuario.setNombreUsuario(sc.next());
    		
    		System.out.println("Ingresar contrase�a");
    		sc = new Scanner(System.in);
    		//usuario.setContrasena("12345");
    		
    		usuario.setContrasena(sc.next());
    		
    		if(usuarioRemoto.iniciarSesion(usuario))
    		{
    			System.out.println("Ha iniciado sesi�n, elija la opci�n.\n");
    			
    			int opcion = 0;
	    	while (opcion != 2) {
	    		System.out.println("Men� RMI\n1. Listar Clientes \n2. Salir\n");	
	    		
	    		/*
	    		ArrayList<Object> lsCliente = clienteRemoto.listarAll();
    			
    			for(Object cli : lsCliente){    				
    				Cliente c =	  (Cliente)cli;
    				System.out.println("Cliente: " +c.getNombre() + " " + c.getApellidoPaterno() + " " + c.getApellidoMaterno() );
    			}	*/
	    		
                 sc = new Scanner(System.in);
                 opcion = Integer.parseInt(sc.next());
                
	                if(opcion == 1)	
	                {
						ArrayList<Object> lsCliente = clienteRemoto.listarAll();
		    			System.out.println("Los clientes son:");
		    			for(Object cli : lsCliente){    				
		    				Cliente c =	  (Cliente)cli;
		    				System.out.println("Cliente: " +c.getNombre() + " " + c.getApellidoPaterno() + " " + c.getApellidoMaterno() );
		    			}
		    			System.out.println();
	                }else if(opcion == 2){
	                	System.out.println("Gracias por trabajar con nosotros");
	                }
    			}
	    	
    		}else
    			System.out.println("El usuario o la contrase�a son invalido.");    		
    	   }else{
    		   System.out.println("No se pudo realizar la conexi�n con el servidor.");   
    	   }
       }catch(Exception e){
    	   System.out.println("No se pudo realizar la conexi�n con el servidor.");   
    	  // System.out.println(e);
       }
   }

}
