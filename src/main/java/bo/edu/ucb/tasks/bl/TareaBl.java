package bo.edu.ucb.tasks.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.edu.ucb.tasks.dao.TareaDao;
import bo.edu.ucb.tasks.entity.Tarea;

import java.util.List;

@Service
public class TareaBl {

    private TareaDao tareaDao;

    @Autowired
    public TareaBl(TareaDao tareaDao) {
        this.tareaDao = tareaDao;
    }

    public Tarea crearTarea(Tarea tarea) {
        // Puedes realizar validaciones o lógica adicional antes de guardar la tarea
        return tareaDao.save(tarea);
    }

    public Tarea obtenerTareaPorId(Long id) {
        return tareaDao.findById(id).orElse(null);
    }


    public void eliminarTarea(Long id) {
        tareaDao.deleteById(id);
    }

    public List<Tarea> obtenerTodasLasTareas() {
        return tareaDao.findAll();
    }

    public List<Tarea> obtenerTareasPorUsuario(Long usuarioId) {
        return tareaDao.findByUsuarioId(usuarioId);
    }

    public List<Tarea> obtenerTareasPorEtiqueta(Long etiquetaId) {
        return tareaDao.findByEtiquetaId(etiquetaId);
    }

    public List<Tarea> obtenerTareasPorUsuarioYCompletadas(Long usuarioId, boolean completada) {
        return tareaDao.findByUsuarioIdAndCompletada(usuarioId, completada);
    }
}
