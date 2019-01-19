/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiClient;

import rmiObject.Payable;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grade
 */
public class PaymentTest {

    public static void main(String[] args) {
        try {
            Registry r = LocateRegistry.getRegistry(1099);
            Payable payment = null;
            try {
                payment = (Payable) r.lookup("payment");
            } catch (NotBoundException ex) {
                Logger.getLogger(PaymentTest.class.getName()).log(Level.SEVERE, null, ex);
            } catch (AccessException ex) {
                Logger.getLogger(PaymentTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            NumberFormat percentFormat = NumberFormat.getPercentInstance();
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
            double paymentAmount = payment.monthlyPayment(0.05, 1000.);
            System.out.printf("Rate: %s, Amount: %s, Monthly payment: %s%n",
                    percentFormat.format(0.05),
                    currencyFormat.format(1000.0),
                    currencyFormat.format(paymentAmount));
            paymentAmount =payment.totalyPayment(0.05, 1000., 12);
            System.out.printf("Total payment at the end of the year: %s%n", 
                                        currencyFormat.format(paymentAmount));
        } catch (RemoteException ex) {
            Logger.getLogger(PaymentTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
