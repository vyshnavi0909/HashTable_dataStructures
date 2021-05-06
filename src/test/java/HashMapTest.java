import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Locale;

public class HashMapTest {
    @Test
    public void givenSentence_WhenWordsAreAddedToList_shouldReturnWordFreq() {
        String sentence = "To be or not to be";
        NewHashMap<String, Integer> hashMap = new NewHashMap<>();
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words){
            Integer value = hashMap.get(word);
            if (value == null) {
                value = 1;
            }else {
                value++;
            }
            hashMap.add(word, value);
        }

        int freq = hashMap.get("to");
        System.out.println(hashMap);
        Assertions.assertEquals(2,freq);
    }
}

