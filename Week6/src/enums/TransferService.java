package enums;

public class TransferService {
    public void transferMoney(final String iban, final int amount,
                              final Bank fromBank, final Bank toBank) {
        final String bicForm = fromBank.getBic();
        final String bicTo = toBank.getBic();
        /// ....

        if (Bank.DSK == Bank.FIB) {

        }
    }
}
