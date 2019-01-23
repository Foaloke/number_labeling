package com.mtonnicchi.rules.readingResolver;

import com.mtonnicchi.numberlabeler.NumberLabeler;

import java.util.Map;

public interface ReadingResolver {
    String resolve(NumberLabeler numberLabeler, Map<Integer, String> params);

    String getReadingString();
}
