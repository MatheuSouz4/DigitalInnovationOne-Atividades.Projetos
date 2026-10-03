public class Action {

    private  Account account;
    private  final double OVERDRAFT_FEE_RATE = 0.20;

    public  boolean hasAccount(){
        return  account != null;
    }

    public void setAccount(Account account) {
        if(hasAccount()){
            System.out.println("Há uma conta vinculada ao Sistema.");
            return;
        }
        this.account = account;
    }

    public void consultBalance(){
        if(!hasAccount()){
            System.out.println("Crie uma Conta.");
            return;
        }
        System.out.printf("Saldo Atual: R$ %2f\n", account.getBalance());
    }

    public void consultOverdraftLimit(){
        if(!hasAccount()){
            System.out.println("Crie uma Conta.");
            return;
        }
        System.out.printf("Limite do Cheque Especial: R$ %2f\n", account.getOverdraftLimit());
    }

    public void checkOverdraftUsage(){
        if(!hasAccount()){
            System.out.println("Crie uma Conta.");
            return;
        }
        boolean isUsing = account.getBalance() < 0;
        System.out.printf(isUsing ? "Aviso: Conta ESTÁ no cheque especial." : "Conta NÃO está no cheque especial.");
    }

    public  void deposit( double amount){
        if (!hasAccount()){
            System.out.println("Crie uma Conta.");
            return;
        }
        if (amount <= 0){
            System.out.println("valor Inválido.");
            return;
        }

        account.setBalance(account.getBalance() + amount);
        System.out.printf("R$ %.2f depositado com sucesso.\n", amount);
    }

    public  boolean withdraw(double amount){
        if (!hasAccount()){
            System.out.println("Crie uma Conta.");
            return  false;
        }
        if (amount <= 0){
            System.out.println("Valor de Saque Inválido.");
            return  false;
        }

        double currentBalance = account.getBalance();
        double limit = account.getOverdraftLimit();
        double availableTotal = currentBalance + limit;

        double overdraftUsed = 0;
        double fee = 0;

        if (amount > currentBalance){
            if (currentBalance > 0){
                overdraftUsed = amount - currentBalance;
            } else {
                overdraftUsed = amount;
            }
            fee = overdraftUsed * OVERDRAFT_FEE_RATE;
        }

        if ((amount + fee) > availableTotal){
            System.out.println("Operação Negada! Saldo Total insuficiente.");
            return  false;
        }
        account.setBalance(currentBalance - amount - fee);
        System.out.printf("Saque/Pagamento de R$ %.2f realizado.\n", amount);
        if (fee > 0){
            System.out.printf("Aviso: Uso do Cheque Especial. Taxa de R$ %.2f cobrada.\n", fee);
        }
        return  true;
    }

    public void payBill(double amount, String description) {
        System.out.println("\nProcessando Boleto: " + description);
        boolean success = withdraw(amount);
        if (success) {
            System.out.println("Boleto pago com sucesso!");
        } else {
            System.out.println("Falha ao pagar o boleto.");
        }
    }
}
