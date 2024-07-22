package mystring;

public class No44 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        char[] pc = p.toCharArray();
        char[] sc = s.toCharArray();
        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;
        // 边界条件 p = 0 时注定不能匹配
        for (int i = 1; i <= m; i++) {
            dp[0][i] = false;
        }

        // 状态转移方程 何时dp[i][j] = true
        // 1. dp[i-1][j] && p[i-1] = * , dp[i-1][j] && p[i-2] = * && （p[i-1] = ? || s[j-1] = p[i-1])
        // dp[i-1][j] && p[i-2] = * && (p[i-1] = ? || s[j-1] = p[i-1]) 这一步在 3 包含了
        // 2. dp[i][j-1] && s[j-1] = p[i-1] && p[i-2] = *  , dp[i][j-1] && p[i-1] = *
        // dp[i][j-1] && s[j-1] = p[i-1] && p[i-2] = *  这一步也在3包含了
        // 3. dp[i-1][j-1] && (s[j-1] = p[i-1] || p[i-1] = ? *)

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if(j == 0){
                    dp[i][j] = pc[i - 1] == '*' && dp[i - 1][j];
                }else{
                    boolean a = pc[i - 1] == '*' && (dp[i - 1][j] || dp[i][j - 1]);
                    boolean b = dp[i - 1][j - 1] && (sc[j - 1] == pc[i - 1] || pc[i - 1] == '?');
                    dp[i][j] = a || b;
                }

            }
        }


        return dp[n][m];
    }
    // todo 双指针分割* 也可以实现
}
