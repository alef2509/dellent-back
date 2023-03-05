package br.com.dellent.labseq.sequencia.api.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class SequenciaResponseDTO {

    @NotNull
    private Long numero;

    @NotNull
    @NotBlank
    private String resultado;

}
