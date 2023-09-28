package bo.edu.ucb.tasks.bl;
import org.springframework.stereotype.Service;

import bo.edu.ucb.tasks.dao.UsuarioDao;
import bo.edu.ucb.tasks.entity.Usuario;


@Service
public class SecurityBl {
    private UsuarioDao usuarioDao;

    public SecurityBl(UsuarioDao usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    public Usuario login(String nombreUsuario, String contrasena) {

        Usuario usuario = usuarioDao.findByNombreUsuarioAndContrasena(nombreUsuario, contrasena);
        if(usuario == null) {
            throw new RuntimeException("Autenticacion incorrecta");
            }
            usuario.setContrasena(null);
            return usuario;
        } 

       
    }
    

