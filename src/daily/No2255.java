package daily;

public class No2255 {
    public int countPrefixes(String[] words, String s) {
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            for (int j = 0; j < words[i].length(); j++) {
                if(j < s.length() && words[i].charAt(j) == s.charAt(j)) {
                    count++;
                }else{
                    break;
                }
            }
            if(count == words[i].length()) {
                res++;
            }
        }
        return res;
    }
}
