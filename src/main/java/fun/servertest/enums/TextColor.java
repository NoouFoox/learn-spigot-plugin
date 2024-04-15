package fun.servertest.enums;

public enum TextColor {
    WHITE("§f");
    private final String value;
    TextColor(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
