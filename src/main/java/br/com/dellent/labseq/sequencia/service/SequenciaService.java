package br.com.dellent.labseq.sequencia.service;

import br.com.dellent.labseq.sequencia.repository.SequenciaRepository;
import br.com.dellent.labseq.sequencia.exception.ValorInvalidoException;
import br.com.dellent.labseq.sequencia.api.dto.SequenciaResponseDTO;
import br.com.dellent.labseq.sequencia.model.Sequencia;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class SequenciaService {
    @Autowired
    private final SequenciaRepository repository;

    @Cacheable(value = "sequenciaCache", key = "#numero")
    public SequenciaResponseDTO handle(final Long numero) {
        if (numero <= 0) {
            throw new ValorInvalidoException();
        }

        Optional<Sequencia> optionalSequencia = repository.filtrarPorNumero(numero);
        if(optionalSequencia.isPresent()){
            Sequencia sequencia = optionalSequencia.get();
            return  SequenciaResponseDTO.builder()
                    .numero(numero)
                    .resultado(sequencia.getLabseq())
                    .build();
        }
        else
        {
            String sequencia = labseq(numero);

            var sequenciaNova = Sequencia.builder()
                    .numero(numero)
                    .labseq(sequencia)
                    .id(UUID.randomUUID().toString())
                    .build();

            repository.saveAndFlush(sequenciaNova);

            return  SequenciaResponseDTO.builder()
                .numero(numero)
                .resultado(sequencia)
                .build();
        }

    }


    public static void main(String[] args) {
        String teste = labseq(10000);
        System.out.println(teste);
    }

    public static String labseq(long n) {
        if (n == 0) {
            return "0";
        } else if (n == 1) {
            return "1";
        } else if (n == 2) {
            return "0";
        } else if (n == 3) {
            return "1";
        } else {
            BigInteger lnMinus4 = BigInteger.ZERO;
            BigInteger lnMinus3 = BigInteger.ONE;
            BigInteger lnMinus2 = BigInteger.ZERO;
            BigInteger lnMinus1 = BigInteger.ONE;
            BigInteger ln = BigInteger.ZERO;
            for (int i = 4; i <= n; i++) {
                ln = lnMinus4.add(lnMinus3);
                lnMinus4 = lnMinus3;
                lnMinus3 = lnMinus2;
                lnMinus2 = lnMinus1;
                lnMinus1 = ln;
            }
            return lnMinus4.toString() + lnMinus3.toString() + lnMinus2.toString() + lnMinus1.toString() + ln.toString() + "0";
        }
    }


}
