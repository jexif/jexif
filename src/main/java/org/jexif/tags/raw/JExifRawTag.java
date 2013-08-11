package org.jexif.tags.raw;

public class JExifRawTag {

    private final String name;
    private final String number;
    private final String type;
    private int count;
    private byte[] defaultValue;

    public JExifRawTag(String name, String number, String type) {
        this.name = name;
        this.number = number;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public byte[] getDefaultValue() {
        return defaultValue;
    }
}


