import java.util.Scanner;

public class ContaCorrente extends Conta {

	private double saldoContaCorrente;
	private String tipo;
	double valor;

	Scanner ler = new Scanner(System.in);

	public double getSaldoContaCorrente() {
		return saldoContaCorrente;
	}

	public void setSaldoContaCorrente(double saldoContaCorrente) {
		this.saldoContaCorrente = saldoContaCorrente;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void exibirSaldoContaCorrente() {
		System.out.println("Seu saldo da Conta Corrente é: R$ " + this.saldoContaCorrente);
	}

	public void sacar(double valor) {
		if (getSaldoContaCorrente() >= valor) {
			setSaldoContaCorrente(getSaldoContaCorrente() - valor);
		} else {
			System.err.println("Saldo insuficiente");
		}
	}

	public void depositar(double valor) {
		setSaldoContaCorrente(getSaldoContaCorrente() + valor);

	}

	public void saqueCorrente() {
		System.out.print("\nQual valor você deseja sacar da Conta Corrente? R$ ");
		valor = ler.nextDouble();
		this.sacar(valor);
	}

	public void depositoCorrente() {
		System.out.print("\nQual o valor que você deseja depositar na Conta Corrente? R$ ");
		valor = ler.nextDouble();
		this.depositar(valor);

	}

	public void transferenciaCorrente(double valor, ContaPoupanca cp) {
		System.out.println("\nO seu saldo na Conta Corrente é: R$ " + this.getSaldoContaCorrente());
		System.out.print("\nDigite o valor que você quer transferir da Conta Corrente para a Conta Poupança: R$ ");
		valor = ler.nextDouble();
		if (this.getSaldoContaCorrente() >= valor) {
			this.sacar(valor);
			cp.depositar(valor);
			System.out.println("\nTransferência realizada com sucesso!");
			System.out.println("O saldo atual da Conta Corrente é: R$ " + this.getSaldoContaCorrente() + "\n");
		} else {
			System.err.println("Saldo insuficiente\n");
		}
	}
}
