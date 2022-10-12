package org.example.shared;

public enum AreaGeografica {
    NORD("nord"),
    CENTRO("centro"),
    SUD("sud");

    private final String area;
    AreaGeografica(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }
}
