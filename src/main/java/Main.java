import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);
    private final static Action action = new Action();

    public static void main(String[] args) {

        var option = -1;

        do {
            System.out.println("\n======== Sistema Bancário ========");
            System.out.println("1 - Criar Conta Bancária.");
            System.out.println("2 - Consultar Saldo.");
            System.out.println("3 - Consultar Cheque Especial.");
            System.out.println("4 - Depositar dinheiro.");
            System.out.println("5 - Sacar dinheiro.");
            System.out.println("6 - Pagar um boleto.");
            System.out.println("7 - Verificar uso de cheque especial.");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option){
                case 1 -> createAccount();
                case 2 -> action.consultBalance();
                case 3 -> action.consultOverdraftLimit();
                case 4 -> makeDeposit();
                case 5 -> makeWithdrawal();
                case 6 -> payABill();
                case 7 -> action.checkOverdraftUsage();
                case 0 -> System.exit(0);
                default -> System.out.println("Opção inválida.");
            }

        } while (true);
    }

    private static void createAccount() {
        if (action.hasAccount()) {
            System.out.println("Uma conta já foi criada e está em uso.");
            return;
        }
        System.out.print("Informe o valor do depósito inicial (R$): ");
        var initialDeposit = scanner.nextDouble();

        if(initialDeposit < 0){
            System.out.println("Depósito inicial não pode ser negativo.");
            return;
        }

        var account = new Account(initialDeposit);
        action.setAccount(account);
        System.out.println("Conta criada e vinculada com sucesso!");
    }

    private static void makeDeposit() {
        if(!action.hasAccount()){
            System.out.println("Crie uma conta primeiro (Opção 1).");
            return;
        }
        System.out.print("Informe o valor para depósito (R$): ");
        var amount = scanner.nextDouble();
        action.deposit(amount);
    }

    private static void makeWithdrawal() {
        if(!action.hasAccount()){
            System.out.println("Crie uma conta primeiro (Opção 1).");
            return;
        }
        System.out.print("Informe o valor para saque (R$): ");
        var amount = scanner.nextDouble();
        action.withdraw(amount);
    }

    private static void payABill() {
        if(!action.hasAccount()){
            System.out.println("Crie uma conta primeiro (Opção 1).");
            return;
        }
        System.out.print("Informe uma palavra para a descrição do boleto (Ex: Luz): ");
        var description = scanner.next();

        System.out.print("Informe o valor do boleto (R$): ");
        var amount = scanner.nextDouble();

        action.payBill(amount, description);
    }
}