package br.com.farolshopping.forum.repository;

import org.springframework.data.repository.Repository;

import br.com.farolshopping.forum.modelo.Curso;

public interface CursoRepository extends Repository<Curso, Long>{

	Curso findByNome(String nomeCurso);

}
