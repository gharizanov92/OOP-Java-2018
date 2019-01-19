/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiObject;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author grade
 */
public class Payment extends UnicastRemoteObject implements Payable  {
//annual interest rate, number of years and loan amount
    
    public Payment() throws RemoteException{
    }

    @Override
    public double monthlyPayment(double rate, double loanAmount) throws RemoteException {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return rate * loanAmount/ 12;
    }

    @Override
    public double totalyPayment(double rate, double loanAmount, int years) throws RemoteException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        double total = 0;
        for (int i = 01; i < years; i++) {
            total += monthlyPayment( rate,  loanAmount) ;
        }
        return total;
    }

}
