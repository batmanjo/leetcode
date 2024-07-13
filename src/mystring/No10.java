package mystring;

import util.RandomUtil;

public class No10 {



    public boolean isMatch(String s, String p) {
        int m = s.length() + 1, n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        dp[0][0] = true;
        for (int j = 2; j < n; j += 2)
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                // p0 never equals '*'
                dp[i][j] = p.charAt(j - 1) == '*' ?
                        dp[i][j - 2] || dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') :
                        dp[i - 1][j - 1] && (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1));
            }
        }
        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {
        No10 no10 = new No10();

        System.out.println(no10.isMatch("bba", "a*a*a*a*"));
        for (int i = 0; i < 10; i++) {
            System.out.println(no10.isMatch(RandomUtil.randomString(10, "abc"), RandomUtil.randomString(8, "abc.*")));
        }
    }
}
