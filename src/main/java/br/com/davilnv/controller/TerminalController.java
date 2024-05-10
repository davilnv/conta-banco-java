package br.com.davilnv.controller;

import java.util.Scanner;

public class TerminalController {

    public static String menuCadastroConta(Scanner teclado) {
        System.out.println(" ------------------------ 1 - Criar conta ------------------------ \n"
                + " -> Digite seu nome: ");

        String nome = teclado.next();

        System.out.println(" ------------------------------------------------------------------------- \n");

        return nome;
    }

}