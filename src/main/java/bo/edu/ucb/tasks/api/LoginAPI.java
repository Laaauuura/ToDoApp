package bo.edu.ucb.tasks.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.ucb.tasks.bl.SecurityBl;
import bo.edu.ucb.tasks.dto.LoginRequestDto;
import bo.edu.ucb.tasks.dto.ResponseDto;
import bo.edu.ucb.tasks.entity.Usuario;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginAPI {

    private static final Logger LOG = LoggerFactory.getLogger(LoginAPI.class);

    private SecurityBl securityBl;
    
    public LoginAPI(SecurityBl securityBl) {
        this.securityBl = securityBl;
    }

    @PostMapping("/api/v1/login")
    public ResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
        LOG.info("Solicitud de inicio de sesión recibida para el usuario: {}", loginRequestDto.getUsuario());

        Usuario usuario = null;
        try {
            usuario = securityBl.login(loginRequestDto.getUsuario(), loginRequestDto.getContrasena());
            LOG.info("Inicio de sesión exitoso para el usuario: {}", usuario.getNombreUsuario());
        } catch (RuntimeException ex) {
            LOG.error("Error durante el inicio de sesión: {}", ex.getMessage());
            return new ResponseDto("TASK-1000", ex.getMessage(), usuario.getId());
        }

        return new ResponseDto(usuario);
    }
}
