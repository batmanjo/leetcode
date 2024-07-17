package mystring;

public class No28 {

    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                for (int j = 1; j <= needle.length(); j++) {
                    if (j == needle.length()) {
                        return i;
                    }
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }

                }
            }
        }
        return -1;
    }

}
