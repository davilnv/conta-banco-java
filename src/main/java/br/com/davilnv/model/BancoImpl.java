package br.com.davilnv.model;

import br.com.davilnv.exception.BancoException;

import java.util.ArrayList;
import java.util.List;

public class BancoImpl implements Banco {

    private int indexContaNumero = 0;
    private final String agencia;
    private List<Conta> contasBancarias;

    public BancoImpl(String agencia) {
        this.agencia = agencia;
    }

    private void iniciarBaseDeDados() throws BancoException {
        if (!verificaBaseDeDados()) {
            contasBancarias = new ArrayList<>();
        } else {
            throw new BancoException("Banco encontra-se inciado!");
        }
    }

    private boolean verificaBaseDeDados() {
        return contasBancarias != null;
    }

    @Override
    public void iniciarSistema() throws BancoException {
        iniciarBaseDeDados();
    }

    @Override
    public Conta cadastrarConta(Conta conta) throws BancoException {
        if (verificaBaseDeDados() && !contaExiste(conta)) {
            conta.setNumero(++indexContaNumero);
            conta.setAgencia(agencia);
            contasBancarias.add(conta);
            return conta;
        }
        throw new BancoException("Conta já existe cadastrada!");
    }

    @Override
    public Conta buscarConta(Conta conta) throws BancoException {
        if (verificaBaseDeDados()) {
            return contasBancarias.stream().filter(c -> c.equals(conta)).findFirst().orElseThrow(() -> new BancoException("Conta não encontrada!"));
        }
        throw new BancoException("Base de dados não existe ou não foi inicializada, contate o administrador do sistema!");
    }

    @Override
    public Conta buscarConta(int numero, String agencia) throws BancoException {
        return buscarConta(new Conta(numero, agencia));
    }

    @Override
    public Conta atualizaConta(Conta conta, Conta contaNova) throws BancoException {
        Conta contaBase = buscarConta(conta);
        int index = contasBancarias.indexOf(contaBase);

        contaBase.setNomeCliente(contaNova.getNomeCliente());

        return contasBancarias.set(index, contaBase);
    }

    @Override
    public boolean cancelarConta(Conta conta) throws BancoException {
        return contasBancarias.remove(buscarConta(conta));
    }

    @Override
    public boolean contaExiste(Conta conta) {
        try {
            buscarConta(conta);
            return true;
        } catch (BancoException e) {
            return false;
        }
    }

}
