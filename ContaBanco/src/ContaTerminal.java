import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {

    int numero;
    String agencia;
    String nome;
    String sobrenome;
    Double saldo;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Bem Vindo ao MsSystems Bank\nVamos iniciar o seu Cadastro.\n\nDigite o número da Conta:");
        int numero = scanner.nextInt();
        System.out.println("Digite a Agência:");
        String agencia = scanner.next();
        System.out.println("Digite seu Nome:");
        String nome = scanner.next();
        System.out.println("Digite seu Sobrenome:");
        String sobrenome = scanner.next();
        System.out.println("Digite um saldo para Saque:");
        Double saldo = scanner.nextDouble();

        System.out.println("Olá " +nome+ " " + sobrenome +", obrigado por criar a sua conta no MsSystems Bank, sua agência é " +agencia+ " conta " +numero+ " e seu saldo de " +saldo+ " já está disponível para saque.");
    }
}
