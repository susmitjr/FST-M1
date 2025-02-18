import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Activity2 {


    @Test
    void notEnoughFunds(){
        BankAccount bankAccount1=new BankAccount(100);
        assertThrows(NotEnoughFundsException.class, ()->bankAccount1.withdraw(200));
    }

    @Test
    void enoughFunds(){
        BankAccount bankAccount2= new BankAccount(10000);
        assertDoesNotThrow( ()->bankAccount2.withdraw(0000));


    }
}
