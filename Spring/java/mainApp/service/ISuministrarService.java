package mainApp.service;

import java.util.List;
import mainApp.dto.Suministrar;

public interface ISuministrarService {

	public List<Suministrar> listarSuministrar();
	
	public Suministrar buscarPorID(int codigo);
	
	public Suministrar añadirSumin(Suministrar suministrar);
	
	public Suministrar actualizarSumi(Suministrar suministrar);
	
	public void Eliminar (int codigo);
}
