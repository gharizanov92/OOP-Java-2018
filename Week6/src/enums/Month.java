package enums;

public enum Month {
    JAN("January"),
    FEB("February"),
    MAR("March"),
    APR("April"),
    MAY("May"),
    JUN("June");

    //public static Month[] months = {JAN, FEB};

    public static Month[] months = Month.values();

    String strRepresentation;

    Month(String strRepresentation) {
        this.strRepresentation = strRepresentation;
    }

    @Override
    public String toString() {
        return this.strRepresentation;
    }
}
