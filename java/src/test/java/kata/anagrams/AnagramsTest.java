package kata.anagrams;

import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class AnagramsTest {
    Anagrams anagrams = new Anagrams();


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
        Set<String> alternativesList = new HashSet<>();
        alternativesList.add("crepitus");
        alternativesList.add("cuprites");
        alternativesList.add("piecrust");
        assertThat(anagrams.computeAnagrams("piecrust", alternativesList)).isEqualTo(alternativesList);
    }

    @Test
    public void shouldNotReturnNonAnagrams() {
        Set<String> alternativesList = new HashSet<>();
        alternativesList.add("crepitus");
        alternativesList.add("cuprites");
        alternativesList.add("piecrust");
        String wrong = "wrong";
        alternativesList.add(wrong);
        assertThat(anagrams.computeAnagrams("piecrust", alternativesList)).doesNotContain(wrong);
    }

}