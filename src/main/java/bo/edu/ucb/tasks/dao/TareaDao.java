package bo.edu.ucb.tasks.dao;

import bo.edu.ucb.tasks.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaDao extends JpaRepository<Tarea, Long> {
    
    // Puedes agregar métodos personalizados para consultas si es necesario
}

