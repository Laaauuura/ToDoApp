package bo.edu.ucb.tasks.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.edu.ucb.tasks.dao.EtiquetaDao;
import bo.edu.ucb.tasks.entity.Etiqueta;
import bo.edu.ucb.tasks.entity.Tarea;

@Service
public class EtiquetaBl {

    private EtiquetaDao etiquetaDao;
    private TareaBl tareaBl;

    @Autowired
    public EtiquetaBl(EtiquetaDao etiquetaDao, TareaBl tareaBl) {
        this.etiquetaDao = etiquetaDao;
        this.tareaBl = tareaBl;
    }

    public Etiqueta crearEtiqueta(Etiqueta etiqueta) {
        // Puedes realizar validaciones o lógica adicional antes de guardar la etiqueta
        return etiquetaDao.save(etiqueta);
    }

    public Etiqueta obtenerEtiquetaPorId(Long id) {
        return etiquetaDao.findById(id).orElse(null);
    }

    public boolean eliminarEtiqueta(Long id) {
        // Obtén la etiqueta por su ID
        Etiqueta etiqueta = etiquetaDao.findById(id).orElse(null);

        if (etiqueta != null) {
            // Obtiene las tareas asociadas a la etiqueta y las elimina una por una
            List<Tarea> tareasAsociadas = tareaBl.obtenerTareasPorEtiqueta(id);
            for (Tarea tarea : tareasAsociadas) {
                tareaBl.eliminarTarea(tarea.getId());
            }

            // Luego, elimina la etiqueta
            etiquetaDao.deleteById(id);

            // Comprueba si la etiqueta aún existe en la base de datos
            boolean etiquetaExiste = etiquetaDao.existsById(id);

            // Devuelve true si la eliminación tuvo éxito y la etiqueta no existe
            return !etiquetaExiste;
        }

        return false;
    }

    public List<Etiqueta> obtenerTodasLasEtiquetas() {
        return etiquetaDao.findAll();
    }

    public List<Etiqueta> obtenerEtiquetasPorUsuarioId(Long usuarioId) {
        return etiquetaDao.findByUsuarioId(usuarioId);
    }

    public List<Etiqueta> obtenerEtiquetasPorUsuario(Long usuarioId) {
        return etiquetaDao.findByUsuarioId(usuarioId);
    }

    
    public Etiqueta actualizarEtiqueta(Etiqueta etiqueta) {
        return etiquetaDao.save(etiqueta);
    }
}
