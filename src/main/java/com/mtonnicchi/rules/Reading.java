package com.mtonnicchi.rules;

import com.mtonnicchi.numberlabeler.NumberLabeler;
import com.mtonnicchi.rules.readingResolver.ReadingResolver;
import com.mtonnicchi.rules.readingResolver.ReadingResolverAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@XmlRootElement(name = "reading")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reading {

    @XmlAttribute(name = "pattern")
    @XmlJavaTypeAdapter(PatternAdapter.class)
    private Pattern pattern;

    @XmlValue
    @XmlJavaTypeAdapter(ReadingResolverAdapter.class)
    private ReadingResolver readingResolver;

    public boolean canBeAppliedTo(String number) {
        return pattern.matcher(number).matches();
    }

    public String applyTo(NumberLabeler numberLabeler, String number) {
        Matcher matcher = pattern.matcher(number);
        matcher.find();
        Map<Integer, String> params
                = IntStream
                .range(1, matcher.groupCount() + 1)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), i -> matcher.group(i)));
        return this.readingResolver.resolve(numberLabeler, params);
    }
}
