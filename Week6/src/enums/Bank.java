package enums;

public enum Bank {
    DSK("DSK", "bin123", "4748123"),
    FIB("Fibank", "bin123", "4748123");

    private String description;
    private String bin;
    private String bic;

    Bank(String description, String bin, String bic) {
        this.description = description;
        this.bin = bin;
        this.bic = bic;
    }

    public String getDescription() {
        return description;
    }

    public String getBin() {
        return bin;
    }

    public String getBic() {
        return bic;
    }
}
