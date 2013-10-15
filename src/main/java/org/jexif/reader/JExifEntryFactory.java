package org.jexif.reader;

import org.jexif.api.JExifException;
import org.jexif.api.common.JExifTag;
import org.jexif.api.common.JExifTagNumber;
import org.jexif.api.common.JExifValue;
import org.jexif.api.common.type.JExifType;
import org.jexif.api.common.type.JExifTypeFactory;
import org.jexif.api.reader.JExifEntry;
import org.jexif.api.reader.JExifReaderFactoryException;
import org.jexif.reader.tag.database.api.JExifTagsDatabase;
import org.jexif.reader.tag.database.api.JExifTagsDatabaseException;
import org.jexif.reader.tag.database.impl.InMemoryJExifTagsDatabase;

import java.nio.ByteBuffer;

public class JExifEntryFactory {
    private JExifTagNumberFactory tagNumberFactory;
    private JExifTypeFactory typeFactory;
    private JExifTagsDatabase tagsDatabase;
    private JExifValueFactory valueFactory;

    public JExifEntryFactory() throws JExifTagsDatabaseException {
        this.tagNumberFactory = new JExifTagNumberFactory();
        this.typeFactory = new JExifTypeFactory();
        this.tagsDatabase = new InMemoryJExifTagsDatabase();
        this.valueFactory = new JExifValueFactory();
    }

    public JExifEntry createEntry(ByteBuffer bb) throws JExifReaderFactoryException {
        try {
            JExifTagNumber tagNumber = tagNumberFactory.createNumber(bb);
            JExifType type = typeFactory.createById(bb.getShort());
            short count = (short) bb.getInt();
            JExifTag tag = tagsDatabase.getTag(tagNumber, type);
            JExifValue value = valueFactory.createValue(bb);
            return new JExifEntry(tag, type, count, value);
        } catch (JExifException ex) {
            throw new JExifReaderFactoryException(ex);
        }
    }
}
