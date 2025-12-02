package main;

import ui.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        SistemaLancheria sistema = new SistemaLancheria(menu);
        sistema.iniciar();
    }
}