package nl.bsoft;

import org.objenesis.ObjenesisStd;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.function.Consumer;

public class Itest {
    private final Logger logger = LoggerFactory.getLogger(Itest.class);

    public static <T> void setPrivateFieldValue(Class<T> type, String fieldName, T receiver, Object newValue) throws NoSuchFieldException, IllegalAccessException {
        var field = type.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(receiver, newValue);
    }

    ;

    // java can use any unicode character also in code
    public void doTest01() {
        var ints = List.of(1, 2, 3);
        Consumer<Integer> λ = i -> System.out.println(i);
        ints.forEach(λ);
    }

    public void doTest02() {
        try {
            var field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            field.set(5, 4);

            // Integer is fetched from cache, int not!!!!!
            int j = 0;
            for (Integer i = 0; i < 10; i++) {
                System.out.println(i);
                j++;
                if (j > 5) {
                    break;
                }
            }
        } catch (Exception e) {
            logger.error("Exception: {}", e);
        }
    }

    public void doTest03() {
        var objenesis = new ObjenesisStd();
        Void avoid = objenesis.newInstance(Void.class);
        logger.info("avoid: {}", avoid);
    }

    public void doTest04() {
        var objenesis = new ObjenesisStd();

        Singleton copy = objenesis.newInstance(Singleton.class);
        try {
            setPrivateFieldValue(Enum.class, "ordinal", copy, 0);
            setPrivateFieldValue(Enum.class, "name", copy, "INSTANCE");

            for (Singleton s : Singleton.values()) {
                logger.info("Singleton value: {}", s);
            }
        } catch (NoSuchFieldException e) {
            logger.error("NoSuchField: {}", e);
        } catch (IllegalAccessException e) {
            logger.error("IllegalAccess: {}", e);
        }
    }

    enum Singleton {INSTANCE}
}
