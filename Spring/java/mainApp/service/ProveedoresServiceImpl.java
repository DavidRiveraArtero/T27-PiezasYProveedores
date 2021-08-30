package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dto.Proveedores;
import mainApp.dao.IProveedoresDAO;

@Service
public class ProveedoresServiceImpl implements IProveedoresService {

	@Autowired
	IProveedoresDAO iProveedoresDAO;
	
	//BUSCAR PROVEEDORES
	public List<Proveedores> ListarProveedores(){
		return iProveedoresDAO.findAll();
	}
	
	//BUSCAR POR ID
	public Proveedores BuscarID(char id) {
		return iProveedoresDAO.findById((int) id).get();
	}
	
	//GUARDAR PROOVEDOR
	public Proveedores guardarProveedor(Proveedores proveedores) {
		return iProveedoresDAO.save(proveedores);
	}
	
	//ACTUALIZAR PROOVEDORES
	public Proveedores actualizarProveedores(Proveedores proveedores) {
		return iProveedoresDAO.save(proveedores);
	}
	
	//ELIMINAR PROVEEDORES
	public void eliminarProveedor(char id) {
		iProveedoresDAO.deleteById((int) id);
	} 
	
}
