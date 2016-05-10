package RMI_Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IPersistencia extends Remote {
	public Object consultar(Object obj) throws RemoteException;
	public Boolean update(Object obj) throws RemoteException;
	public Boolean eliminar(Object obj) throws RemoteException;
	public ArrayList<Object> listar(Object obj) throws RemoteException;
	public ArrayList<Object> listarAll() throws RemoteException;
}
