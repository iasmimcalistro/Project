package ApiJava.Project;

import ApiJava.Project.medico.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class MedicoControllerTest {

    @InjectMocks
    public class MedicoController controller;

    @Mock
    private MedicoRepository repository;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(WebApplicationContext wac) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testCadastrarMedico() throws Exception {
        DadosCadastroMedico dados = new DadosCadastroMedico("Teste", "123456789", "email@email.com", "Rua teste");

        mockMvc.perform(post("/medicos")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(dados)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testListarMedicos() throws Exception {
        Pageable pageable = Pageable.unpaged();
        List<Medico> medicos = new ArrayList<>();
        medicos.add(new Medico("Teste", "123456789", "email@email.com", "Rua teste"));
        Page<Medico> medicoPage = new PageImpl<>(medicos);

        when(repository.findAllByAtivoTrue(pageable)).thenReturn(medicoPage);

        mockMvc.perform(get("/medicos")
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void testAtualizarMedico() throws Exception {
        DadosAtualizacaoMedico dados = new DadosAtualizacaoMedico(1L, "Teste Atualizado", "123456789", "email@email.com", "Rua teste Atualizada");

        mockMvc.perform(put("/medicos")
                        .contentType("application/json")
                        .content(new ObjectMapper().writeValueAsString(dados)))
                .andExpect(status().isOk());
    }

    @Test
    public void testExcluirMedico() throws Exception {
        mockMvc.perform(delete("/medicos/{id}", 1L))
                .andExpect(status().isOk());
    }
}