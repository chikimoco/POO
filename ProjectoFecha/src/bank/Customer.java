package bank;

/**
 * Class Customer
 * Creates Clients that can be added to banks
 * @author edgar.cambranes
 */
public class Customer{
    //Attributes of the class
    private static int IDkey;//Global variable for new ID´s
    private int IDCustomer;//Id of the Customer
    private String firstName;//Name of Customer
    private String lastName;//Last name of Customer
    private Account accounts[];//Vector of accounts associated with the client
    
    private int numberOfAccounts;//Current number of accounts
    
    /**
     * Constructor ONE Customer 
     * Sets the Id of the new Customer taking the Global Variable IDKey and
     * increases this by one
     * @param firstName sets the name of the client
     * @param lastName sets the lastname of the client
     */
    public Customer(int id, String firstName, String lastName ){
        this.IDCustomer = id;
        IDkey++;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Customer (String firstName, String lastName) {
        this.IDCustomer =IDkey;
        IDkey++;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    /**
     * Constructor TWO Customer 
     * Sets the Id of the new Customer taking the Global Variable IDKey and
     * increases this by one
     * @param firstName sets the name of the client
     * @param lastName sets the lastname of the client
     * @param maxAccounts sets the maximum number of accounts for the client
     */  
    public Customer (String firstName, String lastName, int maxAccounts) {
        this.IDCustomer =IDkey;
        IDkey++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new Account[maxAccounts];
    }
    
    /**
     * Gets the Id of current Customer
     * @return id
     */
    public int getIDCustomer(){
        return IDCustomer;
    }
    
    /**
     * Gets the number of Accounts that have the client
     * @return int number of accounts
     */
    public int getNumberOfAccounts(){
        return numberOfAccounts;
    }
    
    /**
     * Set the name of the client
     * @param firstName name of client
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    /**
     * Gets the name of client
     * @return String name
     */
    public String getFirstName(){
        return this.firstName;
    }
    
    /**
     * Set the last name of the client
     * @param lastName last name of client
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    /**
     * Gets the last name of client
     * @return String last name
     */
    public String getLastName(){
        return this.lastName;
    }
    
    /**
     * Method to add a new account to the vector of accounts in the current cutomer
     * increases in one the number of accounts
     * @param account account to add to the current customer
     * @return boolean return true if the account was added sucessfully
     */
    public boolean addAccount(Account account){
        boolean flag = false;
        if(numberOfAccounts < accounts.length ){
            accounts[numberOfAccounts] = account;
            numberOfAccounts++;
            flag = true;
        }
        return flag;
    }
    public boolean setAcount(int id){
        boolean flag = false;
        if(numberOfAccounts < accounts.length ){
            accounts[numberOfAccounts] = new Account(id);
            numberOfAccounts++;
            flag = true;
        }
        return flag;
    }
    /**
     * Method removeAccount
     * remove a account searching his unique id in the vector of accounts
     * @param IDAccount Unique id of account
     * @return false if there is not any account with that id
     */
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
    
    /**
     * Method searchAccount
     * Make a Search of an Account with the Unique Id of the account
     * if the account is finded the method will return the Account object
     * @param IDAccount Id to search
     * @return null if the Accoubnt was not finded
     */
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
    
    /**
     * Gets an Account if the Id Exist
     * @return id Account
     * @param IDAccount id of account
     */
    public Account getAccount(int IDAccount){                
        return searchAccount(IDAccount);
    }
    
    /**
     * Gets all the Accounts what does the client have
     * @return id Accounts Vector
     */
    public Account[] getAccounts(){
        return accounts;
    }
    
    /**
     * Method to edit the Account 
     * Search the id account in the vector of accounts and modify the balance
     * @param IDAccount Id to search
     * @param balance Balance to modify
     * @return true if the id was finded
     */
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
    
    /**
     * Method to know if snd object is a Customer and have the same id 
     * @param obj object customer to compare
     * @return true if the object is the same
     */
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
    
    /**
     * Method that returns a String with the info of the current Customer
     * and all his accounts 
     * @return String with the info
     */
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
    
    /**
     * Method to transfer money from a debit card to another one from the same client
     * @param IDSender id of the account tha will pay
     * @param IDReciever id of the account tha will recive
     * @param ammount ammoubnt to give
     * @return true if the transaction was successful
     */
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
    
    /**
     * Method to transfer money from a debit card to a credit one from the same client
     * @param IDSender id of the account tha will pay
     * @param IDReciever id of the account tha will recive
     * @param ammount ammount to give
     * @return true if the transaction was successful
     */
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
    
    /**
     * Method to transfer money from a debit card to a debit one from another client
     * @param IDSender id of the account tha will pay
     * @param IDReciever id of the account tha will recive
     * @param rCustomer Custumer that will recive the money
     * @param ammount ammount to give
     * @return true if the transaction was successful
     */
    public boolean thirdTransferDD(int IDSender, Customer rCustomer, int IDReciever, double ammount){
        boolean flag = false;
        Account sender = null;
        Account reciever = null;
        int i;
        Account rAccounts[] = null;
        rAccounts = rCustomer.getAccounts();
        for(i = 0;i < numberOfAccounts;i++){
            if(accounts[i].getIDAccount()==IDSender){
                sender = accounts[i];
            }
        }
        for(i = 0;i < rCustomer.getNumberOfAccounts();i++){
             if(rAccounts[i].getIDAccount()==IDReciever){
                reciever = rAccounts[i];
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

}//End of class                               

