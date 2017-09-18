package projectofecha;

/**
 * Class Bank Creates new types of Banks
 * @author  edgar.cambranes
 */
public class Bank{
    //Attributes of the class
    private Customer[] clients;//Vector of Custumers
    private int numberOfCustomers;//Number of Customers in the bank
    

    /**
    * Constructor Bank
    * Set the number max of clients
    * Initialize clients with the valor of max clients
    * Initialize number of clients in zero
    * @param maxClients Number max of clients
    * 
    */
    public Bank(int maxClients){
        clients = new Customer[maxClients];
        numberOfCustomers = 0;
    }
    
    /**
     * Method addCustumer
     * Add a custumer to the vector of custumers in the current bank
     * @param client Custumer to add to the current bank
     * @return boolean return true if the custumer was added sucessfully
    */
    public boolean addCustomer(Customer client){
        boolean flag = false;
        if(numberOfCustomers < clients.length ){
            clients[numberOfCustomers] = client;
            numberOfCustomers++;
            flag = true;
        }
        return flag;
    }
    
    /**
     * Method removeCustomer
     * remove a custumer searching his unique id in the vector of clients
     * @param IDcustomer Unique id of customer 
     * @return false if there is not any Customer with that Id
     */
    public boolean removeCustomer(int IDcustomer){
        boolean flag = false;
            for(int i = 0; i < numberOfCustomers; i++){
                if(clients[i].getIDCustomer() == IDcustomer){
                    clients[i] = clients[numberOfCustomers-1];
                    clients[numberOfCustomers-1] = null;
                    numberOfCustomers--;
                    flag = true;
                }
            }
        
        return flag;
    }
    
    /**
     * Method editCustomer 
     * Edit a Customer searching his Unique Id and Editing His Name an Last Name
     * @param IDcustomer Unique ID of Customer
     * @param firstName Name to edit
     * @param lastName Last Name to edit
     * @return false if there is not a Customer with the specified Id
     */
    public boolean editCustomer(int IDcustomer,String firstName, String lastName){
        boolean flag = false;
            for(int i = 0; i < numberOfCustomers; i++){
                if(clients[i].getIDCustomer() == IDcustomer){
                    clients[i].setFirstName(firstName);
                    clients[i].setLastName(lastName);
                }
            }
        
        return flag;
    }
    
    /**
     * Method searchClient 
     * Make a Search of a Client with the Unique Id of a Customer
     * if the Client is finded the method will return the Custumer object
     * @param IDClient Id to search
     * @return null if the client was not finded
     */
    public Customer searchClient(int IDClient){
        Customer temp = null;
        for(Customer client: clients){
            if(client.getIDCustomer() == IDClient){
                temp = client;
            }
        }
        return temp;
    }
    
    /**
     * Method toString
     * Return a String representation of each clients and his Accounts
     * @return String, List of Clients in the bank and their info
     */
    public String toString(){
      String output= "";
      for(int i = 0; i < numberOfCustomers; i++){
          output += clients[i].toString() +"\n";
      }
      return output;
    }
     
}//End of class
