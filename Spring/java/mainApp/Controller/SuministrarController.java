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

import mainApp.dto.Suministrar;
import mainApp.service.SuministrarSeviceImpl;

@RestController
@RequestMapping("/api")
public class SuministrarController {
	@Autowired
	SuministrarSeviceImpl suministrarSeviceImpl;
	
	
	
	//LISTAR TODAS LOS SUMINISTROS
		@GetMapping("/suministrar")
		public List<Suministrar> listarSumi(){
			return suministrarSeviceImpl.listarSuministrar();
		}
		
		//AÑADIR SUMINISTROS 
		@PostMapping("/suministrar")
		public Suministrar añadirSumi(@RequestBody Suministrar suministrar) {
			return suministrarSeviceImpl.añadirSumin(suministrar);
		}
		
		//ACTUALIZAR SUMINISTROS
		@PutMapping("/suministrar/{codigo}")
		public Suministrar ActualizarSumi(@PathVariable(name="codigo")int codigo, @RequestBody Suministrar suministrar) {
			
			Suministrar Sumi_Seleccionada = new Suministrar();
			Suministrar Sumi_Actualizada = new Suministrar();
			
			Sumi_Seleccionada= suministrarSeviceImpl.buscarPorID(codigo);
			
			Sumi_Seleccionada.setPrecio(suministrar.getPrecio());
			
			Sumi_Actualizada = suministrarSeviceImpl.actualizarSumi(Sumi_Seleccionada);
			
			return Sumi_Actualizada;
		}
		
		//ELIMINAR SUMINISTROS
		@DeleteMapping("/suministrar/{codigo}")
		public void eliminarPieza(@PathVariable(name="codigo")int codigo) {
			suministrarSeviceImpl.Eliminar(codigo);
		}	
}
