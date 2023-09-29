package bo.edu.ucb.tasks.bl;
import org.springframework.stereotype.Service;

import bo.edu.ucb.tasks.dao.EtiquetaDao;
import bo.edu.ucb.tasks.entity.Etiqueta;


@Service
public class EtiquetaBl{
    private EtiquetaDao etiquetaDao;

    public EtiquetaBl(EtiquetaDao etiquetaDao) {
        this.etiquetaDao = etiquetaDao;
    }

    public Etiqueta crearEtiqueta(Etiqueta etiqueta) {
        return etiquetaDao.save(etiqueta);
    }

    public Etiqueta actualizarEtiqueta(Etiqueta etiqueta) {
        return etiquetaDao.save(etiqueta);
    }

    public void eliminarEtiqueta(Etiqueta etiqueta) {
        etiquetaDao.delete(etiqueta);
    }
}