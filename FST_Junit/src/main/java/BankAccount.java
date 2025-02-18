public class BankAccount {
    private Integer balance;

    public BankAccount(Integer initBalance){
        balance=initBalance;
    }
    public Integer withdraw(Integer amount){
        if(balance<amount){
            throw new NotEnoughFundsException(amount,balance);
        }
        balance-=amount;
        return balance;
    }

}