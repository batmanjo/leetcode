package mystring;

import java.util.HashMap;
import java.util.Map;

public class No67 {


    public String addBinary(String a, String b) {
        char[] ca;
        char[] cb;
        if (a.length() > b.length()) {
            ca = a.toCharArray();
            cb = b.toCharArray();
        } else {
            ca = b.toCharArray();
            cb = a.toCharArray();
        }


        String res = "";
        char jin = 0;
        for (int i = 1; i <= ca.length; i++) {
            char p1 = (char) (ca[ca.length - i] - '0');
            char p2 = 0;
            if (i <= cb.length) {
                p2 = (char) (cb[cb.length - i] - 48);
            }

            int sum = p1 + p2 + jin;
            switch (sum) {
                case 0:
                    res = "0" + res;
                    jin = 0;
                    break;
                case 1:
                    res = "1" + res;
                    jin = 0;
                    break;
                case 2:
                    res = "0" + res;
                    jin = 1;
                    break;
                default:
                    res = "1" + res;
                    jin = 1;
            }
        }
        return jin == 1 ? "1" + res : res;
    }

    public static void main(String[] args) {
        No67 no67 = new No67();
        System.out.println(no67.addBinary("1", "11"));
    }
}
