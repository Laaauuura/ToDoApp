package bo.edu.ucb.tasks.dao;

import bo.edu.ucb.tasks.entity.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtiquetaDao extends JpaRepository<Etiqueta, Long> {
    
    // Puedes agregar métodos personalizados para consultar etiquetas específicas si es necesario
    List<Etiqueta> findByUsuarioId(Long usuarioId);
}
