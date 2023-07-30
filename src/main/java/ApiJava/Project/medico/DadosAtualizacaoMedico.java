package ApiJava.Project.medico;

import ApiJava.Project.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
