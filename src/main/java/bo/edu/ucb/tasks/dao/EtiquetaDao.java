package bo.edu.ucb.tasks.dao;

import bo.edu.ucb.tasks.entity.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtiquetaDao extends JpaRepository<Etiqueta, Long> {
    
    // Puedes agregar métodos personalizados para consultas si es necesario
}
