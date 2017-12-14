import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

public class NNtoStringWithCommasTest {

    /**
     * Calls the method under test.
     *
     * @param n
     *            the number to pass to the method under test
     * @return the {@code String} returned by the method under test
     * @ensures
     *
     *          <pre>
     * redirectToMethodUnderTest = [String returned by the method under test]
     *          </pre>
     */
    private static String redirectToMethodUnderTest(NaturalNumber n) {
        return NNtoStringWithCommas6.toStringWithCommas(n);
    }

    /**
     * Test toStringWithCommas with input 0.
     */
    @Test
    public void test0() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber nExpected = new NaturalNumber2(0);
        String stCommas = redirectToMethodUnderTest(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nExpected, n);
        assertEquals("0", stCommas);
    }

    /**
     * Test toStringWithCommas with input 1.
     */
    @Test
    public void test1() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber n = new NaturalNumber2(1);
        NaturalNumber nExpected = new NaturalNumber2(1);
        String stCommas = redirectToMethodUnderTest(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nExpected, n);
        assertEquals("1", stCommas);
    }

    /**
     * Test toStringWithCommas with input 10.
     */
    @Test
    public void test10() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber n = new NaturalNumber2(10);
        NaturalNumber nExpected = new NaturalNumber2(10);
        String stCommas = redirectToMethodUnderTest(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nExpected, n);
        assertEquals("10", stCommas);
    }

    /**
     * Test toStringWithCommas with input 100.
     */
    @Test
    public void test100() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber n = new NaturalNumber2(100);
        NaturalNumber nExpected = new NaturalNumber2(100);
        String stCommas = redirectToMethodUnderTest(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nExpected, n);
        assertEquals("100", stCommas);
    }

    /**
     * Test toStringWithCommas with input long natural numbers.
     */
    @Test
    public void testlong() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber n1 = new NaturalNumber2(987654321);
        NaturalNumber n2 = new NaturalNumber2(1000);
        NaturalNumber n = new NaturalNumber2();
        n.copyFrom(n1);
        n.multiply(n2);
        NaturalNumber nExpected = new NaturalNumber2();
        nExpected.copyFrom(n1);
        nExpected.multiply(n2);
        String stCommas = redirectToMethodUnderTest(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nExpected, n);
        assertEquals("987,654,321,000", stCommas);
    }

    /**
     * Test toStringWithCommas with input 1000.
     */
    @Test
    public void test1000() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber n = new NaturalNumber2(1000);
        NaturalNumber nExpected = new NaturalNumber2(1000);
        String stCommas = redirectToMethodUnderTest(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nExpected, n);
        assertEquals("1,000", stCommas);
    }

    /**
     * Test toStringWithCommas with input 10000.
     */
    @Test
    public void test10000() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber n = new NaturalNumber2(10000);
        NaturalNumber nExpected = new NaturalNumber2(10000);
        String stCommas = redirectToMethodUnderTest(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nExpected, n);
        assertEquals("10,000", stCommas);
    }

    /**
     * Test toStringWithCommas with input 9999.
     */
    @Test
    public void test9999() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber n = new NaturalNumber2(9999);
        NaturalNumber nExpected = new NaturalNumber2(9999);
        String stCommas = redirectToMethodUnderTest(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nExpected, n);
        assertEquals("9,999", stCommas);
    }

    /**
     * Test toStringWithCommas with input 999999999.
     */
    @Test
    public void test999999999() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber n = new NaturalNumber2(999999999);
        NaturalNumber nExpected = new NaturalNumber2(999999999);
        String stCommas = redirectToMethodUnderTest(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nExpected, n);
        assertEquals("999,999,999", stCommas);
    }

    /**
     * Test toStringWithCommas with input 123456789.
     */
    @Test
    public void testOrder() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber n = new NaturalNumber2(123456789);
        NaturalNumber nExpected = new NaturalNumber2(123456789);
        String stCommas = redirectToMethodUnderTest(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nExpected, n);
        assertEquals("123,456,789", stCommas);
    }

    /**
     * Test toStringWithCommas with input 1000000000.
     */
    @Test
    public void test1000000000() {
        /*
         * Set up variables and call method under test
         */
        NaturalNumber n = new NaturalNumber2(1000000000);
        NaturalNumber nExpected = new NaturalNumber2(1000000000);
        String stCommas = redirectToMethodUnderTest(n);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(nExpected, n);
        assertEquals("1,000,000,000", stCommas);
    }

}
