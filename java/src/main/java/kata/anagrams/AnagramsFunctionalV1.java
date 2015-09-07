/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package kata.anagrams;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AnagramsFunctionalV1 implements IAnagrams {
    @Override
    public Set<String> computeAnagrams(String word, Set<String> alternatives) {
        return computeAnagramsV1Functional(word, alternatives);
    }
    private Set<String> computeAnagramsV1Functional(String word, Set<String> alternatives) {
        if (word == null || alternatives == null) return null;
        Set<String> result = new HashSet<>();// Collections.<String>emptySet();
        result.addAll(alternatives.stream().filter(alternative -> isAnagramV1Functional(word, alternative)).collect(Collectors.toList()));
        return result;
    }

    private boolean isAnagramV1Functional(String word, String alternative) {
        List<Character> wordCharacters = word.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        List<Character> sortedWordLetters = wordCharacters.stream().sorted().collect(Collectors.toList());
        List<Character> alternativeCharacters = alternative.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        List<Character> sortedAlternativeLetters = alternativeCharacters.stream().sorted().collect(Collectors.toList());
        return sortedWordLetters.equals(sortedAlternativeLetters);
    }
}
