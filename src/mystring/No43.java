package mystring;

import util.RandomUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class No43 {

    char[][][] mul = new char[10][10][2];
    char[][][] plu = new char[10][10][2];

    {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                String s = String.valueOf(i * j);
                if (s.length() == 1) {
                    s = "0" + s;
                }
                mul[i][j] = s.toCharArray();

                String s1 = String.valueOf(i + j);
                if (s1.length() == 1) {
                    s1 = "0" + s1;
                }
                plu[i][j] = s1.toCharArray();
            }
        }
    }

    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] cs1 = num1.toCharArray();
        char[] cs2 = num2.toCharArray();
        List<String> list = new ArrayList<>();
        String s0 = "";
        // 得到每一行的乘积
        for (int i = num1.length() - 1; i >= 0; i--) {
            char jin = 0;
            String s = "";
            for (int j = num2.length() - 1; j >= 0; j--) {
                char[] mul0 = mul[cs1[i] - '0'][cs2[j] - '0'];
                // 进位可能超过10
                char[] plu0 = plu[mul0[1] - '0'][jin];
                s = plu0[1] + s;
                // 这一步不会有两位数 最大 8 + 1
                jin = (char) (mul0[0] - '0' + plu0[0] - '0');
            }
            if (jin != 0) {
                s = (char) ('0' + jin) + s + s0;
            } else {
                s = s + s0;
            }
            list.add(s);
            s0 = s0 + "0";
        }

        // 累加乘积
        String he = "0";
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            int m = he.length() - 1;
            int n = s.length() - 1;
            String temp = "";
            char jin = 0;
            while (m >= 0 || n >= 0) {
                char a = '0';
                char b = s.charAt(n);
                if (m >= 0) {
                    a = he.charAt(m);
                }
                char[] plu0 = plu[a - '0'][b - '0'];
                char[] plu1 = plu[jin][plu0[1] - '0'];
                temp = plu1[1] + temp;
                jin = (char) (plu1[0] - '0' + plu0[0] - '0');
                m--;
                n--;
            }
            if (jin != 0) {
                temp = (char) ('0' + jin) + temp;
            }
            he = temp;
        }

        return he;
    }

    public static void main(String[] args) {
        No43 no43 = new No43();
        System.out.println(no43.multiply("956", "8425"));
        for (int i = 0; i < 100; i++) {
            String s1 = String.valueOf(RandomUtil.randomInt(10000));
            String s2 = String.valueOf(RandomUtil.randomInt(10000));
            String s3 = no43.multiply(s1, s2);
            Integer integer = Integer.valueOf(s1) * Integer.valueOf(s2);
            boolean equals = s3.equals(String.valueOf(integer));
            if(!equals){
                System.out.println(s1 + " * " + s2 + " = " + s3 + "  " + integer);
            }
        }
    }
}
