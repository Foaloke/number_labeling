package com.mtonnicchi.rules;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "readings")
@XmlAccessorType(XmlAccessType.FIELD)
public class Readings {

    @XmlElement(name = "reading")
    public List<Reading> readings;

    public List<Reading> getReadings() {
        return this.readings;
    }
}
