package nl.bsoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 */
public class App {

    private final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        App app = new App();
        app.doTests();
        app.doStreamTests();
        app.doLambdaTests();
    }

    public void doTests() {
        Itest it = new Itest();

        logger.info("Start doTest01");
        it.doTest01();
        logger.info("End   doTest01");

        logger.info("Start doTest02");
        it.doTest02();
        logger.info("End   doTest02");

        logger.info("Start doTest03");
        it.doTest03();
        logger.info("End   doTest03");

        logger.info("Start doTest04");
        it.doTest04();
        logger.info("End   doTest04");
    }

    public void doStreamTests() {
        MyStream ms = new MyStream();

        logger.info("Start doFilter");
        ms.doFilter();
        logger.info("End   doFilter");
        logger.info("Start doPrint");
        ms.doPrint();
        logger.info("End   doPrint");
        logger.info("Start doMap");
        ms.doMap();
        logger.info("End   doMap");
        logger.info("Start doParallel");
        ms.doParallel();
        logger.info("End   doParallel");
        logger.info("Start doCollectors");
        ms.doCollectors();
        logger.info("End   doCollectors");
        logger.info("Start statistics");
        ms.statistics();
        logger.info("End   statistics");
        logger.info("Start pipeline");
        ms.pipeline();
        logger.info("End   pipeline");
        logger.info("Start findFirst");
        ms.findFirst();
        logger.info("End   findFirst");
        logger.info("Start sum01");
        ms.sum01();
        logger.info("End   sum01");
    }

    public void doLambdaTests() {
        MyLambda ml = new MyLambda();

        logger.info("Start oldSort");
        ml.oldSort();
        logger.info("End   oldSort");
        logger.info("Start lambdaSort");
        ml.lambdaSort();
        logger.info("End   lambdaSort");
        logger.info("Start useFunctionalInterface");
        ml.useFunctionalInterface();
        logger.info("End   useFunctionalInterface");

    }
}
