package ui;

import javax.sound.sampled.Line;
import java.util.Scanner;

public class Menu {

    public String pedirInfoCLiente(Scanner sc) {
        System.out.println("--- Bem-vindo à Lancheria ---");
        System.out.print("Nome do Cliente: ");
        String nome = sc.nextLine();
        System.out.println("Cpf do Cliente: ");
        String cpf = sc.nextLine();

        return nome + "," + cpf;
    }

    public int exibeMenuEscolha(Scanner sc) {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1 - Adicionar Hambúrguer");
        System.out.println("2 - Adicionar Acompanhamento/Bebida");
        System.out.println("3 - Adicionar Combo");
        System.out.println("4 - Finalizar Pedido");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
        return sc.nextInt();
    }

    public int exibeMenuHamburguer(Scanner sc) {
        System.out.println("\n--- ESCOLHA O HAMBURGUER ---");
        System.out.println("1 - Bacon");
        System.out.println("2 - Triplo");
        System.out.println("3 - Vegetariano");
        System.out.println("0 - Sair");
        System.out.print("Opção: ");
        return sc.nextInt();
    }

    public int exibeMenuExtras(Scanner sc) {
        System.out.println("\n--- ESCOLHA O EXTRA ---");
        System.out.println("1 - Cheddar Extra");
        System.out.println("2 - Molho Extra");
        System.out.println("3 - Sem Extra");

        System.out.print("Opção: ");
        return sc.nextInt();
    }

    public int exibeMenuCombos(Scanner sc) {
        System.out.println("\n--- COMBOS PROMOCIONAIS ---");
        System.out.println("1 - Combo Gigante (X-Triplo c/ Cheddar Extra + Batata + Cerveja)");
        System.out.println("2 - Combo Casal (2x X-Bacon + Batata + 2x Refri)");
        System.out.println("3 - Combo Padrão (X-Bacon + Batata + Refri)");
        System.out.print("Opção: ");
        return sc.nextInt();
    }

    public int exibeMenuAcompanhamentos(Scanner sc) {
        System.out.println("\n--- ACOMPANHAMENTOS E BEBIDAS ---");
        System.out.println("1 - Batata Frita");
        System.out.println("2 - Refrigerante");
        System.out.println("3 - Cerveja");
        System.out.print("Opção: ");
        return sc.nextInt();
    }

    public int exibeMenuPagamento(Scanner sc) {
        System.out.println("\n--- FINALIZANDO ---");
        System.out.println("Selecione o Pagamento:");
        System.out.println("1 - PIX");
        System.out.println("2 - Crédito");
        System.out.println("3 - Débito");
        return sc.nextInt();
    }
}
