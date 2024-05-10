package br.com.davilnv.model;

import br.com.davilnv.exception.BancoException;

public interface Banco {

    void iniciarSistema() throws BancoException;

    Conta cadastrarConta(Conta conta) throws BancoException;

    Conta buscarConta(Conta conta) throws BancoException;

    Conta buscarConta(int numero, String agencia) throws BancoException;

    Conta atualizaConta(Conta conta, Conta contaNova) throws BancoException;

    boolean cancelarConta(Conta conta) throws BancoException;

    boolean contaExiste(Conta conta);

}
