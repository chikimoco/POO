package bank;

/**
 * Class Test Bank
 * Class for test the banks project
 * @author edgar.cambranes
 */
public class TestBank {
    
   public static void main(String[] args) {
       //Creates a new bank
       Bank narcobanco = new Bank(100);
       //Create five clients
       Customer client1 = new Customer("Chapo","Guzman", 10);
       Customer client2 = new Customer("Pablo","Escobar", 10);
       Customer client3 = new Customer("Amado","Carrillo", 10);
       Customer client4 = new Customer("Carlos","Salinas", 10);
       Customer client5 = new Customer("Rosario","Robles", 10);
       
       //Add the five customers to the created bank
       narcobanco.addCustomer(client1);
       narcobanco.addCustomer(client2);
       narcobanco.addCustomer(client3);
       narcobanco.addCustomer(client4);
       narcobanco.addCustomer(client5);
       
       /*Creates new accounts with the specified type of account and balance
       and are added to the created clients*/
       client1.addAccount(new Account(Account.DEBIT, 1200));
       client1.addAccount(new Account(Account.CREDIT, 34000));
       
       client2.addAccount(new Account(Account.DEBIT, 14500));
       client2.addAccount(new Account(Account.DEBIT, 1200));
       client2.addAccount(new Account(Account.CREDIT, 120000));
       
       client3.addAccount(new Account(Account.DEBIT, 99900));
       
       client4.addAccount(new Account(Account.DEBIT, 6600));
       
       client5.addAccount(new Account(Account.DEBIT, 12345));
       
       
       //Print the String representation of the bank
       System.out.println(narcobanco);
       
       //test of transfers
       client2.myTransferDD(2, 3, 500);
       client2.myTransferDC(2, 4, 500);
       client1.thirdTransferDD(0, client5, 7, 1000);
       
       //Print the String representation of the bank
       System.out.println("\n********\n");
       System.out.println(narcobanco);
       
     

   
   }//End of Main
    
}//End of class
