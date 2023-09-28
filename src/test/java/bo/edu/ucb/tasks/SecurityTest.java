package bo.edu.ucb.tasks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bo.edu.ucb.tasks.bl.SecurityBl;
import bo.edu.ucb.tasks.entity.Usuario;


@SpringBootTest
class SecurityTest {

	@Autowired
	SecurityBl securityBl;	

	@Test
	void testLogin() {
		Usuario usuario = securityBl.login("usuario1", "12345");
		assertNotNull(usuario, "El usuario deberia existir");
	}

	@Test
	void testErrorLogin(){
		try{
			securityBl.login("usuario1", "12345");
		}catch(RuntimeException ex){
			assertEquals("Autenticacion incorrecta", ex.getMessage());
		}
	}

}
