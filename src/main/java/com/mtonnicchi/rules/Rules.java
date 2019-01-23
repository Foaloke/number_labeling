package com.mtonnicchi.rules;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "rules")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rules {

    @XmlElement(name = "rule")
    private List<Rule> rules;

    public List<Rule> getRules() {
        return this.rules;
    }
}
