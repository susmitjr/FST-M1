public class NotEnoughFundsException extends RuntimeException{

    public NotEnoughFundsException(Integer amount , Integer balance)
    {
        super("Attempted request: "+amount+" and current Balance: "+balance);
    }

}
