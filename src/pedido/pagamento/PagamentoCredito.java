package pedido.pagamento;

public class PagamentoCredito implements EstrategiaPagamento{
	private static final double TAXA_CREDITO = 0.05; // 5% de taxa
	
    @Override
    public void pagar(double valor) {
        double taxa = valor * TAXA_CREDITO;
        double valorFinal = valor + taxa;

        System.out.println("==========================================");
        System.out.println("--- Pagamento via Cartão de Crédito ---");
        System.out.printf("Valor do Pedido: R$ %.2f\n", valor);
        System.out.printf("Taxa de Transação (%.0f%%): R$ %.2f\n", TAXA_CREDITO * 100, taxa);
        System.out.printf("Total Cobrado no Cartão: R$ %.2f\n", valorFinal);
        System.out.println("Status: Transação Autorizada e Processada.");
        System.out.println("==========================================");
    }
}
