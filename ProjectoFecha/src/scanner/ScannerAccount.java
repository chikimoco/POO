/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;
import bank.*;
import java.io.File;
import java.util.Scanner;
/**
 *
 * @author ZARA
 */
public class ScannerAccount {
    public static void scanAccounts(Bank bank){
        File accountsFile = new File("Account.txt");
        try{
            Scanner scan = new Scanner(accountsFile);
            while(scan.hasNext()){
                
               String accountData = scan.next();
               String vector[]  = accountData.split(",");
               int id = Integer.parseInt(vector[0]);
               double balance = Double.parseDouble(vector[2]);
               for (int i = 0;i == bank.getNumberOfCustomers()-1;i++){
                   if(bank.searchClient(i).getAccount(id) != null){
                   Account account = bank.searchClient(i).getAccount(id);
                   account.setBalance(balance);
                   account.setType(vector[1]);
                   }
               }
            }
            
        }
        catch(Exception exc){
            System.out.print(exc);
        }
    }
}
