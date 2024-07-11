package mystring;

public class No5 {
    // 给你一个字符串 s，找到 s 中最长的 回文 子串 。
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;

        int res = 1;
        String resStr = s.substring(0, 1);
        for (int i = 1; i < s.length(); i++) {
            int j = i;
            int k = i;
            int temp = 1;
            while (true) {
                if (temp > res) {
                    res = temp;
                    resStr = s.substring(k, j + 1);
                }
                j++;
                k--;
                if (j >= s.length() || k < 0) {
                    break;
                }

                if (s.charAt(k) == s.charAt(j)) {
                    temp += 2;
                } else {
                    break;
                }

            }
            // 暴力解法 未排除偶数情况
            if (s.charAt(i) == s.charAt(i - 1)) {
                temp = 2;
                j = i;
                k = i - 1;
                while (true) {
                    if (temp > res) {
                        res = temp;
                        resStr = s.substring(k, j + 1);
                    }
                    j++;
                    k--;
                    if (j >= s.length() || k < 0) {
                        break;
                    }

                    if (s.charAt(k) == s.charAt(j)) {
                        temp += 2;
                    } else {
                        break;
                    }

                }
            }


        }
        return resStr;
    }

    // 动态规划
    public String longestPalindrome2(String s) {
        int length = s.length();

        if(length < 2){
            return s;
        }
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[length][length];
        int max = 0, flag = 0;

        for (int i = 0; i < length - 1; i++) {
            dp[i][i] = true;
            dp[i][i + 1] = chars[i] == chars[i + 1];
            if(dp[i][i + 1]){
                flag = i;
                max = 1;
            }
        }
        dp[length - 1][length - 1] = true;


        for (int j = 2; j < length; j++) {
            int i = 0;
            while (i + j < length) {
                dp[i][i + j] = dp[i + 1][i + j - 1] && chars[i] == chars[i + j];
//                dp[i][i + j + 1] = dp[i + 1][i + j] && chars[i] == chars[i + j + 1];
                if(dp[i][i + j]){
                    if(j > max){
                        max = j;
                        flag = i;
                    }
                }
                i++;
            }
        }


//        System.out.println(flag + " " + max);
        return s.substring(flag, flag + max + 1);
    }


    public static void main(String[] args) {
        System.out.println(new No5().longestPalindrome("ccc"));
    }


}
