package com.BackEnd;

import java.text.Normalizer;
import java.util.HashMap;
import java.util.Map;

public class TextProcessingService {
    public int countOccurrences(String content, String phrase) {
        int count = content.split("(?i)\\b" + phrase + "\\b").length - 1;

        return count;
    }

    public Map<String, Integer> countWordOccurrences(String content, String[] words) {
        String normalizedPageContent = normalizeString(content);
        Map<String, Integer> wordOccurrences = new HashMap<>();

        for (String word : words) {
            int count = countOccurrences(normalizedPageContent, "\\b" + word + "\\b");
            wordOccurrences.put(word, count);

        }

        return wordOccurrences;
    }

    private String normalizeString(String text) {
        return Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .replaceAll("[^\\p{IsAlphabetic}\\s]", "")
                .toLowerCase();
    }
}
