package bo.edu.ucb.tasks.bl;
import org.springframework.stereotype.Service;

import bo.edu.ucb.tasks.dao.TareaDao;
import bo.edu.ucb.tasks.entity.Tarea;


@Service
public class TareaBl {
    private TareaDao tareaDao;

    public TareaBl(TareaDao tareaDao) {
        this.tareaDao = tareaDao;
    }
    
    public Tarea crearTarea(Tarea tarea) {
        return tareaDao.save(tarea);
    }

    public Tarea actualizarTarea(Tarea tarea) {
        return tareaDao.save(tarea);
    }

    public void eliminarTarea(Tarea tarea) {
        tareaDao.delete(tarea);
    }

}
    

