import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;
import components.map.Map1L;
import components.queue.Queue;
import components.queue.Queue1L;
import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;

/**
 * test sets for methods of Glossary not including the print methods.
 **/
public class GlossaryTest {

    /*
     * Test of getOneTerm, checks different possible representation of terms and
     * their definitions
     */

    @Test
    public void getOneTerm() {
        SimpleReader input = new SimpleReader1L("test.txt");
        Map<String, String> pairs = new Map1L<String, String>();
        Map<String, String> pairsExpected = new Map1L<String, String>();
        Queue<String> random = new Queue1L<>();
        Queue<String> randomExpected = new Queue1L<>();
        randomExpected.enqueue("anger");
        randomExpected.enqueue("hurt");
        randomExpected.enqueue("fury");
        while (!input.atEOS()) {
            Glossary.getOneTerm(input, pairs, random);
        }
        assertEquals(randomExpected, random);
        pairsExpected.add("anger", "fury");
        pairsExpected.add("hurt",
                "physical pain, or maybe mental.? or maybe psychological!");
        pairsExpected.add("fury", "extreme anger");
        assertEquals(pairsExpected, pairs);
        input.close();
    }

    /*
     * Tests of nextWord
     */

    @Test
    public void nextWord1() {
        Set<Character> separators = new Set1L<>();
        separators.add(' ');
        separators.add(',');
        int position = 0;
        String definition = "  , , go, Bucks ";
        Queue<String> defWords = new Queue1L<>();
        while (position < definition.length()) {
            // method call to get words
            String words = Glossary.nextWord(definition, position, separators);
            // add the words returned by method in defWords in the same order as received
            defWords.enqueue(words);
            position += words.length();
        }
        Queue<String> expectedDefWords = new Queue1L<>();
        expectedDefWords.enqueue("  , , ");
        expectedDefWords.enqueue("go");
        expectedDefWords.enqueue(", ");
        expectedDefWords.enqueue("Bucks");
        expectedDefWords.enqueue(" ");
        assertEquals(expectedDefWords, defWords);
    }

    @Test
    public void nextWord2() {
        Set<Character> separators = new Set1L<>();
        separators.add(' ');
        separators.add(',');
        int position = 0;
        String definition = "go, Bucks";
        Queue<String> defWords = new Queue1L<>();
        while (position < definition.length()) {
            // method call to get words
            String words = Glossary.nextWord(definition, position, separators);
            // add the words returned by method in defWords in the same order as received
            defWords.enqueue(words);
            position += words.length();
        }
        Queue<String> expectedDefWords = new Queue1L<>();
        expectedDefWords.enqueue("go");
        expectedDefWords.enqueue(", ");
        expectedDefWords.enqueue("Bucks");
        assertEquals(expectedDefWords, defWords);
    }

    @Test
    public void nextWord3() {
        Set<Character> separators = new Set1L<>();
        separators.add(' ');
        separators.add(',');
        int position = 0;
        String definition = ",";
        Queue<String> defWords = new Queue1L<>();
        while (position < definition.length()) {
            // method call to get words
            String words = Glossary.nextWord(definition, position, separators);
            // add the words returned by method in defWords in the same order as received
            defWords.enqueue(words);
            position += words.length();
        }
        Queue<String> expectedDefWords = new Queue1L<>();
        expectedDefWords.enqueue(",");
        assertEquals(expectedDefWords, defWords);
    }

    @Test
    public void nextWord4() {
        Set<Character> separators = new Set1L<>();
        separators.add(' ');
        separators.add(',');
        int position = 0;
        String definition = " ";
        Queue<String> defWords = new Queue1L<>();
        while (position < definition.length()) {
            // method call to get words
            String words = Glossary.nextWord(definition, position, separators);
            // add the words returned by method in defWords in the same order as received
            defWords.enqueue(words);
            position += words.length();
        }
        Queue<String> expectedDefWords = new Queue1L<>();
        expectedDefWords.enqueue(" ");
        assertEquals(expectedDefWords, defWords);
    }

    @Test
    public void nextWord5() {
        Set<Character> separators = new Set1L<>();
        separators.add(' ');
        separators.add(',');
        int position = 0;
        String definition = "goBucks";
        Queue<String> defWords = new Queue1L<>();
        while (position < definition.length()) {
            // method call to get words
            String words = Glossary.nextWord(definition, position, separators);
            // add the words returned by method in defWords in the same order as received
            defWords.enqueue(words);
            position += words.length();
        }
        Queue<String> expectedDefWords = new Queue1L<>();
        expectedDefWords.enqueue("goBucks");
        assertEquals(expectedDefWords, defWords);
    }

}
