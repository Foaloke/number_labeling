package com.mtonnicchi.rules.readingResolver.impl;

import com.mtonnicchi.numberlabeler.NumberLabeler;
import com.mtonnicchi.rules.readingResolver.ReadingResolver;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunctionalReadingResolver implements ReadingResolver {

    private static final String REPLACEMENT_FORMAT = "|%s|";
    private static final Pattern FUNCTION_PATTERN = Pattern.compile("(.*?)\\{(.*?)\\}(.*?)");

    private final String readingString;

    public FunctionalReadingResolver(String readingString) {
        this.readingString = readingString;
    }

    public static boolean isFunctionalReading(String readingString) {
        return FUNCTION_PATTERN.matcher(readingString).matches();
    }

    @Override
    public String resolve(NumberLabeler numberLabeler, Map<Integer, String> params) {
        String readingWithReplacements = this.applyReplacements(params);
        return this.resolveFunctions(numberLabeler, readingWithReplacements);
    }

    @Override
    public String getReadingString() {
        return this.readingString;
    }

    private String applyReplacements(Map<Integer, String> params) {
        StringWithReplacements stringWithReplacements = new StringWithReplacements(this.readingString);
        params.entrySet().forEach(entry ->
                stringWithReplacements.applyReplacement(
                        String.format(REPLACEMENT_FORMAT, entry.getKey()),
                        entry.getValue())
        );
        return stringWithReplacements.getString();
    }

    private String resolveFunctions(NumberLabeler numberLabeler, String stringWithFunctions) {
        Matcher matcher = FUNCTION_PATTERN.matcher(stringWithFunctions);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            stringBuffer.append(matcher.group(1));
            matcher.appendReplacement(stringBuffer, numberLabeler.label(matcher.group(2)));
            stringBuffer.append(matcher.group(3));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private class StringWithReplacements {
        private String string;

        public StringWithReplacements(String string) {
            this.string = string;
        }

        public void applyReplacement(String replacementSearch, String replacementString) {
            this.string = this.string.replace(replacementSearch, replacementString);
        }

        public String getString() {
            return this.string;
        }
    }
}
