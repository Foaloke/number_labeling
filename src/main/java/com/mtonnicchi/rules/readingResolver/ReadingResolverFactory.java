package com.mtonnicchi.rules.readingResolver;

import com.mtonnicchi.rules.readingResolver.impl.FunctionalReadingResolver;
import com.mtonnicchi.rules.readingResolver.impl.SimpleReadingResolver;

import java.util.Optional;

public class ReadingResolverFactory {

    public static ReadingResolver createFrom(String readingString) {
        return Optional.of(readingString)
                .filter(FunctionalReadingResolver::isFunctionalReading)
                .map(ReadingResolverFactory::createFunctionalReadingResolver)
                .orElse(new SimpleReadingResolver(readingString));
    }

    private static ReadingResolver createFunctionalReadingResolver(String readingString) {
        return new FunctionalReadingResolver(readingString);
    }

}
