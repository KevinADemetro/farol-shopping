package br.com.farolshopping.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.farolshopping.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{
	
	List<Topico> findByCursoNome(String nomeCurso);
}