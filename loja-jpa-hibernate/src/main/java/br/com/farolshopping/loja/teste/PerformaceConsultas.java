package br.com.farolshopping.loja.teste;

import java.math.BigDecimal;

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
import jakarta.persistence.EntityManager;

public class PerformaceConsultas {
	
	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager em = JPAUtil.getEntityManager();
		
		Pedido pedido = em.find(Pedido.class, 1l);
		System.out.println("-------------------------");
		
		System.out.println(pedido.getCliente().getDadosPessoais().getNome());
		
		System.out.println("-------------------------");
		
		PedidoDao pedidoDao = new PedidoDao(em);
		System.out.println("-------------------------");
		
		System.out.println("Você está aqui");
		ProdutoDao produdoDao = new ProdutoDao(em);
		produdoDao.buscarPorParametroComCriteria("Xiaomi", null, null);
		System.out.println("Você está aqui");

		System.out.println("-------------------------");

		Pedido pedidoComCliente = pedidoDao.buscarPedidoComCliente(1l);
		em.close();
		System.out.println(pedidoComCliente.getCliente().getDadosPessoais().getCpf());
		
 	}
	
	private static void popularBancoDeDados() {
		Categoria celulares = new Categoria("CELULARES");
		Categoria videogames = new Categoria("VIDEOGAMES");	
		Categoria informatica = new Categoria("INFORMÁTICA");
		
		Produto celular = new Produto("Xiaomi","Celular muito loko", new BigDecimal("700"), celulares);
		Produto videogame = new Produto("Ps4", "pra jogar god of war", new BigDecimal("800"), videogames);
		Produto pc = new Produto("Pc gamer", "com ledzim rgb", new BigDecimal("900"), informatica);
		
		Cliente cliente = new Cliente("Jorge maravilha", "123.123.123-12");
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, celular));
		pedido.adicionarItem(new ItemPedido(40, pedido, pc));
		
		Pedido pedido2 = new Pedido(cliente);
		pedido2.adicionarItem(new ItemPedido(29, pedido2, videogame));
		pedido2.adicionarItem(new ItemPedido(35, pedido2, celular));
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		PedidoDao pedidoDao = new PedidoDao(em);
		
		em.getTransaction().begin();
		
			categoriaDao.cadastrar(informatica);
			categoriaDao.cadastrar(celulares);
			categoriaDao.cadastrar(videogames);
			
			clienteDao.cadastrar(cliente);
			
			produtoDao.cadastrar(videogame);
			produtoDao.cadastrar(celular);
			produtoDao.cadastrar(pc);
			
			pedidoDao.cadastrar(pedido2);
			pedidoDao.cadastrar(pedido);
		
		em.getTransaction().commit();
		em.close();
	}
	
}

















