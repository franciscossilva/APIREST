import com.example.tarefas.APIREST.Servirce.TarefasService;
import com.example.tarefas.APIREST.model.Tarefas;
import com.example.tarefas.APIREST.repository.TarefasRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TarefasServiceTest {

    @Mock
    private TarefasRepository tarefasRepository;

    @InjectMocks
    private TarefasService tarefasService;

    @Test
    public void testListarTarefas() {

        when(tarefasRepository.findAll()).thenReturn(Arrays.asList(new Tarefas(), new Tarefas()));


        List<Tarefas> result = tarefasService.listarTarefas();


        assertEquals(2, result.size());
    }

    @Test
    public void testObterTarefaPorId() {

        long id = 1L;
        when(tarefasRepository.findById(id)).thenReturn(Optional.of(new Tarefas()));


        Optional<Tarefas> result = tarefasService.obterTarefaPorId(id);


        assertTrue(result.isPresent());
    }

    @Test
    public void testObterTarefaPorTitulos() {

        String titulos = "Teste";
        when(tarefasRepository.findByTitulos(titulos)).thenReturn(new Tarefas());


        Tarefas result = tarefasService.obterTarefaPorTitulos(titulos);


        assertNotNull(result);
        assertEquals("Teste", result.getTitulos());
    }
}
