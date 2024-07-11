package mystring;

public class No3 {

    // 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度


    public int lengthOfLongestSubstring(String s) {

        // 特殊情况处理
        if (s.equals(" "))
            return 1;

        if (s == null || s.length() == 0) {
            return 0;
        }

        int fast = 0, slow = 0;
        int res = 1;

        for (int i = 0; i < s.length(); i++) {
            for (slow = fast; slow < i; slow++) {
                if (s.charAt(i) == s.charAt(slow)) {
                    res = Math.max(res, i - fast);
                    fast = slow + 1;
                }
            }
        }
        res = Math.max(res, s.length() - fast);
        return res;

    }

}
