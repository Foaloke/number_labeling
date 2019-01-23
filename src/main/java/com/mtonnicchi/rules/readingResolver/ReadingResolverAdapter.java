package com.mtonnicchi.rules.readingResolver;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ReadingResolverAdapter extends XmlAdapter<String, ReadingResolver> {
    @Override
    public ReadingResolver unmarshal(String readingString) throws Exception {
        return ReadingResolverFactory.createFrom(readingString);
    }

    @Override
    public String marshal(ReadingResolver readingResolver) throws Exception {
        return readingResolver.getReadingString();
    }
}
