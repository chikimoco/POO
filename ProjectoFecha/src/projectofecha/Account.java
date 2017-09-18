package projectofecha;

/**
 * Class Account
 * Creates Accounts that can be added to Customers
 * @author edgar.cambranes
 */
public class Account{  
    //Attributes of the class
    public static final String CREDIT= "CREDIT";//Final Variable Type of Account
    public static final String DEBIT = "DEBIT";//Final Variable Type of Account
    
    private static int IDkey;//Global variable for new ID´s
    private int IDaccount;//Id of the account
    private double balance; // Balance of the account
    private String typeAccount;//Type Of Account credit or debit
    
    /**
     * Constructor Acconut creates new accounts 
     * Sets the Id of the new Account taking the Global Variable IDKey and
     * increases this by one. Set the balance od account
     * @param typeAccount type of account
     * @param balance balance of the account
     */
    public Account (String typeAccount, double balance) {               
        this.IDaccount =IDkey;
        IDkey++;
        this.typeAccount = typeAccount;
        this.balance = balance;
    }
    
    /**
     * Method Withdraw
     * Remove money from the account if the type is debit
     * Else increase the money if the type is credit
     * @param ammount valor to modify
     * @return balance of account
     */
    public double withdraw(double ammount){
        if(balance>=ammount&&typeAccount.equals(DEBIT)){
            balance = balance - ammount;
        }
        else if("CREDIT".equals(typeAccount)){
            balance = balance + ammount;
        }
        return balance;
    }
    
    /**
     * Method deposit
     * Remove money from the account if the type is credit
     * Else increase the money if the type is debit
     * @param ammount valor to modify
     * @return balance of account
     */
    public double deposit(double ammount){
        if(balance>ammount&&typeAccount.equals(CREDIT)){
            this.balance = this.balance - ammount;
        }
        else{
            this.balance = this.balance + ammount;
        }
        return balance;
    }
    
    /**
     * set the balance of the account
     * @param balance balance to modify
     */
    public void setBalance (double balance){
        this.balance = balance;
    }
    
    /**
     * get the balance of the account
     * @return balance
     */
    public double getBalance (){
        return balance;
    }
    
    /**
     * get the id of the account
     * @return id
     */
    public int getIDAccount(){
        return this.IDaccount;
    }
    
    /**
     * get the type of the account
     * @return String Type
     */
    public String getType(){
        return this.typeAccount;
    }
    
    /**
     * String info of the account
     * @return String representation of the account
     */
    public String toString(){
        return "ID Account: " +IDaccount +
               ", Type: " + typeAccount+
               " ,Balance: " + balance;
    }
}
