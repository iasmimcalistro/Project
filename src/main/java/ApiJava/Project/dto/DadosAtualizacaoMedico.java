package ApiJava.Project.dto;

public record DadosAtualizacaoMedico(
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
