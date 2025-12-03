package ui;

import javax.sound.sampled.Line;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Menu {
    private static final Logger logger = LoggerFactory.getLogger(Menu.class);
    public String pedirInfoCLiente(Scanner sc) {

    logger.info("--- Bem-vindo à Lancheria ---");
    
    System.out.print("Nome do Cliente: "); 
    String nome = sc.nextLine();
    
    System.out.print("Cpf do Cliente: "); 
    String cpf = sc.nextLine();

    return nome + "," + cpf;
}

    public int exibeMenuEscolha(Scanner sc) {
        logger.info("\n--- MENU PRINCIPAL ---");
        logger.info("1 - Adicionar Hambúrguer");
        logger.info("2 - Adicionar Acompanhamento/Bebida");
        logger.info("3 - Adicionar Combo");
        logger.info("4 - Finalizar Pedido");
        logger.info("0 - Sair");
        System.out.print("Escolha: ");
        return sc.nextInt();
    }

    public int exibeMenuHamburguer(Scanner sc) {
    logger.info("\n--- ESCOLHA O HAMBURGUER ---");
    logger.info("1 - Bacon");
    logger.info("2 - Triplo");
    logger.info("3 - Vegetariano");
    logger.info("0 - Sair");
    System.out.print("Opção: "); 
    return sc.nextInt();
    }

    public int exibeMenuExtras(Scanner sc) {
    logger.info("\n--- ESCOLHA O EXTRA ---");
    logger.info("1 - Cheddar Extra");
    logger.info("2 - Molho Extra");
    logger.info("3 - Sem Extra");
    System.out.print("Opção: "); 
    return sc.nextInt();
}

    public int exibeMenuCombos(Scanner sc) {
    logger.info("\n--- COMBOS PROMOCIONAIS ---");
    logger.info("1 - Combo Gigante (X-Triplo c/ Cheddar Extra + Batata + Cerveja)");
    logger.info("2 - Combo Casal (2x X-Bacon + Batata + 2x Refri)");
    logger.info("3 - Combo Padrão (X-Bacon + Batata + Refri)");
    System.out.print("Opção: "); 
    return sc.nextInt();
}

    public int exibeMenuAcompanhamentos(Scanner sc) {
    logger.info("\n--- ACOMPANHAMENTOS E BEBIDAS ---");
    logger.info("1 - Batata Frita");
    logger.info("2 - Refrigerante");
    logger.info("3 - Cerveja");
    System.out.print("Opção: "); 
    return sc.nextInt();
}
  public int exibeMenuPagamento(Scanner sc) {
    logger.info("\n--- FINALIZANDO ---");
    logger.info("Selecione o Pagamento:");
    logger.info("1 - PIX");
    logger.info("2 - Crédito");
    logger.info("3 - Débito");
    return sc.nextInt();
}
  
}
