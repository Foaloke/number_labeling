package com.mtonnicchi.rules.readingResolver.impl;

import com.mtonnicchi.numberlabeler.NumberLabeler;
import com.mtonnicchi.rules.readingResolver.ReadingResolver;

import java.util.Map;

public class SimpleReadingResolver implements ReadingResolver {
    private final String readingString;

    public SimpleReadingResolver(String readingString) {
        this.readingString = readingString;
    }

    @Override
    public String resolve(NumberLabeler numberLabeler, Map<Integer, String> params) {
        return readingString;
    }

    @Override
    public String getReadingString() {
        return this.readingString;
    }
}
