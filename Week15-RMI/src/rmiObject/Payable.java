/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiObject;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author grade
 */
public interface Payable extends Remote {
//annual interest rate, number of years and loan amount
    double monthlyPayment(double rate, double loanAmount) throws RemoteException;

    double totalyPayment(double rate, double loanAmount, int years) throws RemoteException;

}
