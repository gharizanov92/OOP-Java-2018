package enums;

public class TransferService {
    public void transfer(int sum, String iban,
                         Bank fromBank, Bank toBank) {

        if (fromBank == toBank) {

        }

        // doTransfer
        fromBank.getBic();
        fromBank.getBin();
        fromBank.getDescription();
    }

    public static void main(String[] args) {
        final TransferService transferService = new TransferService();

        transferService.transfer(100, "iban1",
                Bank.DSK, Bank.FIB);
    }
}
