package br.com.regiao.Prova3Questao1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.regiao.Prova3Questao1.modelo.Cadastro;
import br.com.regiao.Prova3Questao1.modelo.Regiao;

public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

	List<Cadastro> findByNomeEstado(String nomeEstado);

	@Query("SELECT c FROM Cadastro c ORDER BY c.populacao DESC")
	List<Cadastro> listarPorPopulacao(@Param("populacao") Long populacao);

	@Query("SELECT c FROM Cadastro c ORDER BY c.area DESC")
	List<Cadastro> listarPorArea(@Param("area") Long area);

	@Query("SELECT c FROM Cadastro c ORDER BY c.regiao")
	List<Cadastro> listarPorRegiao(@Param("regiao") Regiao regiao);

}
