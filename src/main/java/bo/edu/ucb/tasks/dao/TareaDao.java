package bo.edu.ucb.tasks.dao;

import bo.edu.ucb.tasks.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TareaDao extends JpaRepository<Tarea, Long> {
    
    // Puedes agregar métodos personalizados para consultar tareas específicas si es necesario
    List<Tarea> findByUsuarioId(Long usuarioId);

    List<Tarea> findByEtiquetaId(Long etiquetaId);

    List<Tarea> findByUsuarioIdAndCompletada(Long usuarioId, boolean completada);
    
}
