import com.BackEnd.TextProcessingService;
import org.junit.Test;

import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class TextProcessingServiceTest {
    @Test
    public void testCountOccurrences() {
        TextProcessingService textService = new TextProcessingService();
        String content = "Esta é uma frase de teste. Esta é outra frase de teste.";
        String phrase = "Esta";

        int count = textService.countOccurrences(content, phrase);

        assertEquals(2, count);
    }

    @Test
    public void testCountWordOccurrences() {
        TextProcessingService textService = new TextProcessingService();
        String content = "Java é uma linguagem de programação. Java é amplamente utilizada.";
        String[] words = {"Java", "é"};

        Map<String, Integer> wordOccurrences = textService.countWordOccurrences(content, words);

        assertEquals(Optional.of(2), wordOccurrences.get("Java"));
        assertEquals(Optional.of(2), wordOccurrences.get("é"));
    }
}

