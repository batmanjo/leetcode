package daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No2716 {

    public int minimizedStringLength(String s) {
        char[] charArray = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < charArray.length; i++) {
            set.add(charArray[i]);
        }
        return set.size();
    }
}
