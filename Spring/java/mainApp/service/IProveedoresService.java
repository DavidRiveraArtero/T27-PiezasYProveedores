package mainApp.service;

import java.util.List;
import mainApp.dto.Proveedores;
public interface IProveedoresService {

	public List<Proveedores> ListarProveedores();
	
	public Proveedores BuscarID(char id);
	
	public Proveedores guardarProveedor(Proveedores proveedores);
	
	public Proveedores actualizarProveedores(Proveedores proveedores);
	
	public void eliminarProveedor(char id);
}
