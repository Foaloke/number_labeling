package com.mtonnicchi.rules;

import com.mtonnicchi.numberlabeler.NumberLabeler;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rule")
@XmlAccessorType(XmlAccessType.FIELD)
public class Rule {

    @XmlAttribute(name = "ge")
    private int ge;

    @XmlAttribute(name = "lt")
    private int lt;

    @XmlElement(name = "readings")
    private Readings readings;

    public boolean canBeAppliedTo(String number) {
        int numberAsInt = Integer.parseInt(number);
        return numberAsInt >= this.ge && numberAsInt < lt;
    }

    public String applyTo(NumberLabeler numberLabeler, String number) {
        return readings.getReadings().stream()
                .filter(reading -> reading.canBeAppliedTo(number))
                .map(reading -> reading.applyTo(numberLabeler, number))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalStateException("No reading found for rule (" + ge + "<n<" + lt + ") and number: " + number));
    }
}
