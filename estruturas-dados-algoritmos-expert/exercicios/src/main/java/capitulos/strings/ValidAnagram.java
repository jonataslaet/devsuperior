package capitulos.strings;

import java.util.HashMap;
import java.util.Map;
/*https://leetcode.com/problems/valid-anagram*/
public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if (sl != tl) return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        if (sl == 1) {
            return sArray[0] == tArray[0];
        }

        Map<Character, Integer> mapaS = new HashMap<>();
        Map<Character, Integer> mapaT = new HashMap<>();
        for (int i = 0; i < sl; i++) {
            if (!mapaS.containsKey(sArray[i])) {
                mapaS.put(sArray[i], 1);
            } else {
                mapaS.put(sArray[i], mapaS.get(sArray[i])+1);
            }
        }
        for (int i = 0; i < tl; i++) {
            if (!mapaT.containsKey(tArray[i])) {
                mapaT.put(tArray[i], 1);
            } else {
                mapaT.put(tArray[i], mapaT.get(tArray[i])+1);
            }
        }
        for (int i = 0; i < sl; i++) {
            if (!mapaT.containsKey(sArray[i]) || !mapaT.get(sArray[i]).equals(mapaS.get(sArray[i]))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String w1 = "rat";
        String w2 = "car";
        System.out.println(isAnagram(w1, w2));
    }
}
