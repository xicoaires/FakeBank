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
		System.out.print("\nQual valor voc� deseja sacar da Conta Poupan�a? R$ ");
		valor = ler.nextDouble();
		this.sacar(valor);

	}

	public void depositoPoupanca() {
		System.out.print("\nQual o valor que voc� deseja depositar na Conta Poupan�a? R$ ");
		valor = ler.nextDouble();
		this.depositar(valor);

	}

	public void transferenciaPoupanca(double valor, ContaCorrente cc) {
		System.out.println("\nO seu saldo na Conta Poupan�a �: R$ " + this.getSaldoContaPoupanca());
		System.out.print("\nDigite o valor que voc� quer transferir da Conta Poupan�a para a Conta Corrente: R$ ");
		valor = ler.nextDouble();
		if (this.getSaldoContaPoupanca() >= valor) {
			this.sacar(valor);
			cc.depositar(valor);
			System.out.println("\nTransfer�ncia realizada com sucesso!");
			System.out.println("O saldo atual da Conta Poupanca �: R$ " + this.getSaldoContaPoupanca() + "\n");
		} else {
			System.err.println("Saldo insuficiente\n");
		}
	}
}
