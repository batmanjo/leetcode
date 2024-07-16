package mystring;

import java.util.ArrayList;
import java.util.List;

public class No22 {

    public static void main(String[] args) {
        No22 no22 = new No22();
        List<String> strings = no22.generateParenthesis(3);
        for (String s : strings) {
            System.out.println(s);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        reverse(res, "", n, n);
        return res;
    }

    private void reverse(List<String> res, String s, int left, int right) {

        if(left > 0){
            String s1 = s + "(";
            reverse(res, s1, left - 1, right);
        }

        if(right > 0 && left < right){
            String s1 = s + ")";
            reverse(res, s1, left, right - 1);
        }

        if(left == 0 && right == 0){
            res.add(s);
        }
    }

    private void get(List<String> res, String s, int n, int count, int left) {

        if (left <= 0) {
            res.add(s);
        }
        String a = "";
        String b = "";
        a = s;
        b = s;
        if (count >= 0 && n > 0) {
            a = a + "(";
            get(res, a, n - 1, count + 1, left);
        }

        if (count > 0 && left > 0) {
            b = b + ")";
            get(res, b, n, count - 1, left - 1);
        }
    }


    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        get(res, "", n, 0, n);
        return res;

    }


}
