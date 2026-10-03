public class Account {

    private double balance;
    private final double overdraftLimit;

    public Account(double initialDeposit){
        this.balance = initialDeposit;

        if(initialDeposit <= 500.00){
            this.overdraftLimit = 50.00;
        } else {
            this.overdraftLimit = initialDeposit * 0.50;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}
