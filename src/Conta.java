import java.util.Scanner;

public abstract class Conta {
	private Cliente cliente;
	private String agencia;
	private int numeroConta;
	private boolean contemPix = false;
	private double saldoConta;
	private String tipo;
	Scanner ler = new Scanner(System.in);
	String dado;

	public double getSaldoConta() {
		return saldoConta;
	}

	public void setSaldoConta(double saldoConta) {
		this.saldoConta = saldoConta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public boolean getContemPix() {
		return contemPix;
	}

	public void setContemPix(boolean contemPix) {
		this.contemPix = contemPix;
	}

	public void ativarPix() {
		if (this.getContemPix() == false) {
			this.setContemPix(true);
			System.out.println("\nPix ativado com sucesso");
		} else {
			System.err.println("\nPix j� est� ativo\n");
		}

	}

	public void desativarPix() {
		if (this.getContemPix() == true) {
			this.setContemPix(false);
			System.out.println("\nPix desativado com sucesso!");
		} else {
			System.err.println("\nPix j� est� desativado!\n");
		}

	}

	public void menuPix() {
		if (this.getContemPix() == false) {
			System.out.println("\nO seu Pix est� desativado.");
			System.out.print("Voc� deseja ativar o PIX? (S/N): ");
			dado = ler.next();
			if (dado.equalsIgnoreCase("s")) {
				this.ativarPix();
			} else if (dado.equalsIgnoreCase("n")) {
				System.out.println("\nPIX n�o ativado.");
			} else {
				System.err.println("\nVoc� digitou um valor inv�lido.");
			}
		} else {
			System.out.println("\nO seu Pix est� ativo.");
			System.out.print("Voc� deseja desativar o PIX? (S/N): ");
			dado = ler.next();
			if (dado.equalsIgnoreCase("s")) {
				this.desativarPix();
			} else if (dado.equalsIgnoreCase("n")) {
				System.out.println("\nPIX n�o desativado.");
			} else {
				System.err.println("\nVoc� digitou um valor inv�lido.");
			}
		}
	}

	public void voltarMenu() {
		System.out.println("Pressione enter para voltar ao menu");
		ler.nextLine();
	}

	@Override
	public String toString() {
		return "Agencia n�: " + agencia + "\nConta n�: " + getNumeroConta() + "\nPix ativado: " + contemPix + "\n";
	}

}
