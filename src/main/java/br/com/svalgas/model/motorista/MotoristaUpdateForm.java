package br.com.svalgas.model.motorista;

import br.com.svalgas.enums.Categoria;
import br.com.svalgas.repository.MotoristaRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * MotoristaUpdateForm - informamos somente os campos que podem ser alterados no Update,
 * permitindo apenas dados atualizaveis.
 */
public @NoArgsConstructor @Data class MotoristaUpdateForm {

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    private Categoria categoria;

    public Motorista atualiza(Long id, MotoristaRepository motoristaRepository) {
        Motorista motorista = motoristaRepository.getOne(id);
        motorista.setNome(this.nome);

        return motorista;
    }

}
