package br.com.farolshopping.loja.dao;

import br.com.farolshopping.loja.modelo.Categoria;
import jakarta.persistence.EntityManager;

public class CategoriaDao {
	
	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
	public void atualizar(Categoria categoria) {
		this.em.merge(categoria);
	}
}
