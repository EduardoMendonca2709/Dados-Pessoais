package br.senac.tads.dsw.dados_pessoais.Repositorio;

import java.util.Optional;

import br.senac.tads.dsw.dados_pessoais.entidade.ConhecimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	@Repository
	public interface ConhecimentoRepository extends JpaRepository<ConhecimentoEntity, Integer> {

		Optional<ConhecimentoEntity> findByNomeIgnoreCase(String nome);
	}

