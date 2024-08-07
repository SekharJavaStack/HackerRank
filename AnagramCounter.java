//String Anagram
import java.util.*;

public class AnagramCounter {
    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        List<String> dict = new ArrayList<>();
        for (String word : dictionary) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            dict.add(new String(charArray));
        }
        
        List<String> q = new ArrayList<>();
        for (String word : query) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            q.add(new String(charArray));
        }
        
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        
        for (String word : dict) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        
        for (String word : q) {
            result.add(count.getOrDefault(word, 0));
        }
        
        return result;
    }
}

