package org.jexif.api.common.type;

public class JExifSLong extends AbstractJExifType {

    private static final String NAME = "SLONG";
    private static final short ID = 9;
    private static final short BYTES_NO = 4;
    public static final JExifSLong instance = new JExifSLong();

    private JExifSLong() {
        super(ID, NAME, BYTES_NO);
    }
}
