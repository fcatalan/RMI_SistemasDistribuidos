package RMI_Interfaces;

import java.util.ArrayList;

public interface IPersistencia {
	public Object consultar(Object obj);
	public Boolean update(Object obj);
	public Boolean eliminar(Object obj);
	public ArrayList<Object> listar(Object obj);
}
