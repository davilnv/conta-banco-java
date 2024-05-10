package br.com.davilnv.model;

public class Conta {
    private int numero;
    private String agencia;
    private String nomeCliente;
    private double saldo;

    public Conta() {
    }

    public Conta(int numero, String agencia) {
        this.numero = numero;
        this.agencia = agencia;
    }


    public Conta(String nomeCliente, double saldo) {
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Conta && ((Conta) obj).numero == numero && ((Conta) obj).agencia.equals(agencia);
    }

}
