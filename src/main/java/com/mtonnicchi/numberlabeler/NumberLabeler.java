package com.mtonnicchi.numberlabeler;

import com.mtonnicchi.rules.Rule;

import java.util.List;

public class NumberLabeler {

    private final List<Rule> rules;

    public NumberLabeler(List<Rule> rules) {
        this.rules = rules;
    }

    public String label(String number) {
        return rules.stream()
                .filter(rule -> rule.canBeAppliedTo(number))
                .map(rule -> rule.applyTo(this, number))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No rule found for number: " + number));
    }
}
