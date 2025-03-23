package daily;

public class No2116 {

    public boolean canBeValid(String s, String locked) {
        int count = 0;
        int stack = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && locked.charAt(i) == '1') {
                stack--;
            } else if (locked.charAt(i) == '0') {
                stack++;
                count++;
            } else {
                stack++;
            }
            if (stack == 0) {
                count = 0;
            }
            if (stack < 0) {
                return false;
            }
        }
        boolean res1 = stack % 2 == 0 && stack / 2 <= count;

        stack = 0;
        count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(' && locked.charAt(i) == '1') {
                stack--;
            } else if (locked.charAt(i) == '0') {
                stack++;
                count++;
            } else {
                stack++;
            }
            if (stack == 0) {
                count = 0;
            }
            if (stack < 0) {
                return false;
            }
        }
        boolean res2 = stack % 2 == 0 && stack / 2 <= count;
        return res2 && res1;
    }

    public static void main(String[] args) {
        No2116 self = new No2116();
        System.out.println(self.canBeValid("())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(", "100011110110011011010111100111011101111110000101001101001111"));
        System.out.println(self.canBeValid("))()))", "010100"));
        System.out.println(self.canBeValid("(((())(((())", "111111010111"));
    }
}
