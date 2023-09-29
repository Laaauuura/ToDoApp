package bo.edu.ucb.tasks.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.edu.ucb.tasks.dao.TareaDao;
import bo.edu.ucb.tasks.entity.Tarea;

import java.util.List;
import java.util.Optional;

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


    public boolean eliminarTarea(Long id) {
        // Intenta obtener la tarea por su ID
        Optional<Tarea> tareaOptional = tareaDao.findById(id);
        
        if (tareaOptional.isPresent()) {
            // Si la tarea existe, elimínala y luego verifica si aún existe en la base de datos
            tareaDao.delete(tareaOptional.get());
            boolean tareaExiste = tareaDao.existsById(id);
            // Devuelve true si la eliminación tuvo éxito y la tarea no existe en la base de datos
            return !tareaExiste;
        } else {
            // Si no se encontró la tarea, devuelve false
            return false;
        }
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

    public Tarea actualizarEstadoTarea(Long tareaId, boolean nuevoEstado) {
        Tarea tarea = tareaDao.findById(tareaId).orElse(null);
        
        if (tarea != null) {
            tarea.setCompletada(nuevoEstado);
            return tareaDao.save(tarea);
        } else {
            return null;
        }
    }
}
