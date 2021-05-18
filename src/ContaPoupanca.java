import java.util.Scanner;

public class ContaPoupanca extends Conta {

	private double saldoContaPoupanca;
	private String tipo;
	double valor;
	Scanner ler = new Scanner(System.in);

	public double getSaldoContaPoupanca() {
		return saldoContaPoupanca;
	}

	public void setSaldoContaPoupanca(double saldoContaPoupanca) {
		this.saldoContaPoupanca = saldoContaPoupanca;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void sacar(double valor) {
		if (this.saldoContaPoupanca >= valor) {
			setSaldoContaPoupanca(getSaldoContaPoupanca() - valor);

		} else {
			System.err.println("Saldo insuficiente");
		}
	}

	public void depositar(double valor) {
		setSaldoContaPoupanca(getSaldoContaPoupanca() + valor);

	}

	public void saquePoupanca() {
		System.out.print("\nQual valor você deseja sacar da Conta Poupança? R$ ");
		valor = ler.nextDouble();
		this.sacar(valor);

	}

	public void depositoPoupanca() {
		System.out.print("\nQual o valor que você deseja depositar na Conta Poupança? R$ ");
		valor = ler.nextDouble();
		this.depositar(valor);

	}

	public void transferenciaPoupanca(double valor, ContaCorrente cc) {
		System.out.println("\nO seu saldo na Conta Poupança é: R$ " + this.getSaldoContaPoupanca());
		System.out.print("\nDigite o valor que você quer transferir da Conta Poupança para a Conta Corrente: R$ ");
		valor = ler.nextDouble();
		if (this.getSaldoContaPoupanca() >= valor) {
			this.sacar(valor);
			cc.depositar(valor);
			System.out.println("\nTransferência realizada com sucesso!");
			System.out.println("O saldo atual da Conta Poupanca é: R$ " + this.getSaldoContaPoupanca() + "\n");
		} else {
			System.err.println("Saldo insuficiente\n");
		}
	}
}
