package main;

import facade.LancheriaFacade; // Importe sua nova Facade
import ui.Menu;

import java.util.Scanner;

public class SistemaLancheria {

    private static final String MENSAGEM_ERRO_OPCAO = "Opcao invalida"; 

    private Scanner sc;
    private Menu menu;
    private LancheriaFacade facade;

    public SistemaLancheria(Menu menu) {
        this.menu = menu;
        this.sc = new Scanner(System.in);
        this.facade = new LancheriaFacade();
    }

    public void iniciar() {
        String infoCliente = menu.pedirInfoCLiente(sc);

        facade.iniciarPedido(infoCliente);

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
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        } while (opcaoPrincipal != 0);
        System.out.println("Ate mais, volte sempre!");
    }

    private void selecionarHamburguer() {
        int tipo = menu.exibeMenuHamburguer(sc);
        if (tipo == 0) return;

        int extra = menu.exibeMenuExtras(sc);

        facade.adicionarHamburguer(tipo, extra);
        System.out.println("Hambúrguer adicionado!");
    }

    private void selecionarCombo() {
        int op = menu.exibeMenuCombos(sc);
        facade.adicionarCombo(op);
        System.out.println("Combo adicionado!");
    }

    private void selecionarAcompanhamento() {
        int op = menu.exibeMenuAcompanhamentos(sc);
        facade.adicionarAcompanhamento(op);
        System.out.println("Acompanhamento adicionado!");
    }

    private void selecionarPagamento() {
        facade.exibirResumo();
        int op = menu.exibeMenuPagamento(sc);
        facade.finalizarPedido(op);
    }
}