package ApiJava.Project.services.impl;

import ApiJava.Project.dto.DadosAtualizacaoMedico;
import ApiJava.Project.dto.Medico;
import ApiJava.Project.repositories.MedicoRepository;
import ApiJava.Project.services.MedicoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    @Override
    @Transactional()
    public void save(Medico medico) {
        medicoRepository.save(medico);
    }

    @Override
    public Page<Medico> findAllByAtivoTrue(Pageable paginacao) {
        return null;
    }

    @Override
    public Medico getById(Long Id) {
        return null;
    }

    @Override
    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {

    }
}
