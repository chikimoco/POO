/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectofecha;

/**
 *
 * @author hugop
 */
public class Debit extends Account {

    public Debit(String typeAccount, double balance) {
        super(typeAccount, balance);
    }
    
    public double withdraw(double ammount){
        if (balance >= ammount) {
            balance = balance - ammount;
        }
        return balance;
    }
    
    public double deposit(double ammount) {
        this.balance = this.balance + ammount;
        return balance;
    }
 
}
