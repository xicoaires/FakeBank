import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);

		// Variáveis globais
		String agencia;
		int conta;
		int opcao;
		double valor;
		String dado;

		Cliente cliente1 = new Cliente();
		ContaCorrente cc1 = new ContaCorrente();
		cliente1.setCpf("123.456.789-10");
		cliente1.setNome("Inês Istente");
		cc1.setAgencia("1010");
		cc1.setNumeroConta(1);
		cc1.setContemPix(false);
		cc1.setTipo("CC");
		cc1.setSaldoContaCorrente(1000);

		ContaPoupanca cp1 = new ContaPoupanca();
		cp1.setSaldoContaPoupanca(500);
		cp1.setTipo("CP");
		cp1.setAgencia("1010");
		cp1.setNumeroConta(1);

		System.out.println("FakeBank\n");
		System.out.print("Digite a sua agência: ");
		agencia = ler.nextLine();
		System.out.print("Digite a sua conta: ");
		conta = ler.nextInt();

		if (agencia.equals("1010")) {
			if (conta == 1) {

				System.out.println("\nOlá. Seja bem vinda, " + cliente1.getNome() + "!\n");

				do {
					System.out.println("----------------------");
					System.out.println("|  FakeBank - Menu   |");
					System.out.println("|                    |");
					System.out.println("| 1 - SACAR          |");
					System.out.println("| 2 - DEPOSITAR      |");
					System.out.println("| 3 - TRANSFERÊNCIA  |");
					System.out.println("| 4 - SALDO          |");
					System.out.println("| 5 - MEUS DADOS     |");
					System.out.println("| 6 - PIX            |");
					System.out.println("| 0 - SAIR           |");
					System.out.println("----------------------\n");

					System.out.print("Digite a operação desejada: ");
					opcao = ler.nextInt();

					switch (opcao) {
					case 1: // SAQUE
						System.out.print("\nVocê quer sacar da Conta Corrente ou da Conta Poupança?\n"
								+ "\nC - Conta Corrente" + "\nP - Conta Poupança\n");

						dado = ler.next();

						if (dado.equalsIgnoreCase("c")) {
							cc1.saqueCorrente();
						} else if (dado.equalsIgnoreCase("p")) {
							cp1.saquePoupanca();
						} else {
							System.err.println("Você digitou uma opção inválida.\n");
						}
						cc1.voltarMenu();
						break;

					case 2:// DEPÓSITO

						System.out.print("\nVocê quer depositar na Conta Corrente ou na Conta Poupança?"
								+ "\nC - Conta Corrente" + "\nP - Conta Poupança\n");
						dado = ler.next();

						if (dado.equalsIgnoreCase("c")) {
							cc1.depositoCorrente();
							System.out.println("Depósito realizado com sucesso!\n");
						} else if (dado.equalsIgnoreCase("p")) {
							cp1.depositoPoupanca();
							System.out.println("Depósito realizado com sucesso!\n");
						} else {
							System.err.println("\nVocê digitou um valor inválido.\n");
						}
						cc1.voltarMenu();
						break;

					case 3: // TRANSFERÊNCIA
						System.out.println("Você quer fazer uma transferência de qual conta?\n" + "\nC - Conta Corrente"
								+ "\nP - Conta Poupança");
						dado = ler.next();

						if (dado.equalsIgnoreCase("c")) {
							valor = cc1.valor;
							cc1.transferenciaCorrente(valor, cp1);
						} else if (dado.equalsIgnoreCase("p")) {
							valor = cp1.valor;
							cp1.transferenciaPoupanca(valor, cc1);
						} else {
							System.err.println("\nVocê digitou um valor inválido.\n");
						}

						cc1.voltarMenu();
						break;

					case 4: // SALDO
						System.out.println("\nSeu saldo atual da Conta Corrente é R$ " + cc1.getSaldoContaCorrente());
						System.out.println(
								"Seu saldo atual da Conta Poupança é R$ " + cp1.getSaldoContaPoupanca() + "\n");
						cc1.voltarMenu();
						break;

					case 5: // DADOS BANCÁRIOS
						if (cc1.getAgencia() == "1010") {
							if (cc1.getNumeroConta() == 1) {
								System.out.println(cliente1.toString());
								System.out.println(cc1.toString());
								cc1.voltarMenu();

							}
						}
						break;

					case 6: // ATIVAR E DESATIVAR PIX
						cc1.menuPix();

						System.out.println("\nPressione enter para voltar ao menu");
						ler.nextLine();
						ler.nextLine();
						break;

					case 0: // SAIR
						System.out.println("\nAté mais!");
						break;

					default:
						System.err.println("\nVocê digitou uma opção inválida\n");
						break;
					}
				} while (opcao != 0);

				ler.close();
			} else {
				System.out.println("Cliente não localizado.");
			}
		} else

		{
			System.out.println("Cliente não localizado.");
		}
	}
}