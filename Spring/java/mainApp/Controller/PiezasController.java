package mainApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mainApp.dto.Piezas;
import mainApp.service.PiezasServiceImpl;

@RestController
@RequestMapping("/api")
public class PiezasController {
	
	@Autowired
	PiezasServiceImpl piezasServiceImpl;
	
	//LISTAR TODAS LAS PIEZAS
	@GetMapping("/piezas")
	public List<Piezas> listarPiezas(){
		return piezasServiceImpl.listarPiezas();
	}
	
	//AÑADIR PIEZAS 
	@PostMapping("/piezas")
	public Piezas añadirPiezas(@RequestBody Piezas piezas) {
		return piezasServiceImpl.GuardarPiezas(piezas);
	}
	
	//ACTUALIZAR PIEZA
	@PutMapping("/piezas/{codigo}")
	public Piezas ActualizarPieza(@PathVariable(name="codigo")int codigo, @RequestBody Piezas piezas) {
		
		Piezas Pieza_Seleccionada = new Piezas();
		Piezas Pieza_Actualizada = new Piezas();
		
		Pieza_Seleccionada= piezasServiceImpl.BuscarID(codigo);
		
		Pieza_Seleccionada.setNombre(piezas.getNombre());
		
		Pieza_Actualizada = piezasServiceImpl.ActualizarPieza(Pieza_Seleccionada);
		
		return Pieza_Actualizada;
	}
	
	//ELIMINAR PIEZA
	@DeleteMapping("piezas/{codigo}")
	public void eliminarPieza(@PathVariable(name="codigo")int codigo) {
		piezasServiceImpl.eliminarPieza(codigo);
	}	
	

}
