/*
 * Copyright (C) by Courtanet, All Rights Reserved.
 */
package kata.anagrams;

import java.util.Set;

public interface IAnagrams {
    Set<String> computeAnagrams(String word, Set<String> alternatives);
}
