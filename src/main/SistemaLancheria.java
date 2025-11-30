package main;

import cliente.Cliente;
import hamburguer.decorator.CheddarExtra;
import hamburguer.decorator.MolhoExtra;
import hamburguer.fabrica.FabricaHamburguer;
import hamburguer.fabrica.FabricaHamburguerBacon;
import hamburguer.fabrica.FabricaHamburguerTriplo;
import hamburguer.fabrica.FabricaHamburguerVegetariano;
import hamburguer.modelo.Hamburguer;
import hamburguer.modelo.HamburguerBacon;
import hamburguer.modelo.HamburguerTriplo;
import pedido.Pedido;
import pedido.pagamento.PagamentPix;
import pedido.pagamento.PagamentoCredito;
import pedido.pagamento.PagamentoDebito;
import pedido.produto.BatataFrita;
import pedido.produto.Cerveja;
import pedido.produto.CompositeCombo;
import pedido.produto.Refrigerante;
import ui.Menu;

import java.util.Scanner;

public class SistemaLancheria {

	private Scanner sc;
	private Pedido pedido;
	private Menu menu;

	public SistemaLancheria(Menu menu) {
		this.menu = menu;
		this.sc = new Scanner(System.in);
	}

	public void iniciar() {
		System.out.println("--- Bem-vindo à Lancheria ---");
		System.out.print("Nome do Cliente: ");
		String nome = sc.nextLine();

		Cliente cliente = new Cliente(nome, "000.000.000-00");
		this.pedido = new Pedido(cliente);

		fazerEscolha();
	}

	private void fazerEscolha() {
		int opcaoPrincipal;
		do {
			opcaoPrincipal = menu.exibeMenuEscolha(sc);
			switch (opcaoPrincipal) {
			case 1:
				selecionarHamburguer();
				break;
			case 2:
				selecionarAcompanhamento();
				break;
			case 3:
				selecionarCombo();
				break;
			case 4:
				selecionarPagamento();
				break;
			case 0:
				System.out.println("Ate mais, volte sempre!");
			default:
				System.out.println("Opcao invalida");
			}
		} while (opcaoPrincipal != 0);
	}

	private void selecionarHamburguer() {
		int tipo = menu.exibeMenuHamburguer(sc);

		Hamburguer hamburguer = null;
		FabricaHamburguer fabrica = null;

		switch (tipo) {
		case 1:
			fabrica = new FabricaHamburguerBacon();
			break;
		case 2:
			fabrica = new FabricaHamburguerTriplo();
			break;
		case 3:
			fabrica = new FabricaHamburguerVegetariano();
			break;
		default:
			System.out.println("Opcao invalida");
			return;
		}

		hamburguer = fabrica.criarHamburguer();
		int op = menu.exibeMenuExtras(sc);

		switch (op) {
		case 1:
			hamburguer = new CheddarExtra(hamburguer, 1);
			break;
		case 2:
			hamburguer = new MolhoExtra(hamburguer, 1);
			break;
		case 3:
			break;
		default:
			System.out.println("Opcao invalida");
		}

		pedido.adicionarProduto(hamburguer);
		System.out.println("Hambúrguer adicionado!");
	}

	private void selecionarCombo() {
		int op = menu.exibeMenuCombos(sc);
		CompositeCombo combo = null;

		switch (op) {
		case 1:
			combo = new CompositeCombo("Combo Gigante");
			combo.adicionarProduto(new CheddarExtra(new HamburguerTriplo(), 1));
			combo.adicionarProduto(new BatataFrita(1));
			combo.adicionarProduto(new Cerveja(1));
			break;

		case 2:
			combo = new CompositeCombo("Combo Casal");
			combo.adicionarProduto(new HamburguerBacon());
			combo.adicionarProduto(new HamburguerBacon());
			combo.adicionarProduto(new BatataFrita(1));
			combo.adicionarProduto(new Refrigerante(2));
			break;

		case 3:
			combo = new CompositeCombo("Combo Padrão");
			combo.adicionarProduto(new HamburguerBacon());
			combo.adicionarProduto(new BatataFrita(1));
			combo.adicionarProduto(new Refrigerante(1));
			break;
		}
		pedido.adicionarProduto(combo);

	}

	private void selecionarAcompanhamento() {
		int op = menu.exibeMenuAcompanhamentos(sc);

		switch (op) {
		case 1:
			pedido.adicionarProduto(new BatataFrita(1));
			break;
		case 2:
			pedido.adicionarProduto(new Refrigerante(1));
			break;
		case 3:
			pedido.adicionarProduto(new Cerveja(1));
			break;
		default:
			System.out.println("Opcao invalida");
		}

		System.out.println("Acompanhamento adicionado!");

	}

	private void selecionarPagamento() {
		pedido.exibirInfoPedido();

		int op = menu.exibeMenuPagamento(sc);

		switch (op) {
		case 1:
			pedido.setEstrategiaPagamento(new PagamentPix());
			break;
		case 2:
			pedido.setEstrategiaPagamento(new PagamentoCredito());
			break;
		case 3:
			pedido.setEstrategiaPagamento(new PagamentoDebito());
			break;
		default:
			System.out.println("Opcao invalida");
		}
		pedido.finalizarPedido();
	}
}