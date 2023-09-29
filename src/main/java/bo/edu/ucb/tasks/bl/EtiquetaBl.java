package bo.edu.ucb.tasks.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bo.edu.ucb.tasks.dao.EtiquetaDao;
import bo.edu.ucb.tasks.entity.Etiqueta;

@Service
public class EtiquetaBl {

    private EtiquetaDao etiquetaDao;

    @Autowired
    public EtiquetaBl(EtiquetaDao etiquetaDao) {
        this.etiquetaDao = etiquetaDao;
    }

    public Etiqueta crearEtiqueta(Etiqueta etiqueta) {
        // Puedes realizar validaciones o lógica adicional antes de guardar la etiqueta
        return etiquetaDao.save(etiqueta);
    }

    public Etiqueta obtenerEtiquetaPorId(Long id) {
        return etiquetaDao.findById(id).orElse(null);
    }

    public void eliminarEtiqueta(Long id) {
        etiquetaDao.deleteById(id);
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
