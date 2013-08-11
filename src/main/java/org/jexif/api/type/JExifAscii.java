package org.jexif.api.type;

public class JExifAscii extends AbstractJExifType {

    private static final String NAME = "ASCII";
    private static final short ID = 2;
    public static final JExifAscii instance = new JExifAscii();

    private JExifAscii() {
        super(ID, NAME);
    }
}
