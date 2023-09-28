package bo.edu.ucb.tasks;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bo.edu.ucb.tasks.dao.UsuarioDao;
import bo.edu.ucb.tasks.entity.Usuario;

@SpringBootTest
class TasksApplicationTests {

	@Autowired
	UsuarioDao usuarioDao;
	
	@Test
	void testUsuarioJPA() {
		List<Usuario> usuarioList = usuarioDao.findAll();
		for (Usuario u : usuarioList) {
			System.out.println(u.getNombreUsuario());
		}
		assertNotEquals(0, usuarioList.size(),
		"La base de datos deberia tener registros");
	}

}
