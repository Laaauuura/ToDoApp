package bo.edu.ucb.tasks.dao;

import bo.edu.ucb.tasks.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    
    public Usuario findByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena);
}
