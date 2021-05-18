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
			System.err.println("\nPix já está ativo\n");
		}

	}

	public void desativarPix() {
		if (this.getContemPix() == true) {
			this.setContemPix(false);
			System.out.println("\nPix desativado com sucesso!");
		} else {
			System.err.println("\nPix já está desativado!\n");
		}

	}

	public void menuPix() {
		if (this.getContemPix() == false) {
			System.out.println("\nO seu Pix está desativado.");
			System.out.print("Você deseja ativar o PIX? (S/N): ");
			dado = ler.next();
			if (dado.equalsIgnoreCase("s")) {
				this.ativarPix();
			} else if (dado.equalsIgnoreCase("n")) {
				System.out.println("\nPIX não ativado.");
			} else {
				System.err.println("\nVocê digitou um valor inválido.");
			}
		} else {
			System.out.println("\nO seu Pix está ativo.");
			System.out.print("Você deseja desativar o PIX? (S/N): ");
			dado = ler.next();
			if (dado.equalsIgnoreCase("s")) {
				this.desativarPix();
			} else if (dado.equalsIgnoreCase("n")) {
				System.out.println("\nPIX não desativado.");
			} else {
				System.err.println("\nVocê digitou um valor inválido.");
			}
		}
	}

	public void voltarMenu() {
		System.out.println("Pressione enter para voltar ao menu");
		ler.nextLine();
	}

	@Override
	public String toString() {
		return "Agencia nº: " + agencia + "\nConta nº: " + getNumeroConta() + "\nPix ativado: " + contemPix + "\n";
	}

}
