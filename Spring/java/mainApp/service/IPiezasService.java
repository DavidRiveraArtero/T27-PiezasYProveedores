package mainApp.service;
import java.util.List;
import mainApp.dto.Piezas;
public interface IPiezasService {
	public List<Piezas> listarPiezas();
	
	public Piezas BuscarID(int codigo);
	
	public Piezas GuardarPiezas(Piezas piezas);
	
	public Piezas ActualizarPieza(Piezas piezas);
	
	public void eliminarPieza(int codigo);
}
