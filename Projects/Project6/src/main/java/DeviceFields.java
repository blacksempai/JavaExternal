public enum DeviceFields {
    DEVICES("devices"),
    DEVICE("device"),
    NAME("name"),
    ORIGIN("origin"),
    PRICE("price"),
    TYPE("type"),
    PERIPHERAL("peripheral"),
    GROUP("group"),
    PORT("port"),
    CRITICAL("critical"),
    POWER("power")
    ;

    private String value;
    public String getValue(){
        return value;
    }
    private DeviceFields(String value) {
        this.value = value;
    }
}
