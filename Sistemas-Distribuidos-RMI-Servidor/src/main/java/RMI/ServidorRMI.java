package RMI;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

import RMI_Interfaces.ISesion;

public class ServidorRMI {
	
    private Registry registro;
    private boolean conectado;

    static Logger logger;

    public ServidorRMI() {
        this.conectado = false;
        this.registro = null;
        logger = Logger.getLogger(getClass().getName());
        logger.log(Level.INFO, "Se ha instanciado la clase Servidor RMI");
    }
   
    private void iniciarRegistro(int Puerto) throws RemoteException {
        try {
            registro = LocateRegistry.getRegistry(Puerto); //Obtiene el objeto remoto
            registro.list(); //Por lo que posteriormente, entrega una registro con la lista de objetos remotos

            conectado = true;
        } catch (RemoteException e) {
            registro = LocateRegistry.createRegistry(Puerto); //Se crear� el objeto a nivel de localhost
            registro.list();  //Por lo que posteriormente, entrega una registro con la lista de objetos remotos

            conectado = true;
        }
    }
    
  //Ingresa el objeto referenciado al registro del servidor, de tal manera
    //que pueda ser utilizado posteriormente de forma remota. Este objeto va a ser
    //gen�rico, debido que pueden ser de muchos tipos, en este caso Usuario o
    //Tablero, de tal manera que despu�s se castee el tipo de la clase.
    public boolean iniciarConexion(Object objeto, String nombre, int Puerto) {      
        try {
            this.registro = getRegistro(Puerto);

            //Para poder realizar el objeto remoto, deber� estar en el Registry
            //del servidor, por lo que con el m�todo rebind quedar� registrado
            //con el nombre de referencia del objeto y el objeto inicializado
            //que entr� por par�metro
                        
            /*
            //Es importante analizar que se castear� que tipo de implementaci�n es que la est� entrando
            if (objeto.getClass().equals(ImplementacionUsuario.class)){
                logger.log(Level.INFO, "Se agregara ".concat(nombre).concat(" con el objecto Usuario"));
                //De tal manera que aqu� se castee la interface que le corresponde
                registro.rebind(nombre, (Usuario) objeto);
            }
            else if (objeto.getClass().equals(ImplementacionTablero.class)){
                logger.log(Level.INFO, "Se agregara ".concat(nombre).concat(" con el objecto Tablero"));
                registro.rebind(nombre, (Tablero) objeto);
            }
            */
            //Nota: Esto tambi�n se podr�a realizar de otra manera, debido que 
            //se podr�an implementar dos interfaces a la misma implementaci�n.
            //De ser as�, esta forma no servir�a, debido que aqu� estamos
            //aplicando distintas implementaciones a distintas interfaces.
               
        } catch (RemoteException re) {
            //En caso de haber un error, es mostrado por un mensaje
            logger.log(Level.SEVERE, re.getMessage());
            return false;
        }
        return true;
    }
    
    
  //Quita del registro del servidor la referencia al objeto remoto
    public void detenerConexion(String nombreUsado) throws RemoteException {
        try {
            //Se saca de RMI Registry el objeto "Ejemplo-RMI"
            //El cual ya no estar� disponible para ser llamado remotamente
            registro.unbind(nombreUsado);
            conectado = false;
        } catch (NotBoundException ex) {
            //En caso de haber un error, es mostrado por un mensaje
            logger.log(Level.SEVERE, null, ex);
            conectado = true;
        }catch (AccessException ex) {
            //En caso de haber un error, es mostrado por un mensaje
            logger.log(Level.SEVERE, null, ex);
            conectado = true;
        }
    }

    public Registry getRegistro(int Puerto) throws RemoteException {
        if (this.registro == null) {
            iniciarRegistro(Puerto);
        }
        return registro;
    }

    public void setRegistro(Registry registro) {
        this.registro = registro;
    }

    public boolean getConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }
    
}
