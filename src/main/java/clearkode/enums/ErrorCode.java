package clearkode.enums;

public enum ErrorCode {
    DoNotHonor("Do not honor"),
    InvalidTransaction("Invalid Transaction"),
    InvalidCard("Invalid Card"),
    NotSufficientFunds("Not sufficient funds"),
    IncorrectPIN("Incorrect PIN"),
    InvalidCountryAssociation("Invalid country association"),
    CurrencyNotAllowed("Currency not allowed"),
    THREEDSecureTransportError("3-D Secure Transport Error"),
    TransactionNotPermittedToCardholder("Transaction notpermitted to cardholder");

    private final String text;

    ErrorCode(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
