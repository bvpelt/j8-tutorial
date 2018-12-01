package nl.bsoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyLambda {
    private final Logger logger = LoggerFactory.getLogger(MyLambda.class);

    public void oldSort() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        logger.info("unsorted names: {}", names);

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        logger.info("  sorted names: {}", names);
    }

    public void lambdaSort() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        logger.info("unsorted names: {}", names);

        Collections.sort(names, (a, b) -> b.compareTo(a));
        logger.info("  sorted names: {}", names);
    }

    public void useFunctionalInterface() {
        String value = "123";
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert(value);
        logger.info("input string: {} converted to {}", value, converted);

        Converter<Integer, String> iconverter = (from) -> String.valueOf(from);
        String ivalue = iconverter.convert(converted);
        logger.info("input int: {} converted to {}", converted, ivalue);
    }

}
