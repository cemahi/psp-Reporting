package clearkode.enums;

public enum FilterField {
    TransactionUUID("Transaction UUID"),
    CustomerEmail("Customer Email"),
    ReferenceNo("Reference No"),
    CustomData("Custom Data"),
    CardPAN("Card PAN");

    private final String text;

    FilterField(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
