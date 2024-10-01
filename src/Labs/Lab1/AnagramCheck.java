package Labs.Lab1;

import java.util.HashMap;

public class AnagramCheck {

    public boolean isAnagram(String s, String t) {
        // If lengths are different, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        // Use a HashMap to count the frequency of each character in 's'
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        // Count frequency of each character in the first string 's'
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Subtract the frequency based on characters in the second string 't'
        for (char c : t.toCharArray()) {
            if (!charCountMap.containsKey(c)) {
                return false;  // 't' contains a character not found in 's'
            }
            charCountMap.put(c, charCountMap.get(c) - 1);
            if (charCountMap.get(c) == 0) {
                charCountMap.remove(c); // Remove the character if the count reaches 0
            }
        }

        // If the map is empty, then both strings are anagrams
        return charCountMap.isEmpty();
    }
}