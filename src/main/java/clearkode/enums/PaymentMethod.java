package clearkode.enums;

import java.util.ArrayList;
import java.util.List;

public enum PaymentMethod {

    CREDITCARD("CREDITCARD"),
    CUP("CUP"),
    IDEAL("IDEAL"),
    GIROPAY("GIROPAY"),
    MISTERCASH("MISTERCASH"),
    STORED("STORED"),
    PAYTOCARD("PAYTOCARD"),
    CEPBANK("CEPBANK"),
    CITADEL("CITADEL");

    private final String text;

    PaymentMethod(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static List<String> valueList() {
        List<String> enumList = new ArrayList<>();
        for (PaymentMethod paymentMethod : PaymentMethod.values()) {
            enumList.add(paymentMethod.getText());
        }
        return enumList;
    }
}
