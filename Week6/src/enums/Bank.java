package enums;

public enum Bank {
    DSK("DSK bank", "BICDSK"),
    FIB("FIB enums.Bank", "BICFIB");

    private String bic;
    private String name;

    Bank(String bic, String name) {
        this.bic = bic;
        this.name = name;
    }

    public String getBic() {
        return bic;
    }

    public String getName() {
        return name;
    }
}
