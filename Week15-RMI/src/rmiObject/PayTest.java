/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmiObject;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author echrk
 */
public class PayTest {

    public static void main(String[] args) {
        try {
            Payable o = new Payment();
            Registry registry = LocateRegistry.createRegistry(1099);
            //Registry registry = LocateRegistry.getRegistry("localhost",1099);

            registry.rebind("payment", o);
        } catch (RemoteException ex) {
            System.out.println("remote" + ex);
        }
        //must be running in order to keep the Registry active
    }
}
