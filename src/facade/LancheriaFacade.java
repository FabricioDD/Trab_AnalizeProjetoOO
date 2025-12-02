package facade;

import Composite.CompositeCombo;
import cliente.Cliente;
import hamburguer.decorator.CheddarExtra;
import hamburguer.decorator.MolhoExtra;
import hamburguer.fabrica.*;
import hamburguer.modelo.*;
import pedido.Pedido;
import pedido.strategyPagamento.*;
import pedido.produto.*;

public class LancheriaFacade {

    private Pedido pedido;

    public void iniciarPedido(String infoCliente) {

        String[] dadosCliente = infoCliente.split(",");

        String nome = dadosCliente[0].trim();
        String cpf = dadosCliente[1].trim();

        Cliente cliente = new Cliente(nome, cpf);
        this.pedido = new Pedido(cliente);
    }

    public void adicionarHamburguer(int tipoBase, int tipoExtra) {
        FabricaHamburguer fabrica = null;

        switch (tipoBase) {
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
                System.out.println("Hamburguer inválido");
                return;
        }

        Hamburguer hamburguer = fabrica.criarHamburguer();

        switch (tipoExtra) {
            case 1:
                hamburguer = new CheddarExtra(hamburguer, 1);
                break;
            case 2:
                hamburguer = new MolhoExtra(hamburguer, 1);
                break;
            case 3:
                break;
        }

        pedido.adicionarProduto(hamburguer);
    }

    public void adicionarCombo(int tipoCombo) {
        CompositeCombo combo = null;

        switch (tipoCombo) {
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

        if (combo != null) {
            pedido.adicionarProduto(combo);
        }
    }

    public void adicionarAcompanhamento(int tipo) {
        switch (tipo) {
            case 1:
                pedido.adicionarProduto(new BatataFrita(1));
                break;
            case 2:
                pedido.adicionarProduto(new Refrigerante(1));
                break;
            case 3:
                pedido.adicionarProduto(new Cerveja(1));
                break;
        }
    }

    public void exibirResumo() {
        pedido.exibirInfoPedido();
    }

    public void finalizarPedido(int tipoPagamento) {
        switch (tipoPagamento) {
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
                System.out.println("Pagamento inválido");
                return;
        }

        pedido.finalizarPedido();
    }
}