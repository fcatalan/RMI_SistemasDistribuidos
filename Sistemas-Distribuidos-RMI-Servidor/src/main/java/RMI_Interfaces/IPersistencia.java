package RMI_Interfaces;

public interface IPersistencia {
	public Object consultar(Object obj);
	public Boolean update(Object obj);
	public Boolean eliminar(Object obj);
}
