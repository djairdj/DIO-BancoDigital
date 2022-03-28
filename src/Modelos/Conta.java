package Modelos;

public abstract class Conta implements IConta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;

    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.saldo = 0;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor > 0 ? valor : 0;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor > 0 ? valor : 0;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns() {
        System.out.printf("Titular %s%n", this.cliente.getNome());
        System.out.printf("Agencia %d%n", this.agencia);
        System.out.printf("Numero %d%n", this.numero);
        System.out.printf("Saldo %.2f%n", this.saldo);
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

}