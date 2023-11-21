package ApiJava.Project.controller;


import ApiJava.Project.dto.*;
import ApiJava.Project.repositories.MedicoRepository;
import ApiJava.Project.services.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;
    @Transactional
    @PostMapping
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){

        medicoService.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return medicoService.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados ){
        var medico = medicoService.getById(dados.id());
        medicoService.atualizarInformacoes(dados);

    }
    @Transactional
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        var medico = medicoService.getById(id);
        medico.excluir();
    }

}
