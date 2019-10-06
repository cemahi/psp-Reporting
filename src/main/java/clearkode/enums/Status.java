package clearkode.enums;

import java.util.ArrayList;
import java.util.List;

public enum Status {
    APPROVED("APPROVED"),
    WAITING("WAITING"),
    DECLINED("DECLINED"),
    ERROR("ERROR");

    private final String text;

    Status(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static List<String> valueList() {
        List<String> enumList = new ArrayList<>();
        for (Status status : Status.values()) {
            enumList.add(status.getText());
        }
        return enumList;
    }
}
