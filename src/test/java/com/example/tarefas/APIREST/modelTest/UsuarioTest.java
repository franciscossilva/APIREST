import com.example.tarefas.APIREST.model.Usuario;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UsuarioTest {

    @Test
    public void testGetterSetter() {
        Usuario usuario = new Usuario("usuarioTeste", "senhaTeste");
        usuario.setUsername("NomeDeUsuario");
        assertEquals("NomeDeUsuario", usuario.getUsername());

        usuario.setSenha("Senha123");
        assertEquals("Senha123", usuario.getSenha());
    }

    @Test
    public void testConstrutor() {
        Usuario usuario = new Usuario("usuarioTeste", "senhaTeste");
        assertNull(usuario.getId()); // ID deve ser nulo ao criar um novo usuário

        // Testar outros atributos, garantindo que eles estejam inicializados adequadamente
        assertNull(usuario.getUsername());
        assertNull(usuario.getSenha());
    }
}
