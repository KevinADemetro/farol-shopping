package br.com.farolshopping.loja.dao;

import br.com.farolshopping.loja.modelo.Cliente;
import jakarta.persistence.EntityManager;

public class ClienteDao {
	
	private EntityManager em;

	public ClienteDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}
}
