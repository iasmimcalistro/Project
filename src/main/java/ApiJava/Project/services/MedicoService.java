package ApiJava.Project.services;

import ApiJava.Project.dto.DadosAtualizacaoMedico;
import ApiJava.Project.dto.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MedicoService {
    void save(Medico medico);
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
    Medico getById(Long Id);

    void atualizarInformacoes(DadosAtualizacaoMedico dados);
}
