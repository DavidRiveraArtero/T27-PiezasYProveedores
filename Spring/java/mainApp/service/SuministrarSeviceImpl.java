package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.ISuministrarDAO;
import mainApp.dto.Suministrar;

@Service
public class SuministrarSeviceImpl {

	@Autowired
	ISuministrarDAO iSuministrarDAO;
	
	//LISTAR SUMINISTRAR
	public List<Suministrar> listarSuministrar(){
		return iSuministrarDAO.findAll();
	}
	
	//LISTAR POR ID
	public Suministrar buscarPorID(int codigo) {
		return iSuministrarDAO.findById(codigo).get();
	}
	
	//AÑADIR SUMINISTRAR
	public Suministrar añadirSumin(Suministrar suministrar) {
		return iSuministrarDAO.save(suministrar);
	}
	
	//ACTUALIZAR 
	public Suministrar actualizarSumi(Suministrar suministrar) {
		return iSuministrarDAO.save(suministrar);
	}
	
	//ELIMINAR
	public void Eliminar (int codigo) {
		iSuministrarDAO.deleteById(codigo);
	}
}
