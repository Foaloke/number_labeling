package com.mtonnicchi.rules;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.regex.Pattern;

public class PatternAdapter extends XmlAdapter<String, Pattern> {
    @Override
    public Pattern unmarshal(String pattern) {
        return Pattern.compile(pattern);
    }

    @Override
    public String marshal(Pattern pattern) {
        return pattern.pattern();
    }
}
