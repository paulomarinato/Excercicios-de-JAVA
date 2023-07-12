import java.util.HashMap;
import java.util.Map;

public class StringCompression {
    public static String betterCompression(String S) {
        Map<Character, Integer> counts = new HashMap<>();
        int i = 0;
        while (i < S.length()) {
            char c = S.charAt(i);
            i++;
            int count = 0;
            while (i < S.length() && Character.isDigit(S.charAt(i))) {
                count = count * 10 + (S.charAt(i) - '0');
                i++;
            }
            counts.put(c, counts.getOrDefault(c, 0) + count);
        }

        StringBuilder compressedString = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts.containsKey(c)) {
                compressedString.append(c);
                compressedString.append(counts.get(c));
            }
        }

        return compressedString.toString();
    }

    public static void main(String[] args) {
        String S = "a12c56a1b5";
        String compressed = betterCompression(S);
        System.out.println(compressed);
    }
}

