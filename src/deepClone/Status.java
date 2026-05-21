package deepClone;

public enum Status {
    // 🌟 注意：这三个是枚举项，后面紧跟着括号和分号！
    AVAILABLE("AVAILABLE (待骑行)"),
    IN_USE("IN_USE (骑行中)"),
    MAINTENANCE("MAINTENANCE (维修中)"); // 🌟 最后一个枚举项后面必须是分号【;】！

    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}