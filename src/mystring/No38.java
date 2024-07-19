package mystring;

public class No38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        String s = "";
        String temp = "11";
        int count = 1;
        for (int i = 2; i < n; i++) {
            s = "";
            for (int j = 1; j < temp.length(); j++) {
                if (temp.charAt(j) != temp.charAt(j - 1)) {
                    s = s + count + temp.charAt(j - 1);
                    count = 1;
                } else {
                    count++;
                }
                if (j == temp.length() - 1) {
                    s = s + count + temp.charAt(j);
                    count = 1;
                }
            }
            temp = s;
        }
        return s;
    }

    public String countAndSay2(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                int count = 1;
                while (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) {
                    count++;
                    j++;
                }
                sb.append(count).append(s.charAt(j));
            }
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        No38 no38 = new No38();
        System.out.println(no38.countAndSay(4));
    }
}
