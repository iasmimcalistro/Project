package ApiJava.Project.medico;

import ApiJava.Project.endereco.DadosEndereco;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class   Endereco {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String UF;

    public Endereco(DadosEndereco dados){
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.UF = dados.UF();
        this.cidade = dados.cidade();
        this.numero = dados.numero();
        this.complemento = dados.complemento();

    }

}
