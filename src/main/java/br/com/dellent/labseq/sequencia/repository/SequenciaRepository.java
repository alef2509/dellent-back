package br.com.dellent.labseq.sequencia.repository;

import br.com.dellent.labseq.sequencia.model.Sequencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface SequenciaRepository extends JpaRepository<Sequencia, String> {


    Optional<Sequencia> findByNumero(Long numero);

    List<Sequencia> findAll();

    @Query (value = "SELECT * FROM Sequencia c WHERE c.numero = :numero",
    nativeQuery = true)
    Optional<Sequencia> filtrarPorNumero(Long numero);

}
