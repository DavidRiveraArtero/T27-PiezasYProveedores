package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IPiezasDAO;
import mainApp.dto.Piezas;

@Service
public class PiezasServiceImpl implements IPiezasService{

	@Autowired
	IPiezasDAO iPiezasDAO;
	
	//LISTAR PIEZAS
	public List<Piezas> listarPiezas(){
		return iPiezasDAO.findAll();
	}
	
	//LISTAR PIEZAS POR ID
	public Piezas BuscarID(int codigo) {
		return iPiezasDAO.findById(codigo).get();
	}
	
	//GUARDAR PIEZAS 
	public Piezas GuardarPiezas(Piezas piezas) {
		return iPiezasDAO.save(piezas);
	}
	
	//ACTUALIZAR PIEZA
	public Piezas ActualizarPieza(Piezas piezas) {
		return iPiezasDAO.save(piezas);
	}
	
	//ELIMINAR PIEZA
	public void eliminarPieza(int codigo) {
		iPiezasDAO.deleteById(codigo);
	}
}
