package Implementacion;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import RMI_Interfaces.IPersistencia;

public class VentaImpl extends UnicastRemoteObject  implements IPersistencia {

	private static final long serialVersionUID = 1L;

	public VentaImpl() throws RemoteException {
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
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Object> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
