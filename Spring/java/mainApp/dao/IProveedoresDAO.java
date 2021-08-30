package mainApp.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import mainApp.dto.Proveedores;
public interface IProveedoresDAO extends JpaRepository<Proveedores, Integer>{

}
