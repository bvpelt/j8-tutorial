package nl.bsoft;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlakyTest {

    // Test should fail, but \u000A // is read as new line and code is compiled
    @Test
    public void doTest() {
        // Flakey test ! \u000A if (true) return;
        assertEquals("false", "true");
    }
}
