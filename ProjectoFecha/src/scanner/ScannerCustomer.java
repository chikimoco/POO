package scanner;

import java.io.File;
import java.util.Scanner;
import bank.Bank;
import bank.Customer;

public class ScannerCustomer{
  public static void scanCustomers(Bank bank){    
   File file = new File("Customer.txt");
    try{
        
        Scanner sc = new Scanner(file);
        while (sc.hasNext()) {
          String output = sc.next();
          System.out.println(output);
          String vector[] = output.split(",");
          
          bank.addCustomer(new Customer(Integer.parseInt(vector[0]),vector[1],vector[2]));
          for (int i = 3;i > vector.length ;i++){
              bank.searchClient(Integer.parseInt(vector[0])).setAcount(i);
          }
      }
    
   }
    catch(Exception exc){
        System.err.print(exc);
    }
  }
}