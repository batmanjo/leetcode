package mystring;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class No32 {

    public static void main(String[] args) {
        No32 no32 = new No32();
        System.out.println(no32.longestValidParentheses("(()(((()"));
    }

    // 太丑陋了 不需要list存储 便利的时候同步去计算max todo 可优化
    public int longestValidParentheses(String s) {
        int a = 0;
        List<Foo> list = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                a++;
            } else {
                a--;
            }
            if (a == 0) {
                Foo foo = new Foo(start, i + 1, true);
                list.add(foo);
                start = i + 1;
            }

            if (a < 0) {
                Foo foo = new Foo(start, i + 1, false);
                list.add(foo);
                a = 0;
                start = i + 1;
            }
        }
        int end = s.length();
        int b = 0;
        List<Foo> list2 = new ArrayList<>();
        if (a > 0) {
            for (int i = s.length() - 1; i >= start; i--) {
                if (s.charAt(i) == ')') {
                    b++;
                } else {
                    b--;
                }
                if (b == 0) {
                    Foo foo = new Foo(i, end, true);
                    list2.add(foo);
                    end = i ;
                }

                if (b < 0) {
                    Foo foo = new Foo(end - 1, end , false);
                    list2.add(foo);
                    b = 0;
                    end = i;
                }
            }
        }
        for (int i = list2.size() - 1; i >= 0; i--) {
            list.add(list2.get(i));
        }
        int max = 0;
        int temp = 0;
        for (int i = 0; i < list.size(); i++) {
            Foo foo = list.get(i);
            if (foo.isValid) {
                temp = temp + foo.end - foo.start;
            } else {
                if (temp > max) {
                    max = temp;
                }
                temp = 0;
            }

        }

        if (temp > max) {
            max = temp;
        }
        return max;

    }

    class Foo {
        int start;
        int end;
        boolean isValid;

        public Foo(int start, int end, boolean isValid) {
            this.start = start;
            this.end = end;
            this.isValid = isValid;
        }
    }

    public int longestValidParentheses2(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    // dp..
    public int longestValidParentheses3(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }




}
