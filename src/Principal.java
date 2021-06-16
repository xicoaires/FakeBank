import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);

		// Vari�veis globais
		String agencia;
		int conta;
		int opcao;
		double valor;
		String dado;

		Cliente cliente1 = new Cliente();
		ContaCorrente cc1 = new ContaCorrente();
		cliente1.setCpf("123.456.789-10");
		cliente1.setNome("In�s Istente");
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
		System.out.print("Digite a sua ag�ncia: ");
		agencia = ler.nextLine();
		System.out.print("Digite a sua conta: ");
		conta = ler.nextInt();

		if (agencia.equals("1010")) {
			if (conta == 1) {

				System.out.println("\nOl�. Seja bem vinda, " + cliente1.getNome() + "!\n");

				do {
					System.out.println("----------------------");
					System.out.println("|  FakeBank - Menu   |");
					System.out.println("|                    |");
					System.out.println("| 1 - SACAR          |");
					System.out.println("| 2 - DEPOSITAR      |");
					System.out.println("| 3 - TRANSFER�NCIA  |");
					System.out.println("| 4 - SALDO          |");
					System.out.println("| 5 - MEUS DADOS     |");
					System.out.println("| 6 - PIX            |");
					System.out.println("| 0 - SAIR           |");
					System.out.println("----------------------\n");

					System.out.print("Digite a opera��o desejada: ");
					opcao = ler.nextInt();

					switch (opcao) {
					case 1: // SAQUE
						System.out.print("\nVoc� quer sacar da Conta Corrente ou da Conta Poupan�a?\n"
								+ "\nC - Conta Corrente" + "\nP - Conta Poupan�a\n");

						dado = ler.next();

						if (dado.equalsIgnoreCase("c")) {
							cc1.saqueCorrente();
						} else if (dado.equalsIgnoreCase("p")) {
							cp1.saquePoupanca();
						} else {
							System.err.println("Voc� digitou uma op��o inv�lida.\n");
						}
						cc1.voltarMenu();
						break;

					case 2:// DEP�SITO

						System.out.print("\nVoc� quer depositar na Conta Corrente ou na Conta Poupan�a?"
								+ "\nC - Conta Corrente" + "\nP - Conta Poupan�a\n");
						dado = ler.next();

						if (dado.equalsIgnoreCase("c")) {
							cc1.depositoCorrente();
							System.out.println("Dep�sito realizado com sucesso!\n");
						} else if (dado.equalsIgnoreCase("p")) {
							cp1.depositoPoupanca();
							System.out.println("Dep�sito realizado com sucesso!\n");
						} else {
							System.err.println("\nVoc� digitou um valor inv�lido.\n");
						}
						cc1.voltarMenu();
						break;

					case 3: // TRANSFER�NCIA
						System.out.println("Voc� quer fazer uma transfer�ncia de qual conta?\n" + "\nC - Conta Corrente"
								+ "\nP - Conta Poupan�a");
						dado = ler.next();

						if (dado.equalsIgnoreCase("c")) {
							valor = cc1.valor;
							cc1.transferenciaCorrente(valor, cp1);
						} else if (dado.equalsIgnoreCase("p")) {
							valor = cp1.valor;
							cp1.transferenciaPoupanca(valor, cc1);
						} else {
							System.err.println("\nVoc� digitou um valor inv�lido.\n");
						}

						cc1.voltarMenu();
						break;

					case 4: // SALDO
						System.out.println("\nSeu saldo atual da Conta Corrente � R$ " + cc1.getSaldoContaCorrente());
						System.out.println(
								"Seu saldo atual da Conta Poupan�a � R$ " + cp1.getSaldoContaPoupanca() + "\n");
						cc1.voltarMenu();
						break;

					case 5: // DADOS BANC�RIOS
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
						System.out.println("\nAt� mais!");
						break;

					default:
						System.err.println("\nVoc� digitou uma op��o inv�lida\n");
						break;
					}
				} while (opcao != 0);

				ler.close();
			} else {
				System.out.println("Cliente n�o localizado.");
			}
		} else

		{
			System.out.println("Cliente n�o localizado.");
		}
	}
}