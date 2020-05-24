package br.com.svalgas.model.motorista;

import br.com.svalgas.enums.Categoria;
import br.com.svalgas.model.cnh.Cnh;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * MotoristaForm - Monta a estrutura de view de dados encapsulando e convertendo a classe MotoristaForm para Motorista.
 * Todos os dados sao inseridos atraves do controller pelas requisicoes via POST (body).
 */
public @NoArgsConstructor @Data class MotoristaForm {

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    private Long numeroCNH;

    @NotNull
    private Categoria categoria;

    public Motorista converter() {
        return new Motorista(this.nome,
                new Cnh(this.numeroCNH, this.categoria)
        );
    }
}
