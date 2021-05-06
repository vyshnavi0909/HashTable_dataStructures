import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedHashMapTest {
    @Test
    public void givenLargeSentence_whenWordsAreAddedToList_ShouldReturnParanoidFrequency(){
        String sentence = "Paranoids are not paranoid because they are paranoid but because " +
                "they keep putting themselves deliberately into paranoid avoidable situations";
        NewLinkedHashMap<String, Integer> newLinkedHashMap = new NewLinkedHashMap<>();
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words){
            Integer value = newLinkedHashMap.get(word);
            if (value == null) {
                value = 1;
            }else {
                value++;
            }
            newLinkedHashMap.add(word, value);
        }

        int freq = newLinkedHashMap.get("paranoid");
        System.out.println(newLinkedHashMap);
        Assertions.assertEquals(3,freq);
    }
}
