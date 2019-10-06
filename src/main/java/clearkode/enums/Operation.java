package clearkode.enums;

import java.util.ArrayList;
import java.util.List;

public enum Operation {

    DIRECT("DIRECT"),
    REFUND("REFUND"),
    STORED("STORED");

    private final String text;

    Operation(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static List<String> valueList() {
        List<String> enumList = new ArrayList<>();
        for (Operation operation : Operation.values()) {
            enumList.add(operation.getText());
        }
        return enumList;
    }

}
