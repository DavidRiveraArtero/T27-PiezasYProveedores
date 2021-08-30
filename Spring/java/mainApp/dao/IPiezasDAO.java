package mainApp.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import mainApp.dto.Piezas;
public interface IPiezasDAO extends JpaRepository<Piezas, Integer>{

}
