import com.example.tarefas.APIREST.model.Usuario;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UsuarioTest {

    @Test
    public void testGetterSetter() {
        Usuario usuario = new Usuario(1L, "usuarioTeste", "senhaTeste");
        usuario.setUsername("NomeDeUsuario");
        assertEquals("NomeDeUsuario", usuario.getUsername());

        usuario.setSenha("Senha123");
        assertEquals("Senha123", usuario.getSenha());

        // Testar outros atributos
    }
}
