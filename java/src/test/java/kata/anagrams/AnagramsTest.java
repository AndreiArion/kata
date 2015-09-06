package kata.anagrams;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class AnagramsTest {
    Anagrams anagrams = new Anagrams();
    Set<String> alternativesList = new HashSet<>();
    String piecrust = "piecrust";


    @Before
    public void setUp() {
        alternativesList.add("crepitus");
        alternativesList.add("cuprites");
        alternativesList.add(piecrust);
    }

    @Test
    public void shouldReturnEmptyForEmptyWord(){
        assertThat(anagrams.computeAnagrams("", Collections.<String>emptySet())).isEmpty();
    }

    @Test
    public void shouldReturnNullIfNullInputs() {
        assertThat(anagrams.computeAnagrams(null, null)).isEqualTo(null);
    }

    @Test
    public void shouldReturnCorrectResult() {
        assertThat(anagrams.computeAnagrams(piecrust, alternativesList)).isEqualTo(alternativesList);
    }

    @Test
    public void shouldNotReturnNonAnagrams() {
        String wrong = "wrong";
        alternativesList.add(wrong);
        assertThat(anagrams.computeAnagrams(piecrust, alternativesList)).doesNotContain(wrong);
    }

    @Test
    public void shouldHaveDecentPerformance() {
        long initTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            anagrams.computeAnagrams(piecrust, alternativesList);
        }
        long duration = System.currentTimeMillis() - initTime;
        System.out.println("Took:" + duration + " ms");
        assertThat(duration).isLessThan(10);
    }


}