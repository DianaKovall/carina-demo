package koval.video.web.saucedemo;

public enum SortOptions {
    A_TO_Z("az"),
    Z_TO_A("za"),
    LOW_TO_HIGH("lohi"),
    HIGH_TO_LOW("hilo");

    final String value;


    SortOptions(String value) {
        this.value = value;

    }


    public String getValue() {
        return value;
    }
}
