package br.com.zup.talents.vacina.repository;

import br.com.zup.talents.vacina.model.Vacinacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacinacaoRepository extends JpaRepository<Vacinacao, Long> {
}
