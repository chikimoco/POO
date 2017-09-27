/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;
import java.io.File;
import java.util.Scanner;
import bank.Bank;
/**
 *
 * @author ZARA
 */
public class ScannerBank {
    public static void main(String args[]){
        File bankFile = new File("Bank.txt");
        try{
            
            Scanner scan = new Scanner(bankFile);
            String bankData = scan.next();
            String vector[] = bankData.split(",");
            int maxClients = Integer.parseInt(vector[1]);
            Bank thisBank = new Bank(maxClients);
            System.out.print(thisBank);
            
            ScannerCustomer.scanCustomers(thisBank);
            ScannerAccount.scanAccounts(thisBank);
        }
        catch(Exception exc){
            System.err.print(exc);
        }
    }
}
