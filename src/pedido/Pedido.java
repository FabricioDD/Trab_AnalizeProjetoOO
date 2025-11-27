package pedido;

import cliente.Cliente;
import pedido.pagamento.EstrategiaPagamento;
import pedido.produto.Produto;

import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private ArrayList<Produto> listaProdutos = new ArrayList();
    private EstrategiaPagamento metodoPagamento;
    private double valorTotal;

    public Pedido(Cliente cliente){

    }
    public void adicionarProduto(Produto p) {

    }

    public void removerProduto(Produto p){

    }

    public double calculaValorTotal(){
        return 0;
    }

    public void setEstrategiaPagamento(EstrategiaPagamento ep){

    }

    public void finalizarPedido(){

    }

    public void exibirInfo(){

    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public EstrategiaPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}
