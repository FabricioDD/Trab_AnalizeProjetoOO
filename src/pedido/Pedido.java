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
        this.cliente = cliente;
    }
    public void adicionarProduto(Produto p) {
        listaProdutos.add(p);
    }

    public void removerProduto(Produto p){
        listaProdutos.remove(p);
    }

    public double calculaValorTotal(){
        double total = 0;

        for(Produto p: listaProdutos){
            total += p.getPreco();
        }
        return total;
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
