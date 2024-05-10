package br.com.davilnv.app;

import br.com.davilnv.controller.TerminalController;
import br.com.davilnv.exception.BancoException;
import br.com.davilnv.model.Banco;
import br.com.davilnv.model.BancoImpl;
import br.com.davilnv.model.Conta;

import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {

        Banco banco = new BancoImpl("067-8");
        try {
            banco.iniciarSistema();
        } catch (BancoException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        Scanner teclado = new Scanner(System.in);

        System.out.println(" =========== Terminal da Conta =========== ");

        String menuLabel = """
                 ------------------------------- MENU -------------------------------\s
                 1 - Criar conta
                 2 - Entrar na conta\s
                 3 - Encerrar terminal\s
                """;

        while (true) {

            System.out.println(menuLabel);

            int opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    Conta conta;
                    String nome = TerminalController.menuCadastroConta(teclado);
                    if (nome != null && !nome.isEmpty()) {
                        conta = new Conta(nome.toUpperCase().trim(), 0.0);
                        try {
                            banco.cadastrarConta(conta);
                        } catch (BancoException e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                    } else {
                        System.err.println("Nome do cliente não pode ser nulo ou vazio!");
                        break;
                    }
                    System.out.println("Olá " + conta.getNomeCliente() + ", obrigado por criar uma conta em nosso banco, sua agência é " + conta.getAgencia() + ", conta " + conta.getNumero() + " e seu saldo " + conta.getSaldo() + " já está disponível para saque");
                    break;
                case 2:
                    System.out.println("Entrou na conta!");
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }
        }
    }


}