package enums;

public class Main {
    public static void main(String[] args) {
        TransferService tf = new TransferService();

        tf.transferMoney("dsa", 100,
                Bank.DSK, Bank.FIB);
    }
}
