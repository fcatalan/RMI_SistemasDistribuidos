package servidor;

import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import Implementacion.*;
import RMI.ServidorRMI;

/**
 *
 * @author Daniel Wladdimiro Cottet
 * @title Taller de sistemas distribuidos - Clase 1
 */
public class Servidor {

    public static ServidorRMI servidor;
    public static int puerto = 2014;
    public static UsuarioImpl usuarioLocal;
    public static ClienteImpl clienteLocal;
    public static String usuarioRefRemoto = "UsuarioRemoto";
    public static String clienteRefRemota = "ClienteRemoto";

    static Logger logger;

    public static void main(String[] args) {
        logger = Logger.getLogger("Servidor");

        //Se inicializa el objeto, el cual podrá ser llamado remotamente
        try {
            usuarioLocal = new UsuarioImpl();
            clienteLocal = new ClienteImpl();
        } catch (RemoteException re) {
            //En caso de haber un error, es mostrado por un mensaje
            logger.log(Level.SEVERE, re.getMessage());
        }

        //El objeto se dejerá disponible para una conexión remota
        logger.log(Level.INFO, "Se va a conectar...");

        servidor = new ServidorRMI();
        if ((servidor.iniciarConexion(usuarioLocal, usuarioRefRemoto, puerto)) 
        && (servidor.iniciarConexion(clienteLocal, clienteRefRemota, puerto))) { //Resultado de la conexión
        //if(resultadoConexionUsuario) {
            logger.log(Level.INFO, "Se ha establecido la conexión correctamente");
        } else {
            logger.log(Level.INFO, "Ha ocurrido un error al conectarse");
        }

        System.out.println("Presione cualquier tecla y luego Enter para desconectar el servidor...");
        Scanner lector = new Scanner(System.in);
        lector.next();

        //En caso que presione una tecla el administrador, se detiene el servicio
        try {
            servidor.detenerConexion(usuarioRefRemoto);
            servidor.detenerConexion(clienteRefRemota);
        } catch (RemoteException re) {
            //En caso de haber un error, es mostrado por un mensaje
            logger.log(Level.SEVERE, re.getMessage());
        }

        System.exit(0);
    }
}
