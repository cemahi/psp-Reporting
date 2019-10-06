package clearkode.enums;


public enum StaticCacheType  {

    USER_TOKEN("userToken");
    private final String text;

    StaticCacheType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}