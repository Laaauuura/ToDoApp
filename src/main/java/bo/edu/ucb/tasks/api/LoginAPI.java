package bo.edu.ucb.tasks.api;
import java.util.List;
import java.security.Security;
import java.util.ArrayList;

import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import bo.edu.ucb.tasks.bl.SecurityBl;
import bo.edu.ucb.tasks.dto.LoginRequestDto;
import bo.edu.ucb.tasks.dto.ResponseDto;
import bo.edu.ucb.tasks.entity.Usuario;

public class LoginAPI {


    SecurityBl securityBl;
    public LoginAPI(SecurityBl securityBl) {
        this.securityBl = securityBl;
    }
    @PostMapping("/api/v1/login")

    public ResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
        Usuario usuario;
        try{
            usuario = securityBl.login(loginRequestDto.getUsuario(), loginRequestDto.getContrasena());
        }catch(RuntimeException ex){
            return new ResponseDto("TASK-1000", ex.getMessage());
        }
        return new ResponseDto(usuario);

    }
    
}
