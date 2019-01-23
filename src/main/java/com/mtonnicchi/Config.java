package com.mtonnicchi;

import com.mtonnicchi.numberlabeler.NumberLabeler;
import com.mtonnicchi.rules.Rule;
import com.mtonnicchi.rules.Rules;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Configuration
public class Config {

    private static final String RULES_PATH = "classpath:rules.xml";

    @Bean
    public NumberLabeler numberLabeler(List<Rule> rules) {
        return new NumberLabeler(rules);
    }

    @Bean
    public List<Rule> rules(ApplicationContext ctx) throws IOException, JAXBException {
        InputStream rulesFile = ctx.getResource(RULES_PATH).getInputStream();
        JAXBContext jContext = JAXBContext.newInstance(Rules.class);
        Unmarshaller unmarshallerObj = jContext.createUnmarshaller();
        return ((Rules) unmarshallerObj.unmarshal(rulesFile)).getRules();
    }

}
