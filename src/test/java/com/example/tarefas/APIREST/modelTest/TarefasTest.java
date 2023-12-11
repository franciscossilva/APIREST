import com.example.tarefas.APIREST.model.Tarefas;
import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TarefasTest {

    @Test
    public void testGetterSetter() {
        Tarefas tarefa = new Tarefas(1L, "Tarefa 1", "Descrição 1", new Date(), true, null);
        tarefa.setTitulo("Título");
        assertEquals("Título", tarefa.getTitulo());

        tarefa.setDescricao("Descrição");
        assertEquals("Descrição", tarefa.getDescricao());

        Date dataVencimento = new Date();
        tarefa.setDataVencimento(dataVencimento);
        assertEquals(dataVencimento, tarefa.getDataVencimento());

        tarefa.setStatus(true);
        assertEquals(true, tarefa.isStatus());
    }

    @Test
    public void testConstrutor() {
        Tarefas tarefa = new Tarefas(1L, "Tarefa 1", "Descrição 1", new Date(), true, null);
        assertNull(tarefa.getId()); // ID deve ser nulo ao criar uma nova tarefa

        // Testar outros atributos, garantindo que eles estejam inicializados adequadamente
        assertNull(tarefa.getTitulo());
        assertNull(tarefa.getDescricao());
        assertNull(tarefa.getDataVencimento());
        assertEquals(false, tarefa.isStatus());
    }
}
