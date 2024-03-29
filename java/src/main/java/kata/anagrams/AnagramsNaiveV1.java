/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package kata.anagrams;

import java.util.HashSet;
import java.util.Set;

public class AnagramsNaiveV1 implements IAnagrams {
    @Override
    public Set<String> computeAnagrams(String word, Set<String> alternatives) {
        return computeAnagramsV1Naive(word, alternatives);
    }

    private Set<String> computeAnagramsV1Naive(String word, Set<String> alternatives) {
        if (word == null || alternatives == null) return null;
        Set<String> result = new HashSet<>();// Collections.<String>emptySet();
        for (String alternative : alternatives) {
            if (isAnagramV1Naive(word, alternative)) {
                result.add(alternative);
            }
        }
        return result;
    }

    private boolean isAnagramV1Naive(String word, String alternative) {
        for (char c : word.toCharArray()) {
            if(!contains(c,alternative) || (occurences(c, alternative) != occurences(c, word))){
                return false;
            }
        }
        return true;
    }

    private boolean contains(char c, String alternative) {
        for (char altC : alternative.toCharArray()) {
            if(altC == c) return true;
        }
        return false;
    }

    private long occurences(char c, String alternative) {
        long idx = 0;
        for (char altC : alternative.toCharArray()) {
            if (altC == c) {
                idx++;
            }
        }
        return idx;
    }

}
