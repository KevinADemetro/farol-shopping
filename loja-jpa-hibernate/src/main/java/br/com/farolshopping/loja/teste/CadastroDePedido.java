package br.com.farolshopping.loja.teste;

import java.math.BigDecimal;
import java.util.List;

import br.com.farolshopping.loja.dao.CategoriaDao;
import br.com.farolshopping.loja.dao.ClienteDao;
import br.com.farolshopping.loja.dao.PedidoDao;
import br.com.farolshopping.loja.dao.ProdutoDao;
import br.com.farolshopping.loja.modelo.Categoria;
import br.com.farolshopping.loja.modelo.Cliente;
import br.com.farolshopping.loja.modelo.ItemPedido;
import br.com.farolshopping.loja.modelo.Pedido;
import br.com.farolshopping.loja.modelo.Produto;
import br.com.farolshopping.loja.util.JPAUtil;
import br.com.farolshopping.loja.vo.RelatorioDeVendasVo;
import jakarta.persistence.EntityManager;

public class CadastroDePedido {
	
	public static void main(String[] args) {
		
		cadastrarProduto();
		
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		
		Cliente cliente = new Cliente("Rodrigo", "123.123.123-12");
		Pedido pedido = new Pedido(cliente);
		ProdutoDao produtoDao = new ProdutoDao(em);
		Produto produto = produtoDao.buscaroPor(1L);
		PedidoDao pedidoDao = new PedidoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		clienteDao.cadastrar(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		pedidoDao.cadastrar(pedido);
		em.getTransaction().commit();
		
		
		BigDecimal resultado = pedidoDao.valorTotalVendido();
		
		System.out.println("Valor total: "+resultado);
		
		List<RelatorioDeVendasVo> relatorio = pedidoDao.relatorioDeVendas();
		System.out.println(relatorio);
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
