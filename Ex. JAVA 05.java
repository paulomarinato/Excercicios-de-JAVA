import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Autocorrect {
    public static List<List<String>> getSearchResults(String[] words, String[] queries) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            anagramMap.computeIfAbsent(sortedWord, key -> new ArrayList<>()).add(word);
        }

        List<List<String>> results = new ArrayList<>();
        for (String query : queries) {
            char[] queryChars = query.toCharArray();
            Arrays.sort(queryChars);
            String sortedQuery = new String(queryChars);

            results.add(anagramMap.get(sortedQuery));
        }

        return results;
    }

    public static void main(String[] args) {
        String[] words = {"duel", "speed", "dule", "cars"};
        String[] queries = {"spede", "deul"};

        List<List<String>> searchResults = getSearchResults(words, queries);

        for (List<String> result : searchResults) {
            System.out.println(result);
        }
    }
}
