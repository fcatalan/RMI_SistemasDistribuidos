package rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import RMI_Interfaces.*;

public class ConexionCliente {
	
	 private Registry registry;  //Registro de la conexión del usuario con el servidor
	    private boolean conectado;  //Estado de conexión del usuario con el servidor
	    private ISesion usuario; //Interface necesaria para la comunición con el objecto Usuario del servidor
	    private IPersistencia cliente; //Interface necesaria para la comunición con el objecto cliente del servidor

	    public ConexionCliente() {
	        this.conectado = false;
	        this.registry = null;
	        this.usuario = null;
	        this.cliente = null;
	    }
	    
	    public boolean iniciarRegistro(String IP, int Puerto, String nombreObjetoRemoto) throws RemoteException {
	        try {

	            //Se le otorga el permiso necesario para poder ejecutar las funciones correspondientes
	            java.security.AllPermission allPermision = new java.security.AllPermission();
	            System.setProperty("java.security.policy", "rmi.policy");

	            //Se inicia RMI-Registry para el registro del objeto
	            try {
	                //Obtenemos el Registry del servidor RMI
	                registry = LocateRegistry.getRegistry(IP, Puerto);

	                //De existir algún error con el registro que se desea obtener del servidor, se mostrará un mensaje
	            } catch (RemoteException e) {
	                System.out.println(IP + ":" + Puerto);
	                System.out.println(e.getMessage());
	                System.out.println(e.toString());
	            }

	            //Vamos al Registry y miramos los Objeto que hay en "nombreObjRemoto" para poder usarlo.
	            if (nombreObjetoRemoto.equals("UsuarioRemoto")) {
	                usuario = (ISesion) registry.lookup(nombreObjetoRemoto);
	            } else if (nombreObjetoRemoto.equals("ClienteRemoto")) {
	                cliente = (IPersistencia) registry.lookup(nombreObjetoRemoto);
	            }

	            this.conectado = true;
	            return true;

	            //De existir algún error con la conexión al servidor, se mostrará un mensaje
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            System.out.println("Error: No se posee conexión");

	            this.conectado = false;
	            return false;
	        }

	    }

		public Registry getRegistry() {
			return registry;
		}

		public void setRegistry(Registry registry) {
			this.registry = registry;
		}

		public boolean isConectado() {
			return conectado;
		}

		public void setConectado(boolean conectado) {
			this.conectado = conectado;
		}

		public ISesion getUsuario() {
			return usuario;
		}

		public void setUsuario(ISesion usuario) {
			this.usuario = usuario;
		}

		public IPersistencia getCliente() {
			return cliente;
		}

		public void setCliente(IPersistencia cliente) {
			this.cliente = cliente;
		}

}
