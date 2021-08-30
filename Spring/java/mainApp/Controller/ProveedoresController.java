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


import mainApp.dto.Proveedores;
import mainApp.service.ProveedoresServiceImpl;

@RestController
@RequestMapping("/api")
public class ProveedoresController {
	
	@Autowired
	ProveedoresServiceImpl proveedoresServiceImpl;
	
	//LISTAR TODOS LOS PROVEEDORES
	@GetMapping("/proveedores")
	public List<Proveedores> listarProveedores(){
		return proveedoresServiceImpl.ListarProveedores();
	}
	
	//AÑADIR PROVEEDOR 
	@PostMapping("/proveedores")
	public Proveedores añadirProveedores(@RequestBody Proveedores proveedores) {
		return proveedoresServiceImpl.guardarProveedor(proveedores);
	}
	
	//ACTUALIZAR PROVEEDOR
	@PutMapping("/proveedores/{id}")
	public Proveedores ActualizarProveedores(@PathVariable(name="id")char id, @RequestBody Proveedores proveedores) {
		
		Proveedores proveedor_Seleccionada = new Proveedores();
		Proveedores proveedor_Actualizada = new Proveedores();
		
		proveedor_Seleccionada= proveedoresServiceImpl.BuscarID(id);
		
		proveedor_Seleccionada.setNombre(proveedores.getNombre());
		
		proveedor_Actualizada = proveedoresServiceImpl.actualizarProveedores(proveedor_Seleccionada);
		
		return proveedor_Actualizada;
	}
	
	//ELIMINAR PROVEEDOR
	@DeleteMapping("/proveedores/{id}")
	public void eliminarPieza(@PathVariable(name="id")char id) {
		proveedoresServiceImpl.eliminarProveedor(id);
	}	
	

}
