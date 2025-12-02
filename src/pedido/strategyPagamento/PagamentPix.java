package pedido.strategyPagamento;

public class PagamentPix implements EstrategiaPagamento{
    @Override
    public void pagar(double valor) {
    	System.out.println("==========================================");
        System.out.println("--- Pagamento via PIX ---");
        System.out.printf("Valor Total a Pagar: R$ %.2f\n", valor);
        System.out.println("Status: Aguardando Pagamento.");
        System.out.println("CHAVE PIX CNPJ: 4321.lanche@lancheria.com.br");
        System.out.println("Ou use o QR Code: [QR Code Simulado]");
        System.out.println("Pagamento realizado com sucesso após a compensação!");
        System.out.println("==========================================");
    }
}
