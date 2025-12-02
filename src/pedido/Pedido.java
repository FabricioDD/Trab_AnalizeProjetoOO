package pedido;

import cliente.Cliente;
import pedido.pagamento.EstrategiaPagamento;
import pedido.produto.Produto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class Pedido {
	private Cliente cliente;
	private ArrayList<Produto> listaProdutos = new ArrayList<>();
	private EstrategiaPagamento metodoPagamento;
	private static final String MENSAGEM_AGRADECIMENTO = "OBRIGADO PELA PREFERENCIA!";
	private static final Logger logger = LoggerFactory.getLogger(Pedido.class);
	
	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	public void adicionarProduto(Produto p) {
		listaProdutos.add(p);
	}

	public void removerProduto(Produto p) {
		listaProdutos.remove(p);
	}

	public double calculaValorTotal() {
		double total = 0;

		for (Produto p : listaProdutos) {
			total += p.getPreco();
		}
		return total;
	}

	public void setEstrategiaPagamento(EstrategiaPagamento ep) {
		metodoPagamento = ep;
	}

public void exibirInfoPedido() {
        logger.info("\n==========================================");
        logger.info("              CUPOM DO PEDIDO             ");
        logger.info("==========================================");
        
        logger.info("CLIENTE: {}", cliente.getNome().toUpperCase()); 
        
        logger.info("------------------------------------------");
        logger.info("DESCRIÇÃO");
        logger.info("------------------------------------------");

        for (Produto p : listaProdutos) {
            logger.info("  {}", p.getDescricao());
        }

        logger.info("------------------------------------------");

        String totalFormatado = String.format("R$ %6.2f", calculaValorTotal());
        logger.info("TOTAL A PAGAR .................... {}", totalFormatado); 

        logger.info("==========================================");
        logger.info("        {}        ", MENSAGEM_AGRADECIMENTO); 
        logger.info("==========================================\n");
    }
	public void finalizarPedido() {
        double valor = calculaValorTotal();
        metodoPagamento.pagar(valor);

    }