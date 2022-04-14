package br.com.farolshopping.loja.teste;

import java.math.BigDecimal;
import java.util.List;

import br.com.farolshopping.loja.dao.CategoriaDao;
import br.com.farolshopping.loja.dao.ProdutoDao;
import br.com.farolshopping.loja.modelo.Categoria;
import br.com.farolshopping.loja.modelo.Produto;
import br.com.farolshopping.loja.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		Produto p = produtoDao.buscaroPor(1l);
		System.out.println(p.getPreco());
//		
//		List<Produto> todos = produtoDao.buscarTodos();
//		System.out.println("-----------------------------------------------------");
//		todos.forEach(p2 -> System.out.println(p2.getNome()));
//		System.out.println("-----------------------------------------------------");
		
		List<Produto> filtrado = produtoDao.buscarPor("ph");
		System.out.println("-----------------------------------------------------");
		filtrado.forEach(p2 -> System.out.println(p2.getNome()));
		System.out.println("-----------------------------------------------------");
//		
//		List<Produto> filtradoPorCategoria = produtoDao.buscarPorCategoria("Celulares");
//		System.out.println("-----------------------------------------------------");
//		filtradoPorCategoria.forEach(p2 -> System.out.println(p2.getNome()));
//		System.out.println("-----------------------------------------------------");
		
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("Celulares");
		
		Produto celular = new Produto("A-32", "Sansung", new BigDecimal("700"), celulares);
		celular.setNome("Iphone 11");
		celular.setDescricao("Branco");
		celular.setPreco(new BigDecimal("800"));
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	}
}