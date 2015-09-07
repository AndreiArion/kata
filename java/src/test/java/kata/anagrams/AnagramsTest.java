package kata.anagrams;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class AnagramsTest {
    IAnagrams IAnagrams = new AnagramsNaiveV1();
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
        assertThat(IAnagrams.computeAnagrams("", Collections.<String>emptySet())).isEmpty();
    }

    @Test
    public void shouldReturnNullIfNullInputs() {
        assertThat(IAnagrams.computeAnagrams(null, null)).isEqualTo(null);
    }

    @Test
    public void shouldReturnCorrectResult() {
        assertThat(IAnagrams.computeAnagrams(piecrust, alternativesList)).isEqualTo(alternativesList);
    }

    @Test
    public void shouldNotReturnNonAnagrams() {
        String wrong = "wrong";
        alternativesList.add(wrong);
        assertThat(IAnagrams.computeAnagrams(piecrust, alternativesList)).doesNotContain(wrong);
    }

    @Test
    public void shouldHaveDecentPerformance() {
        long initTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            IAnagrams.computeAnagrams(piecrust, alternativesList);
        }
        long duration = System.currentTimeMillis() - initTime;
        System.out.println("Took:" + duration + " ms.");
        assertThat(duration).isLessThan(700);// functional implementation passes this
        assertThat(duration).isLessThan(300);// functional implementation does not pass this - typical 50ms
    }


}