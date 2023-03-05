package br.com.dellent.labseq.sequencia.model;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
@DynamicUpdate
@Table(name = "sequencia")
public class Sequencia {
    @Id
    private String id;

    @NotNull
    private long numero;

    @NotNull
    @NotBlank
    private String labseq;



}
