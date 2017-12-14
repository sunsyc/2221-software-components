import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;

public class StringReassemblyTest {

    /*
     * Tests of combination
     */

    @Test
    public void testCombination1() {
        String s1 = "getty";
        String s2 = "burg";
        int overlap = 0;
        String result = StringReassembly.combination(s1, s2, overlap);
        assertEquals("gettyburg", result);
    }

    @Test
    public void testCombination2() {
        String s1 = "getty";
        String s2 = "getty";
        int overlap = 0;
        String result = StringReassembly.combination(s1, s2, overlap);
        assertEquals("gettygetty", result);
    }

    @Test
    public void testCombination3() {
        String s1 = "ABCC";
        String s2 = "CCDE";
        int overlap = 2;
        String result = StringReassembly.combination(s1, s2, overlap);
        assertEquals("ABCCDE", result);
    }

    /*
     * Tests of addToSetAvoidSubstrings
     */

    @Test
    public void testaddToSetAvoidingSubstrings1() {
        Set<String> strSet = new Set1L<>();
        strSet.add("getty");
        strSet.add("burg");
        String str = "gettyburg";
        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        Set<String> result = new Set1L<>();
        result.add(str);
        assertEquals(result, strSet);
    }

    @Test
    public void testaddToSetAvoidingSubstrings2() {
        Set<String> strSet = new Set1L<>();
        strSet.add("getty");
        strSet.add("burg");
        String str = "getty";
        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        Set<String> result = new Set1L<>();
        result.add("getty");
        result.add("burg");
        assertEquals(result, strSet);
    }

    @Test
    public void testaddToSetAvoidingSubstrings3() {
        Set<String> strSet = new Set1L<>();
        strSet.add("getty");
        strSet.add("burg");
        String str = "OSU";
        StringReassembly.addToSetAvoidingSubstrings(strSet, str);
        Set<String> result = new Set1L<>();
        result.add("getty");
        result.add("burg");
        result.add("OSU");
        assertEquals(result, strSet);
    }

    /*
     * Tests of linesFromInput
     */

    @Test
    public void testLinesFromInput1() {
        SimpleReader input = new SimpleReader1L("input1.txt");
        Set<String> strSet = new Set1L<>();
        strSet.add("gettyburg");
        Set<String> result = StringReassembly.linesFromInput(input);
        input.close();
        assertEquals(result, strSet);
    }

    @Test
    public void testLinesFromInput2() {
        SimpleReader input = new SimpleReader1L("input2.txt");
        Set<String> strSet = new Set1L<>();
        strSet.add("getty");
        strSet.add("OSU");
        Set<String> result = StringReassembly.linesFromInput(input);
        input.close();
        assertEquals(result, strSet);
    }
}