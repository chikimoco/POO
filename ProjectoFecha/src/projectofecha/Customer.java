/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectofecha;

/**
 *
 * @author edgar.cambranes
 */
public class Customer{
    private static int IDkey;
    private int IDCustomer;
    private String firstName;
    private String lastName;
    private Account accounts[];
    private int numberOfAccounts;
    
       
    public Customer (String firstName, String lastName) {
        this.IDCustomer =IDkey;
        IDkey++;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Customer (String firstName, String lastName, int maxAccounts) {
        this.IDCustomer =IDkey;
        IDkey++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new Account[maxAccounts];
    }
    public int getIDCustomer(){
        return IDCustomer;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    public boolean addAccount(Account account){
        boolean flag = false;
        if(numberOfAccounts < accounts.length ){
            accounts[numberOfAccounts] = account;
            numberOfAccounts++;
            flag = true;
        }
        return flag;
    }
    
    public boolean removeAccount(int IDAccount){
        boolean flag = false;
            for(int i = 0; i < numberOfAccounts; i++){
                if(accounts[i].getIDAccount() == IDAccount){
                    accounts[i] = accounts[numberOfAccounts-1];
                    accounts[numberOfAccounts-1] = null;
                    numberOfAccounts--;
                    flag = true;
                }
            }
        
        return flag;
    }
    
    public Account searchAccount(int IDAccount){
        Account temp = null;
        if(accounts != null){
        for(Account account: accounts){
            if(account.getIDAccount() == IDAccount){
                temp = account;
            }
        }
        }
        return temp;
    }
    
    public Account getAccount(int IDAccount){                
        return searchAccount(IDAccount);
    }
    
    public boolean editAccount(int IDAccount,int balance){
        boolean flag = false;
            for(int i = 0; i < numberOfAccounts; i++){
                if(accounts[i].getIDAccount() == IDAccount){
                    accounts[i].setBalance(balance);
                    flag = true;
                    break;
                }
            }
        return flag;
    }
    
    
    @Override
    public boolean equals(Object obj){
        boolean flag = false;
        if (obj != null && obj instanceof Customer){
            Customer customerTemp = (Customer)obj;
            if(this.IDCustomer == customerTemp.IDCustomer){
                flag = true;
            }
        }
        
        return flag;
    }
    
    public String toString(){
        String output = "ID Customer: " + this.IDCustomer+
               " ,Fist Name: " + this.firstName+
               " ,Last Name: " + this.lastName + "\n" +
               "Accounts:" + "\n";
        
                for(int i = 0; i < numberOfAccounts; i++){
                output += accounts[i].toString() +"\n";
                }
        return output;
    }
    
    public boolean myTransferDD(int IDSender, int IDReciever, double ammount){
        Account sender = null;
        Account reciever = null;
        int i;
        boolean flag = false;
        for(i = 0;i < numberOfAccounts;i++){
            if(accounts[i].getIDAccount()==IDSender){
                sender = accounts[i];
            }
            if(accounts[i].getIDAccount()==IDReciever){
                reciever = accounts[i];
            }
        }
        if(!"DEBIT".equals(sender.getType())){
            sender = null;
        }
        if(!"DEBIT".equals(reciever.getType())){
            reciever = null;
        }
        if((sender != null)&&(reciever != null)&&(sender.getBalance()>=ammount)){
            sender.withdraw(ammount);
            reciever.deposit(ammount);
            flag = true;
        }
        return flag;
}
    public boolean myTransferDC(int IDSender, int IDReciever, double ammount){
        Account sender = null;
        Account reciever = null;
        int i;
        boolean flag = false;
        for(i = 0;i < numberOfAccounts;i++){
            if(accounts[i].getIDAccount()==IDSender){
                sender = accounts[i];
            }
            if(accounts[i].getIDAccount()==IDReciever){
                reciever = accounts[i];
            }
        }
        if(!"DEBIT".equals(sender.getType())){
            sender = null;
        }
        if(!"CREDIT".equals(reciever.getType())){
            reciever = null;
        }
        if((sender != null)&&(reciever != null)&&(sender.getBalance()>=ammount)){
            sender.withdraw(ammount);
            reciever.deposit(ammount);
            flag = true;
        }
        return flag;
}

}                               

