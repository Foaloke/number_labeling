package com.mtonnicchi;

import com.mtonnicchi.numberlabeler.NumberLabeler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:app.properties")
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

        if(args.length == 0){
            System.out.println("Pass a number as parameter to the application to have its reading");
            System.exit(0);
        }

        System.out.println();
        System.out.println();
        try {
            System.out.println(args[0] + " => " + ctx.getBean(NumberLabeler.class).label(args[0]));
        } catch (Exception e) {
            System.out.println("Input not supported ("+args[0]+")");
        }
        System.out.println();
        System.out.println();
    }

}
