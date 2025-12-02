package pedido.strategyPagamento;

public class PagamentoDebito implements EstrategiaPagamento{
	
    @Override
    public void pagar(double valor) {
    	System.out.println("==========================================");
        System.out.println("--- Pagamento via Cartão de Débito ---");
        System.out.printf("Valor Processado: R$ %.2f\n", valor);
        System.out.println("Status: Pagamento realizado instantaneamente.");
        System.out.println("==========================================");
    }
}
