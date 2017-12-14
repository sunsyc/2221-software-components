import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Shiny Patel.
 *
 */
public class CryptoUtilitiesTest {

    /*
     * Tests of reduceToGCD
     */

    @Test
    public void testReduceToGCD_0_0() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(0);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("0", n.toString());
        assertEquals("0", m.toString());
    }

    @Test
    public void testReduceToGCD_30_21() {
        NaturalNumber n = new NaturalNumber2(30);
        NaturalNumber m = new NaturalNumber2(21);
        CryptoUtilities.reduceToGCD(n, m);
        assertEquals("3", n.toString());
        assertEquals("0", m.toString());
    }

    /*
     * Tests of isEven
     */

    @Test
    public void testIsEven_0() {
        NaturalNumber n = new NaturalNumber2(0);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("0", n.toString());
        assertTrue(result);
    }

    @Test
    public void testIsEven_1() {
        NaturalNumber n = new NaturalNumber2(1);
        boolean result = CryptoUtilities.isEven(n);
        assertEquals("1", n.toString());
        assertTrue(!result);
    }

    /*
     * Tests of powerMod
     */

    @Test
    public void testPowerMod_0_0_2() {
        NaturalNumber n = new NaturalNumber2(0);
        NaturalNumber p = new NaturalNumber2(0);
        NaturalNumber m = new NaturalNumber2(2);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("1", n.toString());
        assertEquals("0", p.toString());
        assertEquals("2", m.toString());
    }

    @Test
    public void testPowerMod_17_18_19() {
        NaturalNumber n = new NaturalNumber2(17);
        NaturalNumber p = new NaturalNumber2(18);
        NaturalNumber m = new NaturalNumber2(19);
        CryptoUtilities.powerMod(n, p, m);
        assertEquals("1", n.toString());
        assertEquals("18", p.toString());
        assertEquals("19", m.toString());
    }

    /**
     * Test of isWitnessToCompositeness
     */

    @Test
    public void testisWitnessToCompositeness_8_9() {
        NaturalNumber w = new NaturalNumber2(8);
        NaturalNumber n = new NaturalNumber2(9);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertTrue(!result);
    }

    @Test
    public void testisWitnessToCompositeness_1_2() {
        NaturalNumber w = new NaturalNumber2(1);
        NaturalNumber n = new NaturalNumber2(2);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertTrue(!result);
    }

    @Test
    public void testisWitnessToCompositeness_11_21() {
        NaturalNumber w = new NaturalNumber2(11);
        NaturalNumber n = new NaturalNumber2(21);
        boolean result = CryptoUtilities.isWitnessToCompositeness(w, n);
        assertTrue(result);
    }

    /**
     * Test of isPrime1
     */

    @Test
    public void testisPrime1_2() {
        NaturalNumber n = new NaturalNumber2(2);
        boolean result = CryptoUtilities.isPrime1(n);
        assertTrue(result);
    }

    @Test
    public void testisPrime1_23() {
        NaturalNumber n = new NaturalNumber2(23);
        boolean result = CryptoUtilities.isPrime1(n);
        assertTrue(result);
    }

    @Test
    public void testisPrime1_13541365() {
        NaturalNumber n = new NaturalNumber2(13541365);
        NaturalNumber large = new NaturalNumber2(1000000000);
        n.multiply(large);
        boolean result = CryptoUtilities.isPrime1(n);
        assertTrue(!result);
    }

    /**
     * Test of isPrime2
     */

    @Test
    public void testisPrime2_1234567891() {
        NaturalNumber n = new NaturalNumber2(1234567891);
        NaturalNumber large = new NaturalNumber2(1000000000);
        n.multiply(large);
        boolean result = CryptoUtilities.isPrime2(n);
        assertTrue(!result);
    }

    @Test
    public void testisPrime2_11() {
        NaturalNumber n = new NaturalNumber2(11);
        boolean result = CryptoUtilities.isPrime2(n);
        assertTrue(result);
    }

    @Test
    public void testisPrime2_2() {
        NaturalNumber n = new NaturalNumber2(2);
        boolean result = CryptoUtilities.isPrime2(n);
        assertTrue(result);
    }

    /**
     * Test of generateNextLikelyPrime
     */

    @Test
    public void testgenerateNextLikelyPrime_123456789() {
        NaturalNumber n = new NaturalNumber2(123456789);
        CryptoUtilities.generateNextLikelyPrime(n);
        NaturalNumber nExpected = new NaturalNumber2(123456791);
        assertEquals(n, nExpected);
    }

    @Test
    public void testgenerateNextLikelyPrime_9() {
        NaturalNumber n = new NaturalNumber2(9);
        CryptoUtilities.generateNextLikelyPrime(n);
        NaturalNumber nExpected = new NaturalNumber2(11);
        assertEquals(n, nExpected);
    }

}
